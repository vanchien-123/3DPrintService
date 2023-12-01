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

import com.aptech.demo.models.Colors;
import com.aptech.demo.models.Manufacturers;
import com.aptech.demo.models.Materials;
import com.aptech.demo.models.Products;
import com.aptech.demo.repositories.ColorsRepository;
import com.aptech.demo.repositories.ManufacturersRepository;
import com.aptech.demo.repositories.MaterialsRepository;

@Controller
@RequestMapping("/admin")
public class MaterialsController {
	@Autowired
	private MaterialsRepository MatesRepo;
	@Autowired
	private ColorsRepository  CoRepo;
	@Autowired 
	private ManufacturersRepository MnRepo;
	
	@RequestMapping("/materials")
	public String listAll(Model model) {
		List<Materials> listMates = MatesRepo.findAll();
		model.addAttribute("listMates", listMates);
		List<Colors> listColors = CoRepo.findAll();
		model.addAttribute("listColors", listColors);
		List<Manufacturers> listManus = MnRepo.findAll();
		model.addAttribute("listManus", listManus);	
		return "admin/material/index";
	}

	@RequestMapping(value = "/materials/insert")
	public String create(Model model) {
		model.addAttribute("mates", new Materials());
		List<Colors> listColors = CoRepo.findActive();
		model.addAttribute("listColors", listColors);
		List<Manufacturers> listManus = MnRepo.findActive();
		model.addAttribute("listManus", listManus);
		return "admin/material/insert";
	}

	@RequestMapping(value = "/materials/inserted", method = RequestMethod.POST)
	public String InsertedMaterial(
			@RequestParam("material_id") String material_id,
			@RequestParam("material_name") String material_name, 
			@RequestParam("colorid") String colorid,
			@RequestParam("density") Float density, 
			@RequestParam("material_uprice") Float material_uprice, 
			@RequestParam("mfgerid") String mfgerid, 
			@RequestParam("material_desc") String material_desc, 			
			Model model) throws IOException {
		Materials mates = new Materials();
		mates.setMaterial_id(material_id);
		mates.setMaterial_name(material_name);
		mates.setColorid(colorid);
		mates.setDensity(density);
		mates.setMaterial_uprice(material_uprice);
		mates.setMfgerid(mfgerid);
		mates.setMaterial_desc(material_desc);
		mates.setMaterial_continuity(1);
		mates.setMaterial_active(1);
		Materials saveMates = MatesRepo.insert(mates);
		return "redirect:/admin/materials";
	}

	@GetMapping("/materials/edit")
	public String EditView(Model model, @RequestParam("idMates") String id) {
		Materials mates = MatesRepo.findById(id);
		model.addAttribute("material_id", mates.getMaterial_id());
		model.addAttribute("material_name", mates.getMaterial_name());
		model.addAttribute("colorid", mates.getColorid());
		model.addAttribute("density", mates.getDensity());
		model.addAttribute("material_uprice", mates.getMaterial_uprice());
		model.addAttribute("mfgerid", mates.getMfgerid());
		model.addAttribute("material_desc", mates.getMaterial_desc());
		List<Colors> listColors = CoRepo.findActive();
		model.addAttribute("listColors", listColors);
		List<Manufacturers> listManus = MnRepo.findActive();
		model.addAttribute("listManus", listManus);
		System.out.println();

		return "admin/material/edit";
	}

	@PostMapping("/materials/edited")
	public String UpdateMaterial(@RequestParam("material_id") String material_id,
			@RequestParam("material_name") String material_name, 
			@RequestParam("colorid") String colorid,
			@RequestParam("density") Float density, 
			@RequestParam("material_uprice") Float material_uprice, 
			@RequestParam("mfgerid") String mfgerid, 
			@RequestParam("material_desc") String material_desc, 
				
			Model model) throws IOException {

		Materials mates = new Materials();
		mates.setMaterial_id(material_id);
		mates.setMaterial_name(material_name);
		mates.setColorid(colorid);
		mates.setDensity(density);
		mates.setMaterial_uprice(material_uprice);
		mates.setMfgerid(mfgerid);
		mates.setMaterial_desc(material_desc);
		Materials saveMates = MatesRepo.update(mates);
		model.addAttribute("listMates", mates);

		return "redirect:/admin/materials";

	}

	@RequestMapping("materials/viewdetail")
	public String viewdetail(@RequestParam("id") String id,Model model) {
		
		Materials mates = MatesRepo.findById(id);
		
		model.addAttribute("material_id", mates.getMaterial_id());
		model.addAttribute("material_name", mates.getMaterial_name());
		model.addAttribute("colorid", mates.getColorid());
		model.addAttribute("density", mates.getDensity());
		model.addAttribute("material_uprice", mates.getMaterial_uprice());
		model.addAttribute("mfgerid", mates.getMfgerid());
		model.addAttribute("material_desc", mates.getMaterial_desc());
		model.addAttribute("material_continuity", mates.getMaterial_continuity());	
		
		return "admin/material/detail";
	}
	

	@PostMapping("/materials/delete")
	public String DeleteMaterial(Model model, @RequestParam("idMates") String idMates, Materials mates) {
		MatesRepo.deleteById(idMates);
		Iterable<Materials> mateslist = MatesRepo.findAll();
		model.addAttribute("listMates", mateslist);
		return "redirect:/admin/materials";
	}

	@GetMapping("/materials/active")
	public String Active(Model model, @RequestParam("idMates") String idMates, Materials mates) {
		MatesRepo.active(idMates);
		Iterable<Materials> mateslist = MatesRepo.findAll();
		model.addAttribute("listMates", mateslist);
		return "redirect:/admin/materials";
	}

	@GetMapping("/materials/inactive")
	public String Inactive(Model model, @RequestParam("idMates") String idMates, Materials mates) {
		MatesRepo.inactive(idMates);
		Iterable<Materials> mateslist = MatesRepo.findAll();
		model.addAttribute("listMates", mateslist);
		return "redirect:/admin/materials";
	}
	
	@GetMapping("/materials/continuity")
	public String Continuity(Model model, @RequestParam("idMates") String idMates, Materials mates) {
		MatesRepo.continuity(idMates);
		Iterable<Materials> mateslist = MatesRepo.findAll();
		model.addAttribute("listMates", mateslist);
		return "redirect:/admin/materials";
	}

	@GetMapping("/materials/incontinuity")
	public String Incontinuity(Model model, @RequestParam("idMates") String idMates, Materials mates) {
		MatesRepo.incontinuity(idMates);
		Iterable<Materials> mateslist = MatesRepo.findAll();
		model.addAttribute("listMates", mateslist);
		return "redirect:/admin/materials";
	}
}
