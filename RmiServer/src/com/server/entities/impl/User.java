package com.server.entities.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.server.entities.interfaces.IUser;

@SuppressWarnings("serial")
@Entity
public class User implements Serializable, IUser{
	
	public User() {
		this.registeredAt = new Date();
		this.role = Role.user.name();
		this.status =Status.student.name();
	}
	
	public enum Role{
	      user, admin
	}
	
	public enum Status{
	      student, teacher
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUser;
	private int matricule;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String role;
	private String status;
	private Date birthday;
	private String domain;
	private String graduate;
	private Date registeredAt;
	private List<Emprunt> emprunts;
	private List<Demande> demandes;
	private List<Comment> comments;
	
	@Override
	public int getMatricule() {
		return matricule;
	}
	
	@Override
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String getRole() {
		return role;
	}
	
	@Override
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String getStatus() {
		return status;
	}
	
	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public Date getBirthday() {
		return birthday;
	}
	
	@Override
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String getDomain() {
		return domain;
	}
	
	@Override
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	@Override
	public String getGraduate() {
		return graduate;
	}
	
	@Override
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	
	@Override
	public Date getRegisteredAt() {
		return registeredAt;
	}
	
	@Override
	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}
	
	@Override
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}
	
	@Override
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	@Override
	public List<Demande> getDemandes() {
		return demandes;
	}
	
	@Override
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	
	@Override
	public List<Comment> getComments() {
		return comments;
	}
	
	@Override
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public long getIdUser() {
		return idUser;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getPhone() {
		return phone;
	}
	
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", matricule=" + matricule + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", phone=" + phone + ", role=" + role
				+ ", status=" + status + ", birthday=" + birthday + ", domain=" + domain + ", graduate=" + graduate
				+ ", registeredAt=" + registeredAt + ", emprunts=" + emprunts + ", demandes=" + demandes + ", comments="
				+ comments + "]";
	}

}
