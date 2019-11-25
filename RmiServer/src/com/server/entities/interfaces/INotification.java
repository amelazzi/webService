package com.server.entities.interfaces;

import java.util.Date;

import com.server.entities.impl.UserImpl;

public interface INotification {
	
	public String getMessage();

	public void setMessage(String message);

	public Date getSendAt();

	public void setSendAt(Date sendAt);

	public boolean isRead();

	public void setRead(boolean isRead);

	public UserImpl getUser();

	public void setUser(UserImpl user);

	public long getIdNotification();
}
