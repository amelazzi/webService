package com.server.rmi.interfaces;

import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.entities.interfaces.IDemande;
import com.server.entities.interfaces.IProduct;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDemandeRmi extends Remote {
    public IDemande add(Demande entity) throws RemoteException;

    public IDemande update(Demande entity) throws RemoteException;

    public void remove(Long id) throws RemoteException;

    public IDemande findOneById(Long id) throws RemoteException;

    public List<Demande> findAll() throws RemoteException;

    public void removeAll() throws RemoteException;

    public List<UserImpl> findWaitingUserByProduct(Product product) throws RemoteException;
}
