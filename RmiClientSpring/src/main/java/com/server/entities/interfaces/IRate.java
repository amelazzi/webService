package com.server.entities.interfaces;

import com.server.entities.impl.Product;

public interface IRate {
	
	public long getIdRate();

	public int getValue();

	public void setValue(int value);

	public Product getProduct();

	public void setProduct(Product product);
}
