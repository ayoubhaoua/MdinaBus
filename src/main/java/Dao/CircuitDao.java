package Dao;


import java.util.List;

import com.MdinaBus.Models.Circuit;


public interface CircuitDao {
	boolean save(Circuit cr);
	boolean edite(Circuit cr);
	String findGeometrieByid(long id);
	
}
