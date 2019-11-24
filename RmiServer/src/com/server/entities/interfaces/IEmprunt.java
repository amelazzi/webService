package com.server.entities.interfaces;

import java.util.Date;

import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;

public interface IEmprunt {
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public Boolean getIsReturned();
	public void setIsReturned(Boolean isReturned);
	public Product getProduct();
	public void setProduct(Product product);
	public UserImpl getUser();
	public void setUser(UserImpl user);
	public long getIdEmprunt();
}
