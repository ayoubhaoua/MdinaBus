package com.MdinaBus.Controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Consommation_Bus;
import com.MdinaBus.Models.Location;
import com.MdinaBus.Models.Roulement;
import com.MdinaBus.Repositories.CircuitsRepo;
import com.MdinaBus.Repositories.ConsomationRepo;
import com.MdinaBus.Repositories.EntitesRepo;
import com.MdinaBus.Repositories.LocationRepo;
import com.MdinaBus.Repositories.RoulementRepo;

@Controller
public class PrincipaleController {
	
	String dir = System.getProperty("user.dir")+"/src/main/resources/static/kml";
	
	@Autowired
	ConsomationRepo con_repo;
	
	@Autowired
	RoulementRepo r_repo;
	
	@Autowired
	EntitesRepo e_repo;
	
	@Autowired
	CircuitsRepo cr_repo;
	
	@Autowired
	LocationRepo l_repo;

	@GetMapping("/")
	public String index() {
		return"redirect:/entites";
	}
	
	@GetMapping("/roulement")
	public String roulement(Model model, Long id) {
		model.addAttribute("roulms",r_repo.findAll());
		model.addAttribute("roul" ,new Roulement() );
		
		String entite="null";
		List<Circuit> circuits =new ArrayList<Circuit>();
		List<Location> loc = new ArrayList<Location>();
		if(id!=null) {
			entite=(e_repo.findById(id.longValue())).getNom();
			circuits=cr_repo.findByIdservice(id);
			loc=l_repo.findByIdentite(id);
		}
		
		model.addAttribute("entites", e_repo.findAll());
		model.addAttribute("e", entite);
		model.addAttribute("circuits",circuits);
		model.addAttribute("locations",loc);
		
		return "roulement";
	}
	
	@PostMapping("/roulement/save")
	public String saver(Roulement roul) {
		r_repo.save(roul);
		return "redirect:../roulement";
	}
	
	@GetMapping("/roulement/supprimer")
	public String supprimerr(long idr) {
		r_repo.deleteById(idr);
		return "redirect:../roulement";
	}
	
	@GetMapping("/consomation")
	public String consomation(Model model, Long id) {
		String entite="null";
		List<Circuit> circuits =new ArrayList<Circuit>();
		List<Location> loc = new ArrayList<Location>();
		if(id!=null) {
			entite=(e_repo.findById(id.longValue())).getNom();
			circuits=cr_repo.findByIdservice(id.longValue());
			loc=l_repo.findByIdentite(id);
		}
		model.addAttribute("consoms",con_repo.findAll());
		model.addAttribute("consomation", new Consommation_Bus());
		model.addAttribute("entites", e_repo.findAll());
		model.addAttribute("e", entite);
		model.addAttribute("circuits",circuits);
		model.addAttribute("locations",loc);
		return "consomation";
	}
	
	@GetMapping("/consomation/supprimer")
	public String supprimer(long idcon) {
		con_repo.deleteById(idcon);
		return "redirect:../consomation";
	}
	
	@PostMapping("/consomation/save")
	public String save(Consommation_Bus consomation) {
		con_repo.save(consomation);
		return "redirect:../consomation";
	}
	
}
