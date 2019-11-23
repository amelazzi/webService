package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.server.entities.interfaces.IMedia;

@SuppressWarnings("serial")
@Entity
public class Media implements Serializable, IMedia {
	
	public Media() {
		this.uploadedAt = new Date();
		this.type=Type.image.name();
	}
	
	public enum Type{
	      image, video, document
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMedia;
	
	private String url;
	private Date uploadedAt;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	@Override
	public String getUrl() {
		return url;
	}
	
	@Override
	public void setUrl(String url) {
		this.url = url;
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
	public String getType() {
		return type;
	}
	
	@Override
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Media [idMedia=" + idMedia + ", url=" + url + ", uploadedAt=" + uploadedAt + ", type=" + type
				+ ", product=" + product + "]";
	}
	
}
