package com.MdinaBus.Models;

import java.util.ArrayList;

public class Listecrs {
	
	private ArrayList<Circuit> crs= new ArrayList<>();
	
	public void addcircuit(Circuit cr) {
        this.crs.add(cr);
    }

	public ArrayList<Circuit> getCrs() {
		return crs;
	}

	public void setCrs(ArrayList<Circuit> crs) {
		this.crs = crs;
	}
	
	
}
