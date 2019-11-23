package com.server.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.server.dao.interfaces.IProduitDao;
import com.server.entities.impl.Product;
import com.server.service.interfaces.IProduitService;

@Transactional
public class ProduitServiceImpl implements IProduitService{
	
	private IProduitDao dao;
	
	/*
	public ProductServiceImpl(ProductDaoImpl dao) {
		this.dao = dao;
	}*/

	public void setDao(IProduitDao dao) {
		this.dao = dao;
	}

	@Override
	public Product save(Product entity) {
		return dao.save(entity);
	}

	@Override
	public Product update(Product entity) {
		return dao.update(entity);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public Product findOneById(Long id) {
		return dao.findOneById(id);
	}

	@Override
	public Product findOneBy(String field, Object value) {
		return dao.findOneBy(field, value);
	}

	@Override
	public Product findOneBy(String[] fields, Object[] values) {
		return dao.findOneBy(fields, values);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Product> findAllSortedBy(String field, String order) {
		return dao.findAllSortedBy(field, order);
	}

	@Override
	public int countBy(String field, String value) {
		return dao.countBy(field, value);
	}

}
