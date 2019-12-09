package com.server.entities.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.server.entities.interfaces.IMedia;
import com.server.utils.DateTool;

@SuppressWarnings("serial")
@Entity
public class Media implements Serializable, IMedia {
	
	public Media() {
		this.uploadedAt = new Date();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMedia;
	
	private String name;
	private Date uploadedAt;
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Date getUploadedAt() {
		return uploadedAt;
	}
	
	@Override
	public void setUploadedAt(Date uploadedAt) {
		this.uploadedAt = uploadedAt;
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
	public long getIdMedia() {
		return idMedia;
	}

	@Override
	public void setIdMedia(long idMedia) {
		this.idMedia = idMedia;
	}

	@Override
	public byte[] getImage() {
		return this.image;
	}

	@Override
	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return idMedia + ",'" + name + "','" + DateTool.dateToString(uploadedAt) + "'," + product.getIdProduct()
				+ "," + image;
	}
	
}
