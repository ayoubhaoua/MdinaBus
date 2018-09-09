package com.MdinaBus.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.MdinaBus.Models.Circuit;
import com.MdinaBus.Models.Consommation_Bus;
import com.MdinaBus.Models.Roulement;
import com.MdinaBus.Repositories.CircuitsRepo;
import com.MdinaBus.Repositories.ConsomationRepo;
import com.MdinaBus.Repositories.EntitesRepo;
import com.MdinaBus.Repositories.RoulementRepo;

@Controller
public class PrincipaleController {
	
	@Autowired
	ConsomationRepo con_repo;
	
	@Autowired
	RoulementRepo r_repo;
	
	@Autowired
	EntitesRepo e_repo;
	
	@Autowired
	CircuitsRepo cr_repo;

	@Secured(value= {"ROLE_ADMIN","ROLE_DESSINEUR"})
	@GetMapping("/")
	public String index() {
		return"redirect:/entites";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_E_ROULEMENT"})
	@GetMapping("/roulement")
	public String roulement(Model model, Long id) {
		model.addAttribute("roulms",r_repo.findAll());
		model.addAttribute("roul" ,new Roulement() );
		
		String entite="null";
		List<Circuit> circuits =new ArrayList<Circuit>();
		if(id!=null) {
			entite=(e_repo.findById(id.longValue())).getNom();
			circuits=cr_repo.findByIdservice(id.longValue());
		}
		
		model.addAttribute("entites", e_repo.findAll());
		model.addAttribute("e", entite);
		model.addAttribute("circuits",circuits);
		
		return "roulement";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_E_ROULEMENT"})
	@PostMapping("/roulement/save")
	public String saver(Roulement roul) {
		r_repo.save(roul);
		return "redirect:../roulement";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_E_ROULEMENT"})
	@GetMapping("/roulement/supprimer")
	public String supprimerr(long idr) {
		r_repo.deleteById(idr);
		return "redirect:../roulement";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_E_CONSOMMATION"})
	@GetMapping("/consomation")
	public String consomation(Model model, Long id) {
		String entite="null";
		List<Circuit> circuits =new ArrayList<Circuit>();
		if(id!=null) {
			entite=(e_repo.findById(id.longValue())).getNom();
			circuits=cr_repo.findByIdservice(id.longValue());
		}
		model.addAttribute("consoms",con_repo.findAll());
		model.addAttribute("consomation", new Consommation_Bus());
		model.addAttribute("entites", e_repo.findAll());
		model.addAttribute("e", entite);
		model.addAttribute("circuits",circuits);
		return "consomation";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_E_CONSOMMATION"})
	@GetMapping("/consomation/supprimer")
	public String supprimer(long idcon) {
		con_repo.deleteById(idcon);
		return "redirect:../consomation";
	}
	
	@Secured(value= {"ROLE_ADMIN","ROLE_E_CONSOMMATION"})
	@PostMapping("/consomation/save")
	public String save(Consommation_Bus consomation) {
		con_repo.save(consomation);
		return "redirect:../consomation";
	}
}
