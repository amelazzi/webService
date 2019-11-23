package com.server.entities.interfaces;

import java.util.Date;

import com.server.entities.impl.Product;
import com.server.entities.impl.User;

public interface IEmprunt {
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public Boolean getIsReturned();
	public void setIsReturned(Boolean isReturned);
	public Product getProduct();
	public void setProduct(Product product);
	public User getUser();
	public void setUser(User user);
	public long getIdEmprunt();
}
