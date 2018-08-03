package com.MdinaBus.Models;






import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "circuit")
public class Circuit  {
 

	@Id
	@GeneratedValue
	private String id;
    private double kilometrage_circuit;
    private double km_HLP;
    private Date heure_depart;
    private Date heure_arrivee;
    private Date date;
    private String id_contrat;
    private String autre;
    @Column(name="geometrie", columnDefinition="geometry")
	private LineString geometrie; 
    
    
 
	protected Circuit() {
	}



	public Circuit(String id, double kilometrage_circuit, double km_HLP, Date heure_depart, Date heure_arrivee,
			Date date, String id_contrat, String autre, LineString geometrie) {
		super();
		this.id = id;
		this.kilometrage_circuit = kilometrage_circuit;
		this.km_HLP = km_HLP;
		this.heure_depart = heure_depart;
		this.heure_arrivee = heure_arrivee;
		this.date = date;
		this.id_contrat = id_contrat;
		this.autre = autre;
		this.geometrie = geometrie;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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



	public Date getHeure_depart() {
		return heure_depart;
	}



	public void setHeure_depart(Date heure_depart) {
		this.heure_depart = heure_depart;
	}



	public Date getHeure_arrivee() {
		return heure_arrivee;
	}



	public void setHeure_arrivee(Date heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getId_contrat() {
		return id_contrat;
	}



	public void setId_contrat(String id_contrat) {
		this.id_contrat = id_contrat;
	}



	public String getAutre() {
		return autre;
	}



	public void setAutre(String autre) {
		this.autre = autre;
	}



	public LineString getGeometrie() {
		return geometrie;
	}



	public void setGeometrie(LineString geometrie) {
		this.geometrie = geometrie;
	}




	
	
}