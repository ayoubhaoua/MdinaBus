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
	private long id_entite;
	private double prix;
	private Date debut;
	private Date fin;
	private String autre;
	
	
	
	
	public Location( long id_entite, double prix, Date debut, Date fin, String autre) {
		super();
		this.id_entite = id_entite;
		this.prix = prix;
		this.debut = debut;
		this.fin = fin;
		this.autre = autre;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_entite() {
		return id_entite;
	}
	public void setId_entite(long id_entite) {
		this.id_entite = id_entite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
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
