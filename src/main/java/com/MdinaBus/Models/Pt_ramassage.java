package com.MdinaBus.Models;





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
	private String heure_arrivee;
	private long idcircuit;
	@Column(name="geometrie", columnDefinition="geometry")
	private String geometrie; 
	
	
 
	public Pt_ramassage() {
	}



	public Pt_ramassage(String nom, String heure_arrivee, long idcircuit, String geometrie) {
		super();
		this.nom = nom;
		this.heure_arrivee = heure_arrivee;
		this.idcircuit = idcircuit;
		this.geometrie = geometrie;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getHeure_arrivee() {
		return heure_arrivee;
	}



	public void setHeure_arrivee(String heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}



	public long getIdcircuit() {
		return idcircuit;
	}



	public void setIdcircuit(long idcircuit) {
		this.idcircuit = idcircuit;
	}



	public String getGeometrie() {
		return geometrie;
	}



	public void setGeometrie(String geometrie) {
		this.geometrie = geometrie;
	}

	
}