package com.server.entities.impl;

import java.io.Serializable;

import com.server.entities.interfaces.IRate;

@SuppressWarnings("serial")
public class Rate implements Serializable, IRate {
	
	private long IdRate;
	
	private int value;
	
	private Product product;
	
	@Override
	public long getIdRate() {
		return IdRate;
	}
	
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
		return "Rate [IdRate=" + IdRate + ", value=" + value + ", product=" + product + "]";
	}

}
