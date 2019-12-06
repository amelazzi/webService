package com.server.rmi.impl;

import com.server.entities.impl.Rate;
import com.server.entities.interfaces.IRate;
import com.server.rmi.interfaces.IRateRmi;
import com.server.service.impl.RateService;
import com.server.service.interfaces.IRateService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RateRmi extends UnicastRemoteObject implements IRateRmi {
    private IRateService service;

    public RateRmi() throws RemoteException{
        this.service = new RateService();
    }
    @Override
    public IRate add(Rate entity) throws RemoteException {
        if(entity!=null) {
            service.add(entity);
            return entity;
        }

        return null;
    }

    @Override
    public IRate update(Rate entity) throws RemoteException {
        if(entity!=null) {
            if(entity.getIdRate()!= 0L) {
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
    public IRate findOneById(Long id) throws RemoteException {
        if(id!=0L) {
            return service.findOneById(id);
        }

        return null;
    }

    @Override
    public List<Rate> findBy(String field, String value) throws RemoteException {
        return null;
    }

    @Override
    public List<Rate> findBy(String[] fields, Object[] values) throws RemoteException {
        return null;
    }

    @Override
    public List<Rate> findAll() throws RemoteException {
        return service.findAll();
    }

    @Override
    public List<Rate> findAllSortedBy(String field, String order) throws RemoteException {
        return null;
    }

    @Override
    public void removeAll() throws RemoteException {
        service.deleteAll();
    }
}
