package com.MdinaBus.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salarie")

public class Salarie {
	@Id
	@GeneratedValue
	private String id;
	private String nom;
	private String prenom;
	private long numero_telephone;
	private String fonctionnalite;
	private String autre;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public long getNumero_telephone() {
		return numero_telephone;
	}
	public void setNumero_telephone(long numero_telephone) {
		this.numero_telephone = numero_telephone;
	}
	public String getFonctionnalite() {
		return fonctionnalite;
	}
	public void setFonctionnalite(String fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	public Salarie(String nom, String prenom, long numero_telephone, String fonctionnalite, String autre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero_telephone = numero_telephone;
		this.fonctionnalite = fonctionnalite;
		this.autre = autre;
	}
	
	
	

}
