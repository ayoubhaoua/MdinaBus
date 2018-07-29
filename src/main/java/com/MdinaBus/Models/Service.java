package com.MdinaBus.Models;

import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
	@Id
	@GeneratedValue
	private String id;
	private Date date_debut;
	private Date date_fin;
	private String type;
    private double prix;
    private boolean is_fraterie ;
    private boolean is_bouskoura ;
    private String id_entite;
    private String autre;
    
    
	public Service(Date date_debut, Date date_fin, String type, double prix, boolean is_fraterie, boolean is_bouskoura,
			String id_entite, String autre) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.type = type;
		this.prix = prix;
		this.is_fraterie = is_fraterie;
		this.is_bouskoura = is_bouskoura;
		this.id_entite = id_entite;
		this.autre = autre;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public boolean isIs_fraterie() {
		return is_fraterie;
	}


	public void setIs_fraterie(boolean is_fraterie) {
		this.is_fraterie = is_fraterie;
	}


	public boolean isIs_bouskoura() {
		return is_bouskoura;
	}


	public void setIs_bouskoura(boolean is_bouskoura) {
		this.is_bouskoura = is_bouskoura;
	}


	public String getId_entite() {
		return id_entite;
	}


	public void setId_entite(String id_entite) {
		this.id_entite = id_entite;
	}


	public String getAutre() {
		return autre;
	}


	public void setAutre(String autre) {
		this.autre = autre;
	}
    
}
