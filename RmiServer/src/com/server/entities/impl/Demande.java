package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.server.entities.interfaces.IDemande;

@SuppressWarnings("serial")
@Entity
public class Demande implements Serializable, IDemande{

	public Demande() {
		this.createdAt = new Date();
		this.isDone = false;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDemande;
	private Date createdAt;
	private Date desiredAt;
	private Boolean isDone;
	private Product product;
	private User user;
	
	@Override
	public Date getCreatedAt() {
		return createdAt;
	}
	
	@Override
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public Date getDesiredAt() {
		return desiredAt;
	}
	
	@Override
	public void setDesiredAt(Date desiredAt) {
		this.desiredAt = desiredAt;
	}
	
	@Override
	public Boolean getIsDone() {
		return isDone;
	}
	
	@Override
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
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
	public long getIdDemande() {
		return idDemande;
	}
	
	@Override
	public String toString() {
		return "Demande [idDemande=" + idDemande + ", createdAt=" + createdAt + ", desiredAt=" + desiredAt + ", isDone="
				+ isDone + ", product=" + product + ", user=" + user + "]";
	}
	
}
