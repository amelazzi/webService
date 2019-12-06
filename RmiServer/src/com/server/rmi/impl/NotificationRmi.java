package com.server.rmi.impl;

import com.server.entities.impl.Notification;
import com.server.entities.interfaces.INotification;
import com.server.rmi.interfaces.INotificationRmi;
import com.server.service.impl.NotificationService;
import com.server.service.impl.ProductService;
import com.server.service.interfaces.INotificationService;
import com.server.service.interfaces.IProductService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NotificationRmi extends UnicastRemoteObject implements INotificationRmi {

    private INotificationService service;

    public NotificationRmi() throws RemoteException{
        this.service = new NotificationService();
    }

    @Override
    public INotification add(Notification entity) throws RemoteException {
        if(entity!=null) {
            service.save(entity);
            return entity;
        }

        return null;
    }

    @Override
    public INotification update(Notification entity) throws RemoteException {
        if(entity!=null) {
            if(entity.getIdNotification()!= 0L) {
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
    public INotification findOneById(Long id) throws RemoteException {
        if(id!=0L) {
            return service.findOneById(id);
        }

        return null;
    }

    @Override
    public List<Notification> findBy(String field, Object value) {
        return service.findBy(field, value);
    }

    @Override
    public List<Notification> findAll() throws RemoteException {
        return service.findAll();
    }

    @Override
    public void removeAll() throws RemoteException {
        service.deleteAll();
    }
}
