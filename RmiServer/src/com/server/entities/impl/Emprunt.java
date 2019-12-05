package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.server.entities.interfaces.IEmprunt;
import com.server.utils.DateTool;

@SuppressWarnings("serial")
@Entity
@Table(
		uniqueConstraints = {@UniqueConstraint(columnNames={"idEmprunt","idproduct","iduser", "createdAt"})}
)
public class Emprunt implements Serializable, IEmprunt{
	
	public Emprunt() {
		this.createdAt = new Date();
		this.returnedAt = new Date();
		this.isReturned = false;
		this.setToGiveBackAt(this.returnIn(15));
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEmprunt;
	private Date createdAt;
	private Boolean isReturned;
	private Date returnedAt;
	private Date toGiveBackAt;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	@ManyToOne
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

	@Override
	public void setIdEmprunt(long idEmprunt) {this.idEmprunt = idEmprunt;}
	
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
		return idEmprunt + ",'" + DateTool.dateToString(createdAt) + "'," + isReturned +  ",'"
				+ DateTool.dateToString(returnedAt) + "','" + DateTool.dateToString(toGiveBackAt)
				+ "'," + product.getIdProduct() + "," + user.getIdUser();
	}
}
