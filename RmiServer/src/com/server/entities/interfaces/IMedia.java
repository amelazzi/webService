package com.server.entities.interfaces;

import java.io.File;
import java.util.Date;

import com.server.entities.impl.Product;

public interface IMedia {
	public String getName();
	public void setName(String name);
	public Date getUploadedAt();
	public void setUploadedAt(Date uploadedAt);
	public Product getProduct();
	public void setProduct(Product product);
	public long getIdMedia() ;
	public void setIdMedia(long idMedia);
	public byte[] getImage();
	public void setImage(byte[] image);

}
