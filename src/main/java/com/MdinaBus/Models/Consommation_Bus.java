package com.MdinaBus.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consommation_bus")
public class Consommation_Bus {


	@Id
	@GeneratedValue
	private long id;
	private String date;
	private String entite;
    private String circuit;
    private String bus;
    private String machiniste;
    private long gasoil;

	
	
	
	
    
 
	public  Consommation_Bus() {
	}







	public Consommation_Bus(long id, String date, String entite, String circuit, String bus, String machiniste,
			long gasoil) {
		super();
		this.id = id;
		this.date = date;
		this.entite = entite;
		this.circuit = circuit;
		this.bus = bus;
		this.machiniste = machiniste;
		this.gasoil = gasoil;
	}







	public long getId() {
		return id;
	}







	public void setId(long id) {
		this.id = id;
	}







	public String getDate() {
		return date;
	}







	public void setDate(String String) {
		this.date = String;
	}







	public String getEntite() {
		return entite;
	}







	public void setEntite(String entite) {
		this.entite = entite;
	}







	public String getCircuit() {
		return circuit;
	}







	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}







	public String getBus() {
		return bus;
	}







	public void setBus(String bus) {
		this.bus = bus;
	}







	public String getMachiniste() {
		return machiniste;
	}







	public void setMachiniste(String machiniste) {
		this.machiniste = machiniste;
	}







	public long getGasoil() {
		return gasoil;
	}







	public void setGasoil(long gasoil) {
		this.gasoil = gasoil;
	}
	





}