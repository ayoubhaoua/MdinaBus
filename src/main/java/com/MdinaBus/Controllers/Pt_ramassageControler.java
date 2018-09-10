package com.MdinaBus.Controllers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Pt_ramassage;
import com.MdinaBus.Repositories.CircuitDaoImpl;
import com.MdinaBus.Repositories.CircuitsRepo;
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
	
	@Autowired
	CircuitsRepo c_repo;
	
	@Autowired
	CircuitDaoImpl c_dao;
	
	String dir = System.getProperty("user.dir")+"/src/main/resources/static/kml";
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	@GetMapping("/point")
	public String point(Model model) {
		model.addAttribute("points", pt_repo.findAll());
		model.addAttribute("point", new Pt_ramassage());
		return"pt_ramassage";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})	
@GetMapping("/point/{id}")
	
	public String services(Model model ,@PathVariable long id, String kml ) {
		Circuit c = c_repo.findById(id);
		c.setGeometrie(c_dao.findGeometrieByid(id));
		model.addAttribute("points", pt_repo.findByIdcircuit(id));
		model.addAttribute("point", new Pt_ramassage());
		model.addAttribute("id_circuit", id);
		model.addAttribute("circuit", c);
		model.addAttribute("kml", kml);
		
		model.addAttribute("PtXYN", pt_dao.getXYN(id));
		
		return "pt_ramassage";
		}


	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})		
	@PostMapping("/savept/{id}")
    public String save( Pt_ramassage point , @PathVariable long id) {
		point.setIdcircuit(id);
		if(point.getGeometrie().equals("save")) {
			pt_dao.edite(point);
			return "redirect:../point/{id}";
		}
		pt_dao.save(point);
        return "redirect:../point/{id}";
    }
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	@GetMapping("/supprimerpt/{id}")
    public String supprimer( long idp ) {
		pt_repo.deleteById(idp);
        return "redirect:../point/{id}";
    }
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	@PostMapping("savekml/{id}")
    public String savek(@RequestParam("kml") MultipartFile file, @PathVariable long id) {
	 new File(dir).mkdirs();
	 File files[] =new File(dir).listFiles();
	 for (File f : files) {
            f.delete();
        }
	 	Path path = Paths.get(dir, file.getOriginalFilename());
	 	try {
			Files.write(path, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
        return "redirect:../point/{id}?kml="+file.getOriginalFilename();
    }
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	@PostMapping("savekmlpt/{id}")
    public String savept(@RequestParam("geom") String geom, @PathVariable long id) {
		String[] parts = geom.split(";");
		Pt_ramassage pt = new Pt_ramassage("","",id,"");
		for (String part : parts) {
			String[] coor=part.split(",");
			pt.setGeometrie("POINT("+coor[0]+" "+coor[1]+")");
			pt_dao.save(pt);
		}
        return "redirect:../point/{id}";
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
