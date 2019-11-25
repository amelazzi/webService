package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.server.entities.interfaces.IDemande;

@SuppressWarnings("serial")
@Entity
@Table(
		uniqueConstraints = {@UniqueConstraint(columnNames={"idDemande","idproduct","iduser", "createdAt"})}
)
public class Demande implements Serializable, IDemande{

	public Demande() {
		this.createdAt = new Date();
		this.isDone = false;
		this.desiredAt=new Date();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDemande;
	private Date createdAt;
	private Date desiredAt;
	private Boolean isDone;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idProduct")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idUser")
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
	public String toString() {
		return "Demande [idDemande=" + idDemande + ", createdAt=" + createdAt + ", desiredAt=" + desiredAt + ", isDone="
				+ isDone + ", product=" + product + ", user=" + user + "]";
	}
	
}
