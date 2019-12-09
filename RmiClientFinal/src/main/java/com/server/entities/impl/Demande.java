package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import com.server.entities.interfaces.IDemande;
import com.server.utils.DateTool;

@SuppressWarnings("serial")
public class Demande implements Serializable, IDemande{

	public Demande() {
		this.createdAt = new Date();
		this.isDone = false;
		this.desiredAt=new Date();
	}
	
	
	private long idDemande;
	private Date createdAt;
	private Date desiredAt;
	private Boolean isDone;
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
	public UserImpl getUser() {
		return user;
	}
	
	@Override
	public void setUser(UserImpl user) {
		this.user = user;
	}
	
	@Override
	public long getIdDemande() {
		return idDemande;
	}

	@Override
	public void setIdDemande(long id) {
		idDemande = id;
	}

	@Override
	public String toString() {
		return idDemande + ",'" + DateTool.dateToString(createdAt) + "','" + DateTool.dateToString(desiredAt)
				+ "'," + isDone + "," + product.getIdProduct() + "," + user.getIdUser();
	}
	
}
