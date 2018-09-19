package com.MdinaBus.Repositories;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Pt_ramassage;

import Dao.Pt_ramassageDao;

@Repository
public class Pt_ramassageDaoImpl extends JdbcDaoSupport implements Pt_ramassageDao {
	@Autowired 
    DataSource dataSource;
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
 
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    
    @Override
    public boolean save(Pt_ramassage pt) {
    	
    	String nom = pt.getNom();
    	String h1 = pt.getHeure_arrivee();
    	String h2 = pt.getHeure_deppart();
    	String geom = pt.getGeometrie();
    	long idc = pt.getIdcircuit();
        int res = jdbcTemplate.update(
        		"INSERT INTO pt_ramassage(nom,heure_arrivee,heure_deppart,geometrie,idcircuit) VALUES ('"+nom+"','"+h1+"','"+h2+"','"+geom+"','"+idc+"')"
        		);
        if(res>0)
        	return true;
        
        return false;
    }
    
    @Override
    public boolean edite(Pt_ramassage pt) {
    	long id = pt.getId();
    	String nom = pt.getNom();
    	 String h = pt.getHeure_arrivee();
         String h1=pt.getHeure_deppart();
         int res = jdbcTemplate.update(
         		"UPDATE pt_ramassage SET heure_arrivee='"+h+"',heure_deppart='"+h1+"', nom='"+nom+"' WHERE id="+id+";"
         		);
        if(res>0)
        	return true;
        
        return false;
    }
    
    @Override
    public List<String> findGeometrieByid(long id) {
    	List<String> geom=new ArrayList<>();
    	try {
    	     String sql = "SELECT ST_AsText(GEOMETRIE) FROM pt_ramassage WHERE idcircuit ='"+id+ "'";
    	     geom= jdbcTemplate.queryForList(sql, String.class);
    	} 
    	catch (EmptyResultDataAccessException e) {
    	}
    	return geom;
    }
    
    
    
    
    @Override
    public Map<String, List<Double>> getXYN(long id) {
    	
    	     String sql = "SELECT ST_Y(pt_ramassage.geometrie) AS Y ,ST_X(pt_ramassage.geometrie) AS X ,nom FROM pt_ramassage WHERE idcircuit ='"+id+ "'";
    	     Map<String, List<Double>> listX=new HashMap<String, List<Double>>();
    	     
    	     //List<Map> rows = getJdbcTemplate().queryForList(sql);
    	     List<java.util.Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
    	     for (java.util.Map<String, Object> row : rows) {
    	    	 List<Double> list=new ArrayList<>();
    	    	 list.add((Double) row.get("X"));
    	    	 list.add((Double) row.get("Y"));
    	    	 listX.put((String)row.get("nom"), (List<Double>) list);
    	     } 
    	     
    	 
    	
    	return listX; 
    }
   
    
    
}
