package com.server.entities.impl;

import java.io.Serializable;

import com.server.entities.interfaces.IRate;

@SuppressWarnings("serial")
public class Rate implements Serializable, IRate {
	private long idRate;
	
	private int value;
	private Product product;
	
	@Override
	public long getIdRate() {
		return idRate;
	}

	@Override
	public void setIdRate(long idRate){this.idRate = idRate;}
	
	@Override
	public int getValue() {
		return value;
	}
	
	@Override
	public void setValue(int value) {
		this.value = value;
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
	public String toString() {
		return idRate + "," + value + "," + product.getIdProduct();
	}

}
