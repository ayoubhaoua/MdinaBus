package com.MdinaBus.Repositories;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

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
    	String h = pt.getHeure_arrivee().toString();
    	String geom = pt.getGeometrie();
        int res = jdbcTemplate.update(
        		"INSERT INTO pt_ramassage(nom,heure_arrivee,geometrie) VALUES ('"+nom+"','"+h+"','"+geom+"')"
        		);
        if(res>0)
        	return true;
        
        return false;
    }
}
