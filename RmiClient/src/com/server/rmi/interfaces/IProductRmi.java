package com.server.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.server.entities.impl.Product;
import com.server.entities.interfaces.IProduct;

public interface IProductRmi extends Remote {
	
	public IProduct add(Product entity) throws RemoteException;

	public IProduct update(Product entity) throws RemoteException;

	public void remove(Product product) throws RemoteException;

	public IProduct findOneById(Long id) throws RemoteException;
	
	public List<Product> findAll() throws RemoteException;
	
	public void removeAll() throws RemoteException;

}
