package com.MdinaBus.Models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abonnement")
public class Abonnement {

	@Id
	private long id;
	private double prix;
	private boolean isFraterie;
	private boolean isBouskora;
	private Date debut;
	private Date fin;
	private String autre;
	
	
	
	
	public Abonnement() {
		
	}
	
	
	public Abonnement(long id, double prix, boolean isFraterie, boolean isBouskora, Date debut, Date fin,
			String autre) {
		super();
		this.id = id;
		this.prix = prix;
		this.isFraterie = isFraterie;
		this.isBouskora = isBouskora;
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isFraterie() {
		return isFraterie;
	}
	public void setFraterie(boolean isFraterie) {
		this.isFraterie = isFraterie;
	}
	public boolean isBouskora() {
		return isBouskora;
	}
	public void setBouskora(boolean isBouskora) {
		this.isBouskora = isBouskora;
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
