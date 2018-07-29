package com.MdinaBus.Models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {
 
	@Id
	@GeneratedValue
	private long matricule;
    
 
	protected Bus() {
	}
	
 
	
}