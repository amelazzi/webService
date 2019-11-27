package com.server.rmi.impl;

import com.server.entities.impl.Media;
import com.server.entities.impl.Product;
import com.server.entities.interfaces.IMedia;
import com.server.entities.interfaces.IProduct;
import com.server.rmi.interfaces.IMediaRmi;
import com.server.service.impl.MediaService;
import com.server.service.impl.ProductService;
import com.server.service.interfaces.IMediaService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MediaRmi extends UnicastRemoteObject implements IMediaRmi {

    private IMediaService service;

    public MediaRmi() throws RemoteException{
        this.service = new MediaService();
    }

    @Override
    public IMedia add(Media entity) throws RemoteException {
        if(entity!=null) {
            service.save(entity);
            return entity;
        }

        return null;
    }

    @Override
    public IMedia update(Media entity) throws RemoteException {
        if(entity!=null) {
            if(entity.getIdMedia()!= 0L) {
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
    public IMedia findOneById(Long id) throws RemoteException {
        if(id!=0L) {
            return service.findOneById(id);
        }

        return null;
    }

    @Override
    public List<Media> findAll() throws RemoteException {
        return service.findAll();
    }

    @Override
    public void removeAll() throws RemoteException {
        service.deleteAll();
    }
}
