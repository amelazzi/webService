package com.server.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


import com.server.entities.impl.Product;
import com.server.entities.interfaces.IProduct;
import com.server.rmi.interfaces.IProductRmi;
import com.server.service.impl.ProductService;
import com.server.service.interfaces.IProductService;

@SuppressWarnings("serial")
public class ProductRmi extends UnicastRemoteObject implements IProductRmi {
	
	private IProductService service;
	
	public ProductRmi() throws RemoteException{
		this.service = new ProductService();
	}

	@Override
	public IProduct add(Product entity) throws RemoteException {
		if(entity!=null) {
			service.save(entity);
			return entity;
		}
		
		return null;
	}

	@Override
	public IProduct update(Product entity) throws RemoteException {
		if(entity!=null) {
			if(entity.getIdProduct()!= 0L) {
				service.update(entity);
				return entity;
			}
		}
		return null;
	}

	@Override
	public void remove(Long id) throws RemoteException {
		service.delete(id);
		
	}

	@Override
	public IProduct findOneById(Long id) throws RemoteException {
		if(id!=0L) {
			return service.findOneById(id);
		}
		
		return null;
		
	}

	@Override
	public List<Product> findAll() throws RemoteException {
		return service.findAll();
	}
	
	@Override
	public void removeAll() throws RemoteException {
		service.deleteAll();
	}


}
