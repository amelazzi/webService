package com.server.entities.interfaces;

import java.util.Date;

import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;

public interface IDemande {
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public Date getDesiredAt();
	public void setDesiredAt(Date desiredAt);
	public Boolean getIsDone();
	public void setIsDone(Boolean isDone);
	public Product getProduct();
	public void setProduct(Product product);
	public UserImpl getUser();
	public void setUser(UserImpl user);
	public long getIdDemande();
	public void setIdDemande(long id);
}
