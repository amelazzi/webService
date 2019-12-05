package com.server.entities.interfaces;

import java.util.Date;
import java.util.List;

import com.server.entities.impl.Comment;
import com.server.entities.impl.Demande;
import com.server.entities.impl.Emprunt;

public interface IUser {
	public int getMatricule();
	public void setMatricule(int matricule);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getRole();
	public void setRole(String role);
	public String getStatus();
	public void setStatus(String status);
	public Date getBirthday();
	public void setBirthday(Date birthday);
	public String getDomain();
	public void setDomain(String domain);
	public String getGraduate();
	public void setGraduate(String graduate);
	public Date getRegisteredAt();
	public void setRegisteredAt(Date registeredAt);
	public List<Emprunt> getEmprunts();
	public void setEmprunts(List<Emprunt> emprunts);
	public List<Demande> getDemandes();
	public void setDemandes(List<Demande> demandes);
	public List<Comment> getComments();
	public void setComments(List<Comment> comments);
	public long getIdUser();
	public void setIdUser(long id);
	public String getEmail();
	public void setEmail(String email);
	public String getPassword();
	public void setPassword(String password);
	public String getPhone();
	public void setPhone(String phone);
}
