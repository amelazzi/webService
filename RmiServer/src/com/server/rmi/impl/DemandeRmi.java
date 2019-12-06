package com.server.rmi.impl;

import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.entities.interfaces.IDemande;
import com.server.rmi.interfaces.IDemandeRmi;
import com.server.service.impl.DemandeService;
import com.server.service.impl.ProductService;
import com.server.service.interfaces.IDemandeService;
import com.server.service.interfaces.IProductService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DemandeRmi extends UnicastRemoteObject implements IDemandeRmi {

    private IDemandeService service;

    public DemandeRmi() throws RemoteException{
        this.service = new DemandeService();
    }
    @Override
    public IDemande add(Demande entity) throws RemoteException {
        if(entity!=null) {
            service.add(entity);
            return entity;
        }

        return null;
    }

    @Override
    public IDemande update(Demande entity) throws RemoteException {
        if(entity!=null) {
            if(entity.getIdDemande()!= 0L) {
                service.update(entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public void remove(Demande demande) throws RemoteException {
        service.delete(demande);
    }

    @Override
    public IDemande findOneById(Long id) throws RemoteException {
        if(id!=0L) {
            return service.findOneById(id);
        }

        return null;
    }

    @Override
    public List<Demande> findAll() throws RemoteException {
        return service.findAll();
    }

    @Override
    public void removeAll() throws RemoteException {
        service.deleteAll();
    }

    @Override
    public List<UserImpl> findWaitingUserByProduct(Product product) throws RemoteException{
        return  service.findWaitingUserByProduct(product);
    }
}
