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

import com.aptech.demo.models.Cat;
import com.aptech.demo.models.Subcats;
import com.aptech.demo.repositories.CatRepository;
import com.aptech.demo.repositories.SubcatsRepository;

@Controller
@RequestMapping("/admin")
public class SubcatsController {
	@Autowired
	private SubcatsRepository scatRepo;
	@Autowired
	private CatRepository catRepo;

	@RequestMapping("/subcats")
	public String listAll(Model model) {
		List<Subcats> listScats = scatRepo.findAll();
		model.addAttribute("listScats", listScats);
		List<Cat> listCats = catRepo.findAll();
		model.addAttribute("listCats", listCats);
		return "admin/subcat/index";
	}

	@RequestMapping(value = "/subcats/insert")
	public String create(Model model) {
		model.addAttribute("scat", new Subcats());
		List<Cat> listCats = catRepo.findActive();
		model.addAttribute("listCats", listCats);
		return "admin/subcat/insert";
	}

	@RequestMapping(value = "/subcats/inserted", method = RequestMethod.POST)
	public String InsertedCat(@RequestParam("subcat_id") String subcat_id,
			@RequestParam("subcat_name") String subcat_name, @RequestParam("subcat_desc") String subcat_desc,
			@RequestParam("catid") String catid, Model model) throws IOException {
		Subcats scat = new Subcats();
		scat.setSubcat_id(subcat_id);
		scat.setSubcat_name(subcat_name);
		scat.setSubcat_desc(subcat_desc);
		scat.setCatid(catid);
		// Get Current Date
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		System.out.println(date);
		scat.setSubcat_createdat(date);
		Subcats saveScat = scatRepo.insert(scat);
		return "redirect:/admin/subcats";
	}

	@GetMapping("/subcats/edit")
	public String EditView(Model model, @RequestParam("idScat") String id) {
		Subcats scat = scatRepo.findById(id);
		model.addAttribute("subcat_id", scat.getSubcat_id());
		model.addAttribute("subcat_name", scat.getSubcat_name());
		model.addAttribute("subcat_desc", scat.getSubcat_desc());
		model.addAttribute("subcat_active", scat.getSubcat_active());
		model.addAttribute("subcat_createdat", scat.getSubcat_createdat());
		model.addAttribute("catid", scat.getCatid());
		List<Cat> listCats = catRepo.findActive();
		model.addAttribute("listCats", listCats);
		System.out.println();

		return "admin/subcat/edit";
	}

	@PostMapping("/subcats/edited")
	public String UpdateSubcat(@RequestParam("subcat_id") String subcat_id,
			@RequestParam("subcat_name") String subcat_name, @RequestParam("subcat_desc") String subcat_desc,
			@RequestParam("catid") String catid, Model model) throws IOException {

		Subcats scat = new Subcats();
		scat.setSubcat_id(subcat_id);
		scat.setSubcat_name(subcat_name);
		scat.setSubcat_desc(subcat_desc);
		scat.setCatid(catid);
		// cat.setActive(cat_active);
		Subcats saveScat = scatRepo.update(scat);
		model.addAttribute("listScats", scat);

		return "redirect:/admin/subcats";

	}
	
	@RequestMapping("subcats/viewdetail")
	public String viewdetail(@RequestParam("id") String id, Model model) {

		Subcats scat = scatRepo.findById(id);
		
		String catId = scat.getCatid();
		Cat cat = catRepo.findById(catId);
		
		model.addAttribute("subcat_id", scat.getSubcat_id());
		model.addAttribute("subcat_name", scat.getSubcat_name());
		model.addAttribute("subcat_desc", scat.getSubcat_desc());
		model.addAttribute("subcat_active", scat.getSubcat_active());
		model.addAttribute("subcat_createdat", scat.getSubcat_createdat());
		model.addAttribute("catname", cat.getName());

		return "admin/subcat/detail";
	}


	@PostMapping("/subcats/delete")
	public String DeleteCustomer(Model model, @RequestParam("idScat") String idScat, Subcats scat) {
		scatRepo.deleteById(idScat);
		Iterable<Subcats> scatlist = scatRepo.findAll();
		model.addAttribute("listScats", scatlist);
		return "redirect:/admin/subcats";
	}

	@GetMapping("/subcats/active")
	public String Active(Model model, @RequestParam("idScat") String idScat, Subcats scat) {
		scatRepo.active(idScat);
		Iterable<Cat> catlist = catRepo.findAll();
		model.addAttribute("listCats", catlist);
		return "redirect:/admin/subcats";
	}

	@GetMapping("/subcats/inactive")
	public String Inactive(Model model, @RequestParam("idScat") String idScat, Subcats scat) {
		scatRepo.inactive(idScat);
		Iterable<Subcats> scatlist = scatRepo.findAll();
		model.addAttribute("listScats", scatlist);
		return "redirect:/admin/subcats";
	}

}
