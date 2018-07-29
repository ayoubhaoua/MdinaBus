package com.MdinaBus.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abonne")
public class Abonne {
	@Id
	@GeneratedValue
	private String id;
	private String tuteur;
	private String benificiaire;
	private String type_abonnement;
	private String type_reglement;
	private String adresse;
	private int age;
	private long num_telephone;
	private String id_pt_ramassage;
	private String id_entite;
	private String autre;
	public Abonne(String tuteur, String benificiaire, String type_abonnement, String type_reglement, String adresse,
			int age, long num_telephone, String id_pt_ramassage, String id_entite, String autre) {
		super();
		this.tuteur = tuteur;
		this.benificiaire = benificiaire;
		this.type_abonnement = type_abonnement;
		this.type_reglement = type_reglement;
		this.adresse = adresse;
		this.age = age;
		this.num_telephone = num_telephone;
		this.id_pt_ramassage = id_pt_ramassage;
		this.id_entite = id_entite;
		this.autre = autre;
	}
	public String getTuteur() {
		return tuteur;
	}
	public void setTuteur(String tuteur) {
		this.tuteur = tuteur;
	}
	public String getBenificiaire() {
		return benificiaire;
	}
	public void setBenificiaire(String benificiaire) {
		this.benificiaire = benificiaire;
	}
	public String getType_abonnement() {
		return type_abonnement;
	}
	public void setType_abonnement(String type_abonnement) {
		this.type_abonnement = type_abonnement;
	}
	public String getType_reglement() {
		return type_reglement;
	}
	public void setType_reglement(String type_reglement) {
		this.type_reglement = type_reglement;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getNum_telephone() {
		return num_telephone;
	}
	public void setNum_telephone(long num_telephone) {
		this.num_telephone = num_telephone;
	}
	public String getId_pt_ramassage() {
		return id_pt_ramassage;
	}
	public void setId_pt_ramassage(String id_pt_ramassage) {
		this.id_pt_ramassage = id_pt_ramassage;
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
