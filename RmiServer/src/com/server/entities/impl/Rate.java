package com.server.entities.impl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.server.entities.interfaces.IRate;

@SuppressWarnings("serial")
@Entity
public class Rate implements Serializable, IRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idRate;
	
	private int value;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
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
		return "Rate [IdRate=" + idRate + ", value=" + value + ", product=" + product + "]";
	}

}
