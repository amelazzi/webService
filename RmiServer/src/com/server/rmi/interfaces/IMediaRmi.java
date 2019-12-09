package com.server.rmi.interfaces;

import com.server.entities.impl.Media;
import com.server.entities.interfaces.IMedia;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IMediaRmi extends Remote {
    public IMedia add(Media entity) throws RemoteException;

    public IMedia update(Media entity) throws RemoteException;

    public void remove(Long id) throws RemoteException;

    public IMedia findOneById(Long id) throws RemoteException;

    public List<Media> findAll() throws RemoteException;

    public void removeAll() throws RemoteException;
}
