package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.server.entities.interfaces.IComment;

@SuppressWarnings("serial")
@Entity
public class Comment implements Serializable, IComment {
	
	
	public Comment() {
		this.createdAt = new Date();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idComment;
	private String content;
	private Date createdAt;
	private Product product;
	private User user;
	
	@Override
	public String getContent() {
		return content;
	}
	
	@Override
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public Date getCreateAt() {
		return createdAt;
	}
	
	@Override
	public void setCreateAt(Date createAt) {
		this.createdAt = createAt;
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
	public long getIdComment() {
		return idComment;
	}
	
	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", content=" + content + ", createdAt=" + createdAt + ", product="
				+ product + ", user=" + user + "]";
	}
	
}
