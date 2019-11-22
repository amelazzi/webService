package com.server.entities.impl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.server.entities.interfaces.IProduct;

@Entity
public class Product implements IProduct, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProduct;
	
	private float price;
	private String title;
	private String description;
	private Boolean available;
	private Date createdAt;
	private int quantity;
	
	
	public Product() throws RemoteException {
		this.createdAt = new Date();
	}
	
	@Override
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	@Override
	public long getIdProduct() {
		return idProduct;
	}
	
	@Override
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	
	@Override
	public float getPrice() {
		return price;
	}
	
	@Override
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public Boolean getAvailable() {
		return available;
	}
	
	@Override
	public void setAvailable(Boolean available) {
		this.available = available;
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
	public String toString() {
		return "Product [idProduct=" + idProduct + ", price=" + price + ", title=" + title + ", description="
				+ description + ", available=" + available + ", createdAt=" + createdAt + ", quantity=" + quantity
				+ "]";
	}

	
	
}
