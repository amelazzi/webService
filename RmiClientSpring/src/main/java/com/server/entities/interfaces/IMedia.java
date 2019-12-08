package com.server.entities.interfaces;

import java.util.Date;

import com.server.entities.impl.Product;

public interface IMedia {
	public String getUrl();
	public void setUrl(String url);
	public Date getUploadedAt();
	public void setUploadedAt(Date uploadedAt);
	public Product getProduct();
	public void setProduct(Product product);
	public long getIdMedia() ;
	public String getType();
	public void setType(String type);
}
