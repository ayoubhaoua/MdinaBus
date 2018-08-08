package com.MdinaBus.Models;






import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.LineString;


@Entity
@Table(name = "circuit")
public class Circuit  {
 

	@Id
	@GeneratedValue
	private String id;
	private String nom;
    private double kilometrage_circuit;
    private double km_HLP;
    private Time heure_depart;
    private Time heure_arrivee;
    private Date date;
    private long id_contrat;
    private String autre;
    @Column(name="geometrie", columnDefinition="geometry")
	private String geometrie; 
    
    
 
	protected Circuit() {
	}



	public Circuit(String nom, double kilometrage_circuit, double km_HLP, Time heure_depart, Time heure_arrivee,
			Date date, long id_contrat, String autre, String geometrie) {
		super();
		this.nom = nom;
		this.kilometrage_circuit = kilometrage_circuit;
		this.km_HLP = km_HLP;
		this.heure_depart = heure_depart;
		this.heure_arrivee = heure_arrivee;
		this.date = date;
		this.id_contrat = id_contrat;
		this.autre = autre;
		this.geometrie = geometrie;
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



	public Time getHeure_depart() {
		return heure_depart;
	}



	public void setHeure_depart(Time heure_depart) {
		this.heure_depart = heure_depart;
	}



	public Time getHeure_arrivee() {
		return heure_arrivee;
	}



	public void setHeure_arrivee(Time heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public long getId_contrat() {
		return id_contrat;
	}



	public void setId_contrat(long id_contrat) {
		this.id_contrat = id_contrat;
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