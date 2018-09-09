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
	private String nom;
    private double kilometrage;
    private double HLP;
	private long identite;
	private double prix;
	private Date fin;
	private String autre;
	
	
	
	
	public Location() {
	}
	
	public Location(long id, String nom, double kilometrage, double HLP, long identite, double prix,
			Date fin, String autre) {
		super();
		this.id = id;
		this.nom = nom;
		this.kilometrage = kilometrage;
		this.HLP = HLP;
		this.identite = identite;
		this.prix = prix;
		this.fin = fin;
		this.autre = autre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public double getHLP() {
		return HLP;
	}

	public void setHLP(double HLP) {
		this.HLP = HLP;
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
