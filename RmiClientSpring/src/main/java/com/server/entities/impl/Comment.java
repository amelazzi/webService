package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;

import com.server.entities.interfaces.IComment;
import com.server.utils.DateTool;

@SuppressWarnings("serial")
public class Comment implements Serializable, IComment {
	
	
	public Comment() {
		this.createdAt = new Date();
	}
	private long idComment;
	private String content;
	private Date createdAt;
	private Product product;
	private UserImpl user;
	
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
	public UserImpl getUser() {
		return user;
	}
	
	@Override
	public void setUser(UserImpl user) {
		this.user = user;
	}
	
	@Override
	public long getIdComment() {
		return idComment;
	}

	@Override
	public void setIdComment(long idComment) {
		this.idComment = idComment;
	}
	
	@Override
	public String toString() {
		return idComment + ",'" + content + "','" + DateTool.dateToString(createdAt) + "',"
				+ product.getIdProduct() + "," + user.getIdUser();
	}
	
}
