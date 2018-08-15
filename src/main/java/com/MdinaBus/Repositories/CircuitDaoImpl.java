package com.MdinaBus.Repositories;

import java.sql.Time;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Circuit;

import com.vividsolutions.jts.geom.LineString;

import Dao.CircuitDao;


@Repository
public class CircuitDaoImpl extends JdbcDaoSupport implements CircuitDao {
	
	@Autowired 
    DataSource dataSource;
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
 
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    
    @Override
    public boolean save(Circuit cr) {
    	String nom = cr.getNom();
        double kilometrage_circuit = cr.getKilometrage_circuit();
        double hlp = cr.getKm_HLP();
        long id_service=cr.getidservice();
        String autre=cr.getAutre();
    	String geom = cr.getGeometrie();
        int res = jdbcTemplate.update(
        		"INSERT INTO circuit(nom,kilometrage_circuit,km_HLP,idservice,autre,geometrie) VALUES ('"+nom+"','"+kilometrage_circuit+"','"+hlp+"','"+id_service+"','"+autre+"','"+geom+"')"
        		);
        if(res>0)
        	return true;
        
        return false;
    }
    
	

}
