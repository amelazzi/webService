package com.server.entities.interfaces;

import java.util.Date;

import com.server.entities.impl.Demande;
import com.server.entities.impl.UserImpl;

public interface INotification {
	
	public String getMessage();

	public void setMessage(String message);

	public Date getSendAt();

	public void setSendAt(Date sendAt);

	public void setIsRead(boolean isRead);

	public boolean getIsRead();

	public Demande getDemande();

	public void setDemande(Demande demande);

	public long getIdNotification();

	public void setIdNotification(long idNotification);
}
