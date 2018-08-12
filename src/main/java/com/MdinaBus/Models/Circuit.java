package com.MdinaBus.Models;






import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "circuit")
public class Circuit  {
 

	@Id
	@GeneratedValue
	@Column(columnDefinition="SERIAL")
	private long id;
	private String nom;
    private double kilometrage_circuit;
    private double km_HLP;
    private long id_service;
    private String autre;
    @Column(name="geometrie", columnDefinition="geometry")
	private String geometrie; 
    
    
 
	public Circuit() {
	}



	public Circuit(String nom, double kilometrage_circuit, double km_HLP, Time heure_depart, Time heure_arrivee,
			Date date, long id_service, String autre, String geometrie) {
		super();
		this.nom = nom;
		this.kilometrage_circuit = kilometrage_circuit;
		this.km_HLP = km_HLP;
		this.id_service = id_service;
		this.autre = autre;
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



	public double getKilometrage_circuit() {
		return kilometrage_circuit;
	}



	public void setKilometrage_circuit(double kilometrage_circuit) {
		this.kilometrage_circuit = kilometrage_circuit;
	}



	public double getKm_HLP() {
		return km_HLP;
	}



	public void setKm_HLP(double km_HLP) {
		this.km_HLP = km_HLP;
	}


	public long getId_service() {
		return id_service;
	}



	public void setId_service(long id_service) {
		this.id_service = id_service;
	}



	public String getAutre() {
		return autre;
	}



	public void setAutre(String autre) {
		this.autre = autre;
	}



	public String getGeometrie() {
		return geometrie;
	}



	public void setGeometrie(String geometrie) {
		this.geometrie = geometrie;
	}


	
}