package com.MdinaBus.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roulement")
public class Roulement {
	@Id
	@GeneratedValue
	private long id;
	private String entite;
	private String date;
    private double hlp;
	private String circuit;
	private String machiniste;
	private String accompagnatrice;
	private String bus;
	
	
	
	
	
	
	public Roulement(long id, String entite, String date, double hlp, String circuit, String machiniste,
			String accompagnatrice, String bus) {
		super();
		this.id = id;
		this.entite = entite;
		this.date = date;
		this.hlp = hlp;
		this.circuit = circuit;
		this.machiniste = machiniste;
		this.accompagnatrice = accompagnatrice;
		this.bus = bus;
	}






	public Roulement() {
		
	}






	public long getId() {
		return id;
	}






	public void setId(long id) {
		this.id = id;
	}






	public String getEntite() {
		return entite;
	}






	public void setEntite(String entite) {
		this.entite = entite;
	}






	public String getDate() {
		return date;
	}






	public void setDate(String date) {
		this.date = date;
	}






	public double getHlp() {
		return hlp;
	}






	public void setHlp(double hlp) {
		this.hlp = hlp;
	}






	public String getCircuit() {
		return circuit;
	}






	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}






	public String getMachiniste() {
		return machiniste;
	}






	public void setMachiniste(String machiniste) {
		this.machiniste = machiniste;
	}






	public String getAccompagnatrice() {
		return accompagnatrice;
	}






	public void setAccompagnatrice(String accompagnatrice) {
		this.accompagnatrice = accompagnatrice;
	}






	public String getBus() {
		return bus;
	}






	public void setBus(String bus) {
		this.bus = bus;
	}
	
}