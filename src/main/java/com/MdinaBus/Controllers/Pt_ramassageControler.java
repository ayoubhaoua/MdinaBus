package com.MdinaBus.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.MdinaBus.Models.Pt_ramassage;
import com.MdinaBus.Repositories.Pt_ramassageDaoImpl;
import com.MdinaBus.Repositories.Pt_ramassageRepo;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

@Controller
public class Pt_ramassageControler {

	@Autowired
	Pt_ramassageRepo pt_repo;
	
	@Autowired
	Pt_ramassageDaoImpl pt_dao;
	
	GeometryFactory geometryFactory = new GeometryFactory();
	Point pt = geometryFactory.createPoint(new Coordinate(50, 60));
	
	
	@GetMapping("/point")
	public String point(Model model) {
		model.addAttribute("points", pt_repo.findAll());
		model.addAttribute("point", new Pt_ramassage());
		return"pt_ramassage";
	}
	@PostMapping("/savept")
    public String save( Pt_ramassage point ) {
		pt_dao.save(point);
        return "redirect:point";
    }
	/*
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		Pt_ramassage pt = new Pt_ramassage("nom",new Time(hour, minute, second),"POINT(50 50)");
		pt_dao.save(pt);
		return"done";
	}*/
}
