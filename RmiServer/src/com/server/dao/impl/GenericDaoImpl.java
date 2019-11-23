package com.server.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.server.dao.interfaces.IGenericDao;

@SuppressWarnings("unchecked")
public class GenericDaoImpl<E> implements IGenericDao<E> {
	
	@PersistenceContext
	EntityManager em;
	
	private Class<E> entityClass;
	
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entityClass = (Class<E>) pt.getActualTypeArguments()[0];
	}
	
	public Class<E> getEntityClass() {
		return entityClass;
	}

	@Override
	public E save(E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		return em.merge(entity);
	}

	@Override
	public void remove(Long id) {
		E item = em.getReference(entityClass, id);
		em.remove(item);
	}

	@Override
	public E findOneById(Long id) {
		return em.find(entityClass, id);
	}

	@Override
	public E findOneBy(String field, Object value) {
		Query query = em.createQuery("select t from "+entityClass.getSimpleName()+" t"
				+ "where "+field+" =: x");
		query.setParameter(field, value);
		return query.getResultList().size()>0 ?(E) query.getResultList().get(0):null;
	}

	@Override
	public E findOneBy(String[] fields, Object[] values) {
		if(fields.length != values.length) return null;
		
		String sql = "select t from "+entityClass.getSimpleName()+" t"
				+ "where ";
		int len = fields.length;
		for(int i = 0; i< len; i++ ) {
			sql += "t."+fields[i]+" =: x"+i;
			if((i+1)<len) sql+= "and";
		}
		
		Query query = em.createQuery(sql);
		for(int i=0; i<len; i++) {
			query.setParameter("x"+i, values[i]);
		}
		
		return query.getResultList().size() >0?(E) query.getResultList().get(0):null;
	}

	@Override
	public List<E> findAll() {
		Query query = em.createQuery("select t from "+entityClass.getSimpleName()+" t");
		return query.getResultList();
	}

	@Override
	public List<E> findAllSortedBy(String field, String order) {
		Query query = em.createQuery("select t from "+entityClass.getSimpleName()+" t order by "+field
				+ " "+order);
		return query.getResultList();
	}

	@Override
	public int countBy(String field, String value) {
		Query query = em.createQuery("select t from "+entityClass.getSimpleName()+" t"
				+ "where "+field+" =: x");
		query.setParameter(field, value);
		return query.getResultList().size()>0 ?((Long) query.getSingleResult()).intValue():0;
	}

}
