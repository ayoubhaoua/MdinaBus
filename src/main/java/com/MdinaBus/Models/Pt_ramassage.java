package com.MdinaBus.Models;



import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pt_ramassage")
public class Pt_ramassage  {
 
	
	@Id
	@GeneratedValue
	private String id;
	private String adresse ;
	private Date heure_arrivee;
	private int decalage;
	private int nbr_eleves;
	private String id_circuit;
	private String autre;
	
	
 
	protected Pt_ramassage() {
	}



	public Pt_ramassage(String adresse, Date heure_arrivee, int decalage, int nbr_eleves, String id_circuit,
			String autre) {
		super();
		this.adresse = adresse;
		this.heure_arrivee = heure_arrivee;
		this.decalage = decalage;
		this.nbr_eleves = nbr_eleves;
		this.id_circuit = id_circuit;
		this.autre = autre;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public Date getHeure_arrivee() {
		return heure_arrivee;
	}



	public void setHeure_arrivee(Date heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}



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
	}



	public String getId_circuit() {
		return id_circuit;
	}



	public void setId_circuit(String id_circuit) {
		this.id_circuit = id_circuit;
	}



	public String getAutre() {
		return autre;
	}



	public void setAutre(String autre) {
		this.autre = autre;
	}
 
	
}