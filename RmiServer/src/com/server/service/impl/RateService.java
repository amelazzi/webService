package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.RateDaoImpl;
import com.server.entities.impl.Rate;
import com.server.service.interfaces.IRateService;

 
public class RateService implements IRateService{
 
    private static RateDaoImpl rateDao;
 
    public RateService() {
        rateDao = new RateDaoImpl();
    }
    
    public RateDaoImpl rateDao() {
        return rateDao;
    }

	@Override
	public long getMaxId() {
		return rateDao.getMaxId();
	}

	@Override
    public Rate add(Rate entity) {
    	try {
    		if(entity!=null) {
    			//rateDao.openCurrentSessionwithTransaction();
                rateDao.add(entity);
                //rateDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (Exception e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Rate update(Rate entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdRate()!=0L) {
    				//rateDao.openCurrentSessionwithTransaction();
    	            rateDao.update(entity);
    	            //rateDao.closeCurrentSessionwithTransaction();
    	            return entity;
    			}
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	@Override
	public void delete(Rate rate) {
		try {
			//if(id!=0L) {
				//rateDao.openCurrentSessionwithTransaction();
		        //Rate rate = rateDao.findOneById(id);
		        rateDao.delete(rate);
		        //rateDao.closeCurrentSessionwithTransaction();
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Rate findOneById(Long id) {
		try {
			if(id!=0L) {
				//rateDao.openCurrentSession();
		        Rate rate = rateDao.findOneById(id);
		        //rateDao.closeCurrentSession();
		        return rate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Rate> findAll() {
    	try {
    		//rateDao.openCurrentSession();
            List<Rate> rates = rateDao.findAll();
            //rateDao.closeCurrentSession();
            return rates;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		//rateDao.openCurrentSessionwithTransaction();
            rateDao.deleteAll();
            //rateDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public List<Rate> findBy(String field, Object value) {
		// TODO Auto-generated method stub
		List<Rate> rates = rateDao.findBy(field, value);
		return rates;
	}

	@Override
	public List<Rate> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rate> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}

