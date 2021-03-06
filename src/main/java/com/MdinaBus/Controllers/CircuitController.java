package com.MdinaBus.Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Listecrs;
import com.MdinaBus.Repositories.CircuitDaoImpl;
import com.MdinaBus.Repositories.CircuitsRepo;

@Controller
public class CircuitController {
	@Autowired
	CircuitsRepo repo;
	
	@Autowired
	CircuitDaoImpl dao;
	
	String dir = System.getProperty("user.dir")+"/kml";

	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	 @GetMapping("supprimerc/{id}")
		public String supprimer(long idc ,@PathVariable long id) {
			repo.deleteById(idc);
			return "redirect:../services/{id}";
		}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	 @PostMapping("savec/{id}")
	    public String save(Listecrs crss, @PathVariable long id) {
		 for(Circuit circuit : crss.getCrs()) {
			 if(circuit.getGeometrie().equals(""))
				 return "redirect:../services/{id}";
			 circuit.setidservice(id);
			 dao.save(circuit);
		 }
	        return "redirect:../services/{id}";
	    }
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	 @PostMapping("editec/{id}")
	    public String edite(Circuit cr, @PathVariable long id) {
			 cr.setidservice(id);
			 dao.edite(cr);
	        return "redirect:../services/{id}";
	    }
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	 @PostMapping("savek/{id}")
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
	        return "redirect:../services/{id}?kml="+file.getOriginalFilename();
	    }


}
