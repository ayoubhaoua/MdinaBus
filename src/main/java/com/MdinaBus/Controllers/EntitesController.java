package com.MdinaBus.Controllers;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.MdinaBus.Models.Entite;
import com.MdinaBus.Repositories.EntitesRepo;



@Controller
public class EntitesController {
	@Autowired
	EntitesRepo repo;
	
	
	@GetMapping("/entites")
	
	public String entites(Model model) {
		model.addAttribute("entites", repo.findAll()) ;
		model.addAttribute("entite", new Entite());
		return "Index";
	}
	
	@PostMapping("/save")
    public String save( Entite entite ) {
		repo.save(entite);
        return "redirect:entites";
    }
	
   @GetMapping("/supprimer")
	public String supprimer(long id) {
		repo.deleteById(id);
		return "redirect:entites";
	}

}

