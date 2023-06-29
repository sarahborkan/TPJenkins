package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Voyageur;
import com.inti.repository.IVoyageurRepository;

@Controller
public class VoyageurController {
	
	@Autowired
	IVoyageurRepository ivr;
	
	@GetMapping("creerVoyageur")
	public String creervoyageur()
	{
		return "creerVoyageur";
	}
	
	@PostMapping("creerVoyageur")
	public String creervoyageur(@ModelAttribute("voyageur") Voyageur v)
	{		
		ivr.save(v);
		
		return "redirect:/listeVoyageur";
	}
	
	@GetMapping("listeVoyageur")
	public String listevoyageur(Model m)
	{
		m.addAttribute("listeV", ivr.findAll());
		
		return "listeVoyageur";
	}
	
	@GetMapping("modifierVoyageur/{id}")
	public String modifiervoyageur(Model m, @PathVariable("id") int id)
	{
		m.addAttribute("voyageur", ivr.getReferenceById(id));
		
		return "modifierVoyageur";
	}
	
	@PostMapping("modifierVoyageur/{id}")
	public String modifiervoyageur(@ModelAttribute("voyageur") Voyageur v, @PathVariable("id") int id)
	{
		ivr.save(v);
		
		return "redirect:/listeVoyageur";
	}
	
	@GetMapping("deleteVoyageur/{id}")
	public String deleteVoyageur(@PathVariable("id") int id)
	{
		ivr.delete(ivr.getReferenceById(id));
		
		return "redirect:/listeVoyageur";
	}

}
