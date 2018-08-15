package com.MdinaBus.Models;




import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "pt_ramassage")
public class Pt_ramassage  {
 
	
	@Id
	@GeneratedValue
	@Column(columnDefinition="SERIAL")
	private long id;
	private String nom;
	//private String adresse ;
	private Time heure_arrivee;
	/*private int decalage;
	private int nbr_eleves;*/
	//private String idcircuit;
	//private String autre;
	@Column(name="geometrie", columnDefinition="geometry")
	private String geometrie; 
	
	
 
	public Pt_ramassage() {
	}

	
/*

	public Pt_ramassage(String id, String nom, String adresse, Time heure_arrivee, int decalage, int nbr_eleves,
			String id_circuit, String autre, String geometrie) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.heure_arrivee = heure_arrivee;
		this.decalage = decalage;
		this.nbr_eleves = nbr_eleves;
		this.id_circuit = id_circuit;
		this.autre = autre;
		this.geometrie = geometrie;
	}

*/





	public Pt_ramassage(String nom, Time heure_arrivee ,String geometrie) {
		super();

		this.nom = nom;
		this.heure_arrivee=heure_arrivee;
		this.geometrie = geometrie;
	}


	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}


/*
	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

*/

	public Time getHeure_arrivee() {
		return heure_arrivee;
	}



	public void setHeure_arrivee(Time heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}


/*
	public int getDecalage() {
		return decalage;
	}



	public void setDecalage(int decalage) {
		this.decalage = decalage;
	}



	public int getNbr_eleves() {
		return nbr_eleves;
	}



	public void setNbr_eleves(int nbr_eleves) {
		this.nbr_eleves = nbr_eleves;
	}*/



	/*public String getId_circuit() {
		return idcircuit;
	}



	public void setId_circuit(String id_circuit) {
		this.idcircuit = id_circuit;
	}*/



	/*public String getAutre() {
		return autre;
	}



	public void setAutre(String autre) {
		this.autre = autre;
	}

*/

	public String getGeometrie() {
		return geometrie;
	}



	public void setGeometrie(String geometrie) {
		this.geometrie = geometrie;
	}

	
	
}