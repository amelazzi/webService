package com.server.entities.interfaces;

import java.util.Date;

public interface IProduct{
	public long getIdProduct() ;
	public void setIdProduct(long idProduct);
	public float getPrice() ;
	public void setPrice(float price) ;
	public String getTitle() ;
	public void setTitle(String title) ;
	public String getDescription() ;
	public void setDescription(String description) ;
	public Boolean getAvailable() ;
	public void setAvailable(Boolean available) ;
	public Date getCreatedAt() ;
	public void setCreatedAt(Date createdAt) ;
	public int getQuantity() ;
	public void setQuantity(int quantity) ;
}
