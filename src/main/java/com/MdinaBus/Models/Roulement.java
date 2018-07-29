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
	private String id;
	private Date date;
    private double hlp;
	private String id_circuit;
	private String id_salarie;
	private String id_bus;
	private String autres_remarques;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getHlp() {
		return hlp;
	}
	public void setHlp(double hlp) {
		this.hlp = hlp;
	}
	public String getId_circuit() {
		return id_circuit;
	}
	public void setId_circuit(String id_circuit) {
		this.id_circuit = id_circuit;
	}
	public String getId_salarie() {
		return id_salarie;
	}
	public void setId_salarie(String id_salarie) {
		this.id_salarie = id_salarie;
	}
	public String getId_bus() {
		return id_bus;
	}
	public void setId_bus(String id_bus) {
		this.id_bus = id_bus;
	}
	public String getAutres_remarques() {
		return autres_remarques;
	}
	public void setAutres_remarques(String autres_remarques) {
		this.autres_remarques = autres_remarques;
	}
	public Roulement(Date date, double hlp, String id_circuit, String id_salarie, String id_bus,
			String autres_remarques) {
		super();
		this.date = date;
		this.hlp = hlp;
		this.id_circuit = id_circuit;
		this.id_salarie = id_salarie;
		this.id_bus = id_bus;
		this.autres_remarques = autres_remarques;
	}
	
	
	
}
