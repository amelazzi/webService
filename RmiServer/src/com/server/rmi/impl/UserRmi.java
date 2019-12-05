package com.server.rmi.impl;

import com.server.entities.impl.UserImpl;
import com.server.entities.interfaces.IProduct;
import com.server.entities.interfaces.IUser;
import com.server.rmi.interfaces.IUserRmi;
import com.server.service.impl.ProductService;
import com.server.service.impl.UserService;
import com.server.service.interfaces.IProductService;
import com.server.service.interfaces.IUserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class UserRmi extends UnicastRemoteObject implements IUserRmi {
    private IUserService service;

    public UserRmi() throws RemoteException{
        this.service = new UserService();
    }


    @Override
    public IUser add(UserImpl entity) throws RemoteException {
        if(entity!=null) {
            service.add(entity);
            return entity;
        }

        return null;
    }

    @Override
    public IUser update(UserImpl entity) throws RemoteException {
        if(entity!=null) {
            if(entity.getIdUser()!= 0L) {
                service.update(entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public void remove(UserImpl user) throws RemoteException {
        service.delete(user);
    }

    @Override
    public IUser findOneById(Long id) throws RemoteException {
        if(id!=0L) {
            return service.findOneById(id);
        }
        return null;
    }

    @Override
    public List<UserImpl> findAll() throws RemoteException {
        return service.findAll();
    }

    @Override
    public void removeAll() throws RemoteException {
        service.deleteAll();
    }

    @Override
    public boolean login(String email, String password) throws RemoteException {
        return service.checkLogin(email, password);
    }
}
