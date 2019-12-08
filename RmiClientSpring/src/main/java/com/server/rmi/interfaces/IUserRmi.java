package com.server.rmi.interfaces;

import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.entities.interfaces.IProduct;
import com.server.entities.interfaces.IUser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUserRmi extends Remote {
    public IUser add(UserImpl entity) throws RemoteException;

    public IUser update(UserImpl entity) throws RemoteException;

    public void remove(UserImpl user) throws RemoteException;

    public IUser findOneById(Long id) throws RemoteException;

    public List<UserImpl> findAll() throws RemoteException;

    public void removeAll() throws RemoteException;

    public boolean login(String email, String password) throws RemoteException;

}
