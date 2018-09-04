package com.MdinaBus.Models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="location")
public class Location {

	@Id
	@GeneratedValue
	private long id;
	private long identite;
	private double prix;
	private Date fin;
	private String autre;
	
	
	
	
	public Location() {
	}
	public Location( long identite, double prix, Date fin, String autre) {
		super();
		this.identite = identite;
		this.prix = prix;
		this.fin = fin;
		this.autre = autre;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdentite() {
		return identite;
	}
	public void setIdentite(long identite) {
		this.identite = identite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	
	
	
}
