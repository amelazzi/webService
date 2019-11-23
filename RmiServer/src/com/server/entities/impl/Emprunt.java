package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.server.entities.interfaces.IEmprunt;

@SuppressWarnings("serial")
@Entity
public class Emprunt implements Serializable, IEmprunt{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEmprunt;
	private Date createdAt;
	private Boolean isReturned;
	private Product product;
	private User user;
	
	public Emprunt() {
		this.createdAt = new Date();
		this.isReturned = false;
	}
	
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
	public User getUser() {
		return user;
	}
	
	@Override
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public long getIdEmprunt() {
		return idEmprunt;
	}

	@Override
	public String toString() {
		return "Emprunt [idEmprunt=" + idEmprunt + ", createdAt=" + createdAt + ", isReturned=" + isReturned
				+ ", product=" + product + ", user=" + user + "]";
	}
}
