package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.server.entities.interfaces.INotification;

@SuppressWarnings("serial")
@Entity
public class Notification implements Serializable, INotification {
	
	public Notification() {
		this.sendAt=new Date();
		this.isRead=false;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long IdNotification;
	
	private String message;
	
	private Date sendAt;
	
	private boolean isRead;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private UserImpl user;
	
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
	public UserImpl getUser() {
		return user;
	}
	
	@Override
	public void setUser(UserImpl user) {
		this.user = user;
	}
	
	@Override
	public long getIdNotification() {
		return IdNotification;
	}

	@Override
	public String toString() {
		return "Notification [IdNotification=" + IdNotification + ", message=" + message + ", sendAt=" + sendAt
				+ ", isRead=" + isRead  + "]";
	}
	
	
	
}
