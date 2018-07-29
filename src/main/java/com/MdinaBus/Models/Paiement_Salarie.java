package com.MdinaBus.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paiement_salarie")

public class Paiement_Salarie {
	@Id
	@GeneratedValue
	private String id;
	private Date annee_paiement;
	private int mois;
	private double salaire;
	private String id_employe;
	private String autre;
	public Paiement_Salarie(Date annee_paiement, int mois, double salaire, String id_employe, String autre) {
		super();
		this.annee_paiement = annee_paiement;
		this.mois = mois;
		this.salaire = salaire;
		this.id_employe = id_employe;
		this.autre = autre;
	}
	public Date getAnnee_paiement() {
		return annee_paiement;
	}
	public void setAnnee_paiement(Date annee_paiement) {
		this.annee_paiement = annee_paiement;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public String getId_employe() {
		return id_employe;
	}
	public void setId_employe(String id_employe) {
		this.id_employe = id_employe;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	

}
