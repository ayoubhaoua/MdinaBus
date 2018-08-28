package com.MdinaBus.Controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Entite;
import com.MdinaBus.Models.Listecrs;
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
	
	public String services(Model model ,@PathVariable long id, String kml) {
		
		Entite entite = E_repo.findById(id);
		Listecrs crs = new Listecrs();
		
		if(entite.getType().equals("ecole")) {
		model.addAttribute("circuits", C_repo.findByIdservice(id));
		model.addAttribute("id_service", id);
		model.addAttribute("kml", kml);
		if(kml==null) {
			crs.addcircuit(new Circuit());
		}
		else {
			for(int i=0 ; i<20 ; i++) {
				crs.addcircuit(new Circuit());
				
			}
		}
		model.addAttribute("crss", crs);
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
