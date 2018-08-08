package com.MdinaBus.Repositories;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.cr_ramassage;
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
        double km_HLP=cr.getKm_HLP();
        
    	String geom = cr.getGeometrie();
        int res = jdbcTemplate.update(
        		"INSERT INTO circuit(nom,heure_arrivee,geometrie) VALUES ('"+nom+"','"+h+"','"+geom+"')"
        		);
        if(res>0)
        	return true;
        
        return false;
    }
    private String id;
    private double kilometrage_circuit;
    private double km_HLP;
    private Date heure_depart;
    private Date heure_arrivee;
    private Date date;
    private String id_contrat;
    private String autre;
    @Column(name="geometrie", columnDefinition="geometry")
	private LineString geometrie;
	

}
