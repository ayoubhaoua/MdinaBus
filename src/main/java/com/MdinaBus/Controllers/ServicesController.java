package com.MdinaBus.Controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Entite;
import com.MdinaBus.Models.Listecrs;
import com.MdinaBus.Models.Location;
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
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
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
		model.addAttribute("cr", new Circuit());
		return "abonnement";
		}
		
		if(entite.getType().equals("locataire")) {
		return "redirect:../location/{id}";
		
		}
		
		return "Index";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	@GetMapping("/location/{id}")
	public String location(Model model,@PathVariable long id) {
		model.addAttribute("locations", L_repo.findByIdentite(id));
		model.addAttribute("id_entite", id);
		model.addAttribute("location", new Location());
		return "location";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	@PostMapping("/location/save/{id}")
	public String save(@PathVariable long id, Location location) {
		location.setIdentite(id);
		L_repo.save(location);
		return "redirect:../{id}";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	@GetMapping("/location/supprimer/{id}")
	public String location(long idl) {
		L_repo.deleteById(idl);
		return "redirect:../{id}";
	}
}
