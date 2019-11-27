package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import com.server.entities.interfaces.IEmprunt;

@SuppressWarnings("serial")

public class Emprunt implements Serializable, IEmprunt{
	
	public Emprunt() {
		this.createdAt = new Date();
		this.isReturned = false;
		this.setToGiveBackAt(this.returnIn(15));
	}
	
	private long idEmprunt;
	private Date createdAt;
	private Boolean isReturned;
	private Date returnedAt;
	private Date toGiveBackAt;
	
	private Product product;
	
	private UserImpl user;
	
	@Override
	public Date getCreatedAt() {
		return createdAt;
	}
	
	@Override
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public Boolean getIsReturned() {
		return isReturned;
	}
	
	@Override
	public void setIsReturned(Boolean isReturned) {
		this.isReturned = isReturned;
	}
	
	@Override
	public Product getProduct() {
		return product;
	}
	
	@Override
	public void setProduct(Product product) {
		this.product = product;
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
	public long getIdEmprunt() {
		return idEmprunt;
	}
	
	public Date returnIn(int days) {
		int d = days*24;
		Date today = new Date();
		return new Date(today.getTime() + (1000 * 60 * 60 * d));
	}

	public Date getReturnedAt() {
		return returnedAt;
	}

	public void setReturnedAt(Date returnedAt) {
		this.returnedAt = returnedAt;
	}

	public Date getToGiveBackAt() {
		return toGiveBackAt;
	}

	public void setToGiveBackAt(Date toGiveBackAt) {
		this.toGiveBackAt = toGiveBackAt;
	}

	@Override
	public String toString() {
		return "Emprunt [idEmprunt=" + idEmprunt + ", createdAt=" + createdAt + ", isReturned=" + isReturned
				+ ", product=" + product + ", user=" + user + "]";
	}
}
