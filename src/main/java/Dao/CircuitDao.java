package Dao;

import java.util.ArrayList;

import com.MdinaBus.Models.Circuit;


public interface CircuitDao {
	boolean save(Circuit cr);
	int savekml(ArrayList<Circuit> crs);
}
