package com.server.entities.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.server.entities.interfaces.IProduct;

@SuppressWarnings("serial")
public class Product implements IProduct, Serializable {

	private long idProduct;
	
	private float price;
	private String title;
	private String description;
	private Boolean available;
	private Date createdAt;
	private int quantity;
	
	private List<Rate> rates;

	private List<Comment> comments;
	
	private List<Emprunt> emprunts;
	
	private List<Demande> demandes;
	
	private List<Media> medias;
	
	
	public Product(){
		this.createdAt = new Date();
		this.rates = new ArrayList<Rate>();
		this.comments = new ArrayList<Comment>();
		this.emprunts = new ArrayList<Emprunt>();
		this.demandes = new ArrayList<Demande>();
		this.medias = new ArrayList<Media>();
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
	public List<Rate> getRates() {
		return rates;
	}
	
	@Override
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}
	
	@Override
	public List<Comment> getComments() {
		return comments;
	}
	
	@Override
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}
	
	@Override
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	@Override
	public List<Demande> getDemandes() {
		return demandes;
	}
	
	@Override
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	
	@Override
	public List<Media> getMedias() {
		return medias;
	}
	
	@Override
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", price=" + price + ", title=" + title + ", description="
				+ description + ", available=" + available + ", createdAt=" + createdAt + ", quantity=" + quantity + "]";
	}

	
	
}
