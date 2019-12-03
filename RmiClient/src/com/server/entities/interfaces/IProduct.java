package com.server.entities.interfaces;

import java.util.Date;
import java.util.List;

import com.server.entities.impl.Comment;
import com.server.entities.impl.Demande;
import com.server.entities.impl.Emprunt;
import com.server.entities.impl.Media;
import com.server.entities.impl.Rate;

public interface IProduct{
	public long getIdProduct();
	public void setIdProduct(long id);
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
	public List<Rate> getRates();
	public void setRates(List<Rate> rates);
	public List<Comment> getComments();
	public void setComments(List<Comment> comments);
	public List<Emprunt> getEmprunts();
	public void setEmprunts(List<Emprunt> emprunts);
	public List<Demande> getDemandes();
	public void setDemandes(List<Demande> demandes);
	public List<Media> getMedias();
	public void setMedias(List<Media> medias);
}
