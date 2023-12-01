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

import com.aptech.demo.models.Prodgroups;
import com.aptech.demo.repositories.ProdgroupsRepository;

@Controller
@RequestMapping("/admin")
public class ProdgroupsController {
	@Autowired

	private ProdgroupsRepository prodgrRepo;

	@RequestMapping("/prodgroups")
	public String listAll(Model model) {
		List<Prodgroups> listProdgrs = prodgrRepo.findAll();
		model.addAttribute("listProdgrs", listProdgrs);
		return "admin/prodgroup/index";
	}

	@RequestMapping(value = "/prodgroups/insert")
	public String create(Model model) {
		model.addAttribute("prodgroups", new Prodgroups());
		return "admin/prodgroup/insert";
	}

	@RequestMapping(value = "/prodgroups/inserted", method = RequestMethod.POST)
	public String InsertedCat(@RequestParam("prodgroup_id") String prodgroup_id,
			@RequestParam("prodgroup_name") String prodgroup_name,
			@RequestParam("prodgroup_desc") String prodgroup_desc, Model model) throws IOException {
		Prodgroups pg = new Prodgroups();
		pg.setProdgroup_id(prodgroup_id);
		pg.setProdgroup_name(prodgroup_name);
		pg.setProdgroup_desc(prodgroup_desc);
		// Get Current Date
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		System.out.println(date);
		pg.setProdgroup_createdat(date);
		Prodgroups saveProdgr = prodgrRepo.insert(pg);
		return "redirect:/admin/prodgroups";
	}

	@GetMapping("/prodgroups/edit")
	public String EditView(Model model, @RequestParam("idPg") String id) {
		Prodgroups pg = prodgrRepo.findById(id);
		model.addAttribute("prodgroup_id", pg.getProdgroup_id());
		model.addAttribute("prodgroup_name", pg.getProdgroup_name());
		model.addAttribute("prodgroup_desc", pg.getProdgroup_desc());
		model.addAttribute("prodgroup_active", pg.getProdgroup_active());
		model.addAttribute("prodgroup_createdat", pg.getProdgroup_createdat());
		System.out.println();

		return "admin/prodgroup/edit";
	}

	@PostMapping("/prodgroups/edited")
	public String UpdateProdgroup(@RequestParam("prodgroup_id") String prodgroup_id,
			@RequestParam("prodgroup_name") String prodgroup_name,
			@RequestParam("prodgroup_desc") String prodgroup_desc, Model model) throws IOException {

		Prodgroups pg = new Prodgroups();
		pg.setProdgroup_id(prodgroup_id);
		pg.setProdgroup_name(prodgroup_name);
		pg.setProdgroup_desc(prodgroup_desc);
		Prodgroups savePrg = prodgrRepo.update(pg);
		model.addAttribute("listProdgrs", pg);

		return "redirect:/admin/prodgroups";

	}
	
	@RequestMapping("prodgroups/viewdetail")
	public String viewdetail(@RequestParam("id") String id, Model model) {

		Prodgroups pg = prodgrRepo.findById(id);
		
		model.addAttribute("prodgroup_id", pg.getProdgroup_id());
		model.addAttribute("prodgroup_name", pg.getProdgroup_name());
		model.addAttribute("prodgroup_desc", pg.getProdgroup_desc());
		model.addAttribute("prodgroup_active", pg.getProdgroup_active());
		model.addAttribute("prodgroup_createdat", pg.getProdgroup_createdat());
		

		return "admin/prodgroup/detail";
	}
	
	@PostMapping("/prodgroups/delete")
	public String DeleteProdgroup(Model model, @RequestParam("idPg") String idPg, Prodgroups pg) {
		prodgrRepo.deleteById(idPg);
		Iterable<Prodgroups> prodglist = prodgrRepo.findAll();
		model.addAttribute("listProdgrs", prodglist);
		return "redirect:/admin/prodgroups";
	}


	@GetMapping("/prodgroups/active")
	public String Active(Model model, @RequestParam("idPg") String idPg, Prodgroups pg) {
		prodgrRepo.active(idPg);
		Iterable<Prodgroups> prodglist = prodgrRepo.findAll();
		model.addAttribute("listProdgrs", prodglist);
		return "redirect:/admin/prodgroups";
	}

	@GetMapping("/prodgroups/inactive")
	public String Inactive(Model model, @RequestParam("idPg") String idPg, Prodgroups pg) {
		// cat.setActive(cat_active);
		prodgrRepo.inactive(idPg);
		Iterable<Prodgroups> prodglist = prodgrRepo.findAll();
		model.addAttribute("listProdgrs", prodglist);
		return "redirect:/admin/prodgroups";
	}

}
