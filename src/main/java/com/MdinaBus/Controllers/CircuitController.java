package com.MdinaBus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Entite;
import com.MdinaBus.Repositories.CircuitsRepo;
import com.MdinaBus.Repositories.EntitesRepo;

@Controller
public class CircuitController {
	@Autowired
	CircuitsRepo repo;
	
	@Autowired
	
	
	@GetMapping("/circuits")
	
	public String circuits(Model model) {
		model.addAttribute("circuits", repo.findAll()) ;
		model.addAttribute("circuit", new Entite());
		return "circuits";
	}
	 @GetMapping("circuits/supprimer")
		public String supprimer(long id) {
			repo.deleteById(id);
			return "redirect:circuits";
		}
	 
	 @PostMapping("/circuits/save")
	    public String save(Circuit circuit ) {
			dao.save(circuit);
	        return "redirect:entites";
	    }


}
