package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import com.server.entities.interfaces.INotification;
import com.server.utils.DateTool;

@SuppressWarnings("serial")
public class Notification implements Serializable, INotification {
	
	public Notification() {
		this.sendAt=new Date();
		this.isRead=false;
	}

	private long idNotification;
	private String message;
	private Date sendAt;
	private boolean isRead;
	private Demande demande;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public Date getSendAt() {
		return sendAt;
	}
	
	@Override
	public void setSendAt(Date sendAt) {
		this.sendAt = sendAt;
	}
	
	@Override
	public boolean isRead() {
		return isRead;
	}
	
	@Override
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	@Override
	public Demande getDemande() {
		return null;
	}

	@Override
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	
	@Override
	public long getIdNotification() {
		return idNotification;
	}

	@Override
	public void setIdNotification(long idNotification) {
		this.idNotification = idNotification;
	}

	@Override
	public String toString() {
		return idNotification + "," + isRead + ",'" + message + "','" +
				DateTool.dateToString(sendAt) + "'," + demande.getIdDemande();
	}
	
	
	
}
