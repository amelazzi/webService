package com.server.rmi.impl;

import com.server.entities.impl.Comment;
import com.server.entities.interfaces.IComment;
import com.server.rmi.interfaces.ICommentRmi;
import com.server.service.impl.CommentService;
import com.server.service.interfaces.ICommentService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CommentRmi extends UnicastRemoteObject implements ICommentRmi {

    private ICommentService service;

    public CommentRmi() throws RemoteException{
        this.service = new CommentService();
    }

    @Override
    public IComment add(Comment entity) throws RemoteException {
        if(entity!=null) {
            service.save(entity);
            return entity;
        }
        return null;
    }

    @Override
    public IComment update(Comment entity) throws RemoteException {
        if(entity!=null) {
            if(entity.getIdComment()!= 0L) {
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
    public IComment findOneById(Long id) throws RemoteException {
        if(id!=0L) {
            return service.findOneById(id);
        }

        return null;
    }

    @Override
    public List<Comment> findAll() throws RemoteException {
        return service.findAll();
    }

    @Override
    public void removeAll() throws RemoteException {
        service.deleteAll();
    }
}
