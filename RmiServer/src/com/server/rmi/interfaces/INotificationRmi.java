package com.server.rmi.interfaces;

import com.server.entities.impl.Notification;
import com.server.entities.interfaces.INotification;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface INotificationRmi extends Remote {
    public INotification add(Notification entity) throws RemoteException;

    public INotification update(Notification entity) throws RemoteException;

    public void remove(Notification notification) throws RemoteException;

    public INotification findOneById(Long id) throws RemoteException;

    public List<Notification> findBy(String field, Object value) throws RemoteException;

    public List<Notification> findAll() throws RemoteException;

    public void removeAll() throws RemoteException;
}
