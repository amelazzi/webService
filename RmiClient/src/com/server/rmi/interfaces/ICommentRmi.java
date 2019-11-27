package com.server.rmi.interfaces;

import com.server.entities.impl.Comment;
import com.server.entities.interfaces.IComment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICommentRmi extends Remote {
    public IComment add(Comment entity) throws RemoteException;

    public IComment update(Comment entity) throws RemoteException;

    public void remove(Long id) throws RemoteException;

    public IComment findOneById(Long id) throws RemoteException;

    public List<Comment> findAll() throws RemoteException;

    public void removeAll() throws RemoteException;
}
