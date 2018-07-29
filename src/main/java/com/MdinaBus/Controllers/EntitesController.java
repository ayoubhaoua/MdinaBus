package com.MdinaBus.Controllers;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MdinaBus.Models.Entite;
import com.MdinaBus.Repositories.EntitesRepo;



@Controller
public class EntitesController {
	@Autowired
	EntitesRepo repo;
	
	
	@GetMapping("/entites")
	
	public String entites(Model model) {
		model.addAttribute("entites", repo.findAll()) ;
		return "Index";
	}
	
   @GetMapping("/supprimer")
	public String supprimer(long id) {
		repo.deleteById(id);
		return "Index";
	}
	
	@GetMapping("/save")
	@ResponseBody
	public String process(){
		// save a single Customer
		repo.save(new Entite("gggg","ggggg","gggg","gggg"));
		return "Done";
	}
	
	/*
	@RequestMapping("/findall")
	@ResponseBody
	public String findAll(){
		String result = "";
		
		for(Entite cust : repo.findAll()){
			result += cust.toString() + "<br>";
		}
		
		return result;
	}
	+*/
	@GetMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repo.findById(id).toString();
		return result;
	}
}

