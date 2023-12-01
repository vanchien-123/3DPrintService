package com.aptech.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.aptech.demo.models.Technologies;
import com.aptech.demo.repositories.TechnologiesRepository;

@Controller
@RequestMapping("/admin")
public class TechnologiesController {
	@Autowired

	private TechnologiesRepository TnRepo;

	@RequestMapping("/technologies")
	public String listAll(Model model) {
		List<Technologies> listTechs = TnRepo.findAll();
		model.addAttribute("listTechs", listTechs);
		return "admin/technology/index";
	}

	@RequestMapping(value = "/technologies/insert")
	public String create(Model model) {
		model.addAttribute("technologies", new Technologies());
		return "admin/technology/insert";
	}

	@RequestMapping(value = "/technologies/inserted", method = RequestMethod.POST)
	public String InsertedTechnology(@RequestParam("technol_id") String technol_id,
			@RequestParam("technol_name") String technol_name, @RequestParam("technol_desc") String technol_desc,
			@RequestParam("technol_notes") String technol_notes, Model model) throws IOException {
		Technologies tn = new Technologies();
		tn.setTechnol_id(technol_id);
		tn.setTechnol_name(technol_name);
		tn.setTechnol_desc(technol_desc);
		tn.setTechnol_notes(technol_notes);
		tn.setTechnol_active(1);
		Technologies saveTech = TnRepo.insert(tn);
		return "redirect:/admin/technologies";
	}

	@GetMapping("/technologies/edit")
	public String EditView(Model model, @RequestParam("idTn") String id) {
		Technologies tn = TnRepo.findById(id);
		model.addAttribute("technol_id", tn.getTechnol_id());
		model.addAttribute("technol_name", tn.getTechnol_name());
		model.addAttribute("technol_desc", tn.getTechnol_desc());
		model.addAttribute("technol_notes", tn.getTechnol_notes());
		System.out.println();
		return "admin/technology/edit";
	}

	@PostMapping("/technologies/edited")
	public String UpdateTech(@RequestParam("technol_id") String technol_id,
			@RequestParam("technol_name") String technol_name, @RequestParam("technol_desc") String technol_desc,
			@RequestParam("technol_notes") String technol_notes, Model model) throws IOException {
		Technologies tn = new Technologies();
		
		tn.setTechnol_id(technol_id);
		tn.setTechnol_name(technol_name);
		tn.setTechnol_desc(technol_desc);
		tn.setTechnol_notes(technol_notes);
		
		Technologies saveTech = TnRepo.update(tn);
		model.addAttribute("listTechs", tn);
		return "redirect:/admin/technologies";

	}
	
	@RequestMapping("technologies/viewdetail")
	public String viewdetail(@RequestParam("id") String id,Model model) {
		
		Technologies tn = TnRepo.findById(id);
		model.addAttribute("technol_id", tn.getTechnol_id());
		model.addAttribute("technol_name", tn.getTechnol_name());
		model.addAttribute("technol_desc", tn.getTechnol_desc());
		model.addAttribute("technol_notes", tn.getTechnol_notes());
		
		return "admin/technology/detail";
	}

	@PostMapping("/technologies/delete")
	public String DeleteTech(Model model, @RequestParam("idTn") String idTn, Technologies technologies) {
		TnRepo.deleteById(idTn);
		Iterable<Technologies> techlist = TnRepo.findAll();
		model.addAttribute("listTechs", techlist);
		return "redirect:/admin/technologies";
	}

	@GetMapping("/technologies/active")
	public String Active(Model model, @RequestParam("idTn") String idTn, Technologies technologies) {
		TnRepo.active(idTn);
		Iterable<Technologies> techlist = TnRepo.findAll();
		model.addAttribute("listTechs", techlist);
		return "redirect:/admin/technologies";
	}

	@GetMapping("/technologies/inactive")
	public String Inactive(Model model, @RequestParam("idTn") String idTn, Technologies technologies) {
		TnRepo.inactive(idTn);
		Iterable<Technologies> techlist = TnRepo.findAll();
		model.addAttribute("listTechs", techlist);
		return "redirect:/admin/technologies";
	}
}
