package com.server.rmi.interfaces;

import com.server.entities.impl.Rate;
import com.server.entities.interfaces.IRate;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRateRmi extends Remote {
    public IRate add(Rate entity) throws RemoteException;

    public IRate update(Rate entity) throws RemoteException;

    public void remove(Long id) throws RemoteException;

    public IRate findOneById(Long id) throws RemoteException;

    public List<Rate> findBy(String field, String value) throws RemoteException;

    public List<Rate> findBy(String[] fields, Object[] values) throws RemoteException;

    public List<Rate> findAll() throws RemoteException;

    public List<Rate> findAllSortedBy(String field, String order) throws RemoteException;

    public void removeAll() throws RemoteException;
}
