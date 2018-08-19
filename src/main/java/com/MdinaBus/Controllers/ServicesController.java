package com.MdinaBus.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Entite;
import com.MdinaBus.Repositories.CircuitsRepo;
import com.MdinaBus.Repositories.EntitesRepo;
import com.MdinaBus.Repositories.LocationRepo;


@Controller
public class ServicesController {

	@Autowired
	EntitesRepo E_repo;
	
	@Autowired
	CircuitsRepo C_repo;
	
	@Autowired
	LocationRepo L_repo;
	
	
	@GetMapping("/services/{id}")
	
	public String services(Model model ,@PathVariable long id) {
		
		Entite entite = E_repo.findById(id);
		
		if(entite.getType().equals("ecole")) {
		model.addAttribute("circuits", C_repo.findByIdservice(id));
		model.addAttribute("circuit", new Circuit());
		model.addAttribute("id_service", id);
		return "abonnement";
		}
		
		if(entite.getType().equals("locataire")) {
		return "redirect:../location/{id}";
		
		}
		
		return "Index";
	}
	@GetMapping("/location/{id}")
	@ResponseBody
	public String location(Model model,@PathVariable long id) {
		model.addAttribute("locations", L_repo.findById_entite(id));
		model.addAttribute("type", "locataire");
		model.addAttribute("id_entite", "id");
		return "location";
	}
}
