package com.MdinaBus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.MdinaBus.Repositories.Pt_ramassageRepo;

@Controller
public class Pt_ramassageControler {

	@Autowired
	Pt_ramassageRepo pt_repo;
	
	@GetMapping("/point")
	public String point(Model model) {
		model.addAttribute("points", pt_repo.findAll());
		return"pt_ramassage";
	}
}
