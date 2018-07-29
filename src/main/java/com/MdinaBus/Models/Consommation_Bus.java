package com.MdinaBus.Models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consommation_bus")
public class Consommation_Bus {


	@Id
	@GeneratedValue
	private String id;
	private Date date_consommation;
	private int panne;
	private String N_SD;
	private String code_article;
	private String designation;
	private String famille_consommation;
	private String modele;
	private double PMP;
	private int qte;
	private int vehicule;
	private String centre;
	private String Designation_complete;
	private double valeur;
	private long bus_matricule;
	private String autres_remarques;
	
	
	
	
    
 
	protected  Consommation_Bus() {
	}
	






	public Consommation_Bus(Date date_consommation, int panne, String n_SD, String code_article, String designation,
			String famille_consommation, String modele, double pMP, int qte, int vehicule, String centre,
			String designation_complete, double valeur, long bus_matricule, String autres_remarques) {
		super();
		this.date_consommation = date_consommation;
		this.panne = panne;
		N_SD = n_SD;
		this.code_article = code_article;
		this.designation = designation;
		this.famille_consommation = famille_consommation;
		this.modele = modele;
		PMP = pMP;
		this.qte = qte;
		this.vehicule = vehicule;
		this.centre = centre;
		Designation_complete = designation_complete;
		this.valeur = valeur;
		this.bus_matricule = bus_matricule;
		this.autres_remarques = autres_remarques;
	}







	public Date getDate_consommation() {
		return date_consommation;
	}






	public void setDate_consommation(Date date_consommation) {
		this.date_consommation = date_consommation;
	}






	public int getPanne() {
		return panne;
	}






	public void setPanne(int panne) {
		this.panne = panne;
	}






	public String getN_SD() {
		return N_SD;
	}






	public void setN_SD(String n_SD) {
		N_SD = n_SD;
	}






	public String getCode_article() {
		return code_article;
	}






	public void setCode_article(String code_article) {
		this.code_article = code_article;
	}






	public String getDesignation() {
		return designation;
	}






	public void setDesignation(String designation) {
		this.designation = designation;
	}






	public String getFamille_consommation() {
		return famille_consommation;
	}






	public void setFamille_consommation(String famille_consommation) {
		this.famille_consommation = famille_consommation;
	}






	public String getModele() {
		return modele;
	}






	public void setModele(String modele) {
		this.modele = modele;
	}






	public double getPMP() {
		return PMP;
	}






	public void setPMP(double pMP) {
		PMP = pMP;
	}






	public int getQte() {
		return qte;
	}






	public void setQte(int qte) {
		this.qte = qte;
	}






	public int getVehicule() {
		return vehicule;
	}






	public void setVehicule(int vehicule) {
		this.vehicule = vehicule;
	}






	public String getCentre() {
		return centre;
	}






	public void setCentre(String centre) {
		this.centre = centre;
	}






	public String getDesignation_complete() {
		return Designation_complete;
	}






	public void setDesignation_complete(String designation_complete) {
		Designation_complete = designation_complete;
	}






	public double getValeur() {
		return valeur;
	}






	public void setValeur(double valeur) {
		this.valeur = valeur;
	}






	public long getBus_matricule() {
		return bus_matricule;
	}






	public void setBus_matricule(long bus_matricule) {
		this.bus_matricule = bus_matricule;
	}






	public String getAutres_remarques() {
		return autres_remarques;
	}






	public void setAutres_remarques(String autres_remarques) {
		this.autres_remarques = autres_remarques;
	}
	
 

}
