package com.server.rmi.impl;

import com.server.entities.impl.Emprunt;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.entities.interfaces.IEmprunt;
import com.server.rmi.interfaces.IEmpruntRmi;
import com.server.service.impl.EmpruntService;
import com.server.service.impl.ProductService;
import com.server.service.interfaces.IEmpruntService;
import com.server.service.interfaces.IProductService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class EmpruntRmi extends UnicastRemoteObject implements IEmpruntRmi {
    private IEmpruntService service;

    public EmpruntRmi() throws RemoteException {
        this.service = new EmpruntService();
    }

    @Override
    public IEmprunt add(Emprunt entity) throws RemoteException {
        if(entity!=null) {
            service.add(entity);
            return entity;
        }

        return null;
    }

    @Override
    public IEmprunt update(Emprunt entity) throws RemoteException {
        if(entity!=null) {
            if(entity.getIdEmprunt()!= 0L) {
                service.update(entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public void remove(Emprunt emprunt) throws RemoteException {
        service.delete(emprunt);
    }

    @Override
    public IEmprunt findOneById(Long id) throws RemoteException {
        if(id!=0L) {
            return service.findOneById(id);
        }

        return null;

    }

    @Override
    public List<Emprunt> findAll() throws RemoteException {
        return service.findAll();
    }

    @Override
    public void removeAll() throws RemoteException {
        service.deleteAll();
    }

    @Override
    public int emprunter(Product product, UserImpl user) throws RemoteException{
        return service.emprunter(product, user);
    }

    @Override
    public boolean restituer(Emprunt emprunt) throws RemoteException{
        return service.restituer(emprunt);
    }
}
