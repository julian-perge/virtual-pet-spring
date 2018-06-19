package com.julian.virtualpetspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VirtualPetController
{
	@Autowired
	VirtualPetRepo petRepository;
	
	@RequestMapping("/virtualpets")
	public String getPets(Model model)
	{
		model.addAttribute("virtualpets", petRepository.getAllPets());
		return "virtualpets";
	}

	@RequestMapping("/virtualpets/{id}")
	public String getPet(@PathVariable(name="id")Long id, Model model)
	{
		model.addAttribute("virtualpet", petRepository.returnSpecificPet(id));
		return "virtualpet";
	}
}
