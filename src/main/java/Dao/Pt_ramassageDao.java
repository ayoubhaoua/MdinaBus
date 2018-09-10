package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.MdinaBus.Models.Pt_ramassage;


public interface Pt_ramassageDao {
	boolean save(Pt_ramassage pt);
	String findGeometrieByid(long id);
	boolean edite(Pt_ramassage pt);
	Map<String, List<Double>> getXYN(long id);

	
}
