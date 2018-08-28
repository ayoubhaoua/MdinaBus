package com.MdinaBus.Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	String dir = System.getProperty("user.dir")+"/src/main/resources/static/kml";
	
	@GetMapping("/circuits")
	
	public String circuits(Model model) {
		model.addAttribute("circuits", repo.findAll()) ;
		model.addAttribute("circuit", new Circuit());
		return "circuits";
	}
	 @GetMapping("supprimerc")
		public String supprimer(long id) {
			repo.deleteById(id);
			return "redirect:circuits";
		}
	 
	 @PostMapping("savec/{id}")
	    public String save(Listecrs crss, @PathVariable long id) {
		 for(Circuit circuit : crss.getCrs()) {
			 circuit.setidservice(id);
			 dao.save(circuit);
		 }
	        return "redirect:../services/{id}";
	    }
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
