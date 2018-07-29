package com.MdinaBus.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paiement")
public class Paiement {
	@Id
	@GeneratedValue
	private String id;
	private Date date_paiement;
	private int montant_paye;
	private String mois_payes;
	private String id_service;
	private String id_abonne;
	private String autre;
	public Paiement(Date date_paiement, int montant_paye, String mois_payes, String id_service, String id_abonne,
			String autre) {
		super();
		this.date_paiement = date_paiement;
		this.montant_paye = montant_paye;
		this.mois_payes = mois_payes;
		this.id_service = id_service;
		this.id_abonne = id_abonne;
		this.autre = autre;
	}
	public Date getDate_paiement() {
		return date_paiement;
	}
	public void setDate_paiement(Date date_paiement) {
		this.date_paiement = date_paiement;
	}
	public int getMontant_paye() {
		return montant_paye;
	}
	public void setMontant_paye(int montant_paye) {
		this.montant_paye = montant_paye;
	}
	public String getMois_payes() {
		return mois_payes;
	}
	public void setMois_payes(String mois_payes) {
		this.mois_payes = mois_payes;
	}
	public String getId_service() {
		return id_service;
	}
	public void setId_service(String id_service) {
		this.id_service = id_service;
	}
	public String getId_abonne() {
		return id_abonne;
	}
	public void setId_abonne(String id_abonne) {
		this.id_abonne = id_abonne;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	
	

}
