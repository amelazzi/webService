package com.server.rmi.interfaces;

import com.server.entities.impl.Emprunt;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.entities.interfaces.IEmprunt;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IEmpruntRmi extends Remote {
    public IEmprunt add(Emprunt entity) throws RemoteException;

    public IEmprunt update(Emprunt entity) throws RemoteException;

    public void remove(Emprunt emprunt) throws RemoteException;

    public IEmprunt findOneById(Long id) throws RemoteException;

    public List<Emprunt> findAll() throws RemoteException;

    public void removeAll() throws RemoteException;

    public int emprunter(Product product, UserImpl user) throws Exception;

    public boolean restituer(Emprunt emprunt) throws RemoteException;
}
