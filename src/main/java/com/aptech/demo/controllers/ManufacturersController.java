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

import com.aptech.demo.models.Manufacturers;
import com.aptech.demo.repositories.ManufacturersRepository;



@Controller
@RequestMapping("/admin")
public class ManufacturersController {
	@Autowired

	private ManufacturersRepository mnFactsRepo;

	@RequestMapping("/manufacturers")
	public String listAll(Model model) {
		List<Manufacturers> listmnFacts = mnFactsRepo.findAll();
		model.addAttribute("listmnFacts", listmnFacts);
		return "admin/manufacturer/index";
	}

	@RequestMapping(value = "/manufacturers/insert")
	public String create(Model model) {
		model.addAttribute("manufacturers", new Manufacturers());
		return "admin/manufacturer/insert";
	}

	@RequestMapping(value = "/manufacturers/inserted", method = RequestMethod.POST)
	public String InsertedManuf(@RequestParam("mfger_id") String mfger_id,
			@RequestParam("mfger_name") String mfger_name, @RequestParam("mfger_desc") String mfger_desc,
			@RequestParam("mfger_website") String mfger_website,Model model)
			throws IOException {
		Manufacturers mn = new Manufacturers(); 
		mn.setMfger_id(mfger_id);
		mn.setMfger_name(mfger_name);
		mn.setMfger_desc(mfger_desc);
		mn.setMfger_website("https//"+mfger_website);
		mn.setMfger_active(1);
		String mn_id = mfger_id.toString();
		Manufacturers saveMn = mnFactsRepo.insert(mn);
		return "redirect:/admin/manufacturers";
	}

	@GetMapping("/manufacturers/edit")
	public String EditView(Model model, @RequestParam("idMn") String id) {
		Manufacturers mn = mnFactsRepo.findById(id);
		model.addAttribute("mfger_id", mn.getMfger_id());
		model.addAttribute("mfger_name", mn.getMfger_name());
		model.addAttribute("mfger_desc", mn.getMfger_desc());
		model.addAttribute("mfger_website", mn.getMfger_website());
		System.out.println();

		return "admin/manufacturer/edit";
	}

	@PostMapping("/manufacturers/edited")
	public String UpdateMnfact(@RequestParam("mfger_id") String mfger_id, @RequestParam("mfger_name") String mfger_name,
			@RequestParam("mfger_desc") String mfger_desc,@RequestParam("mfger_website") String mfger_website, Model model) throws IOException {

		Manufacturers mn = new Manufacturers();
		mn.setMfger_id(mfger_id);
		mn.setMfger_name(mfger_name);
		mn.setMfger_desc(mfger_desc);
		mn.setMfger_website(mfger_website);
		Manufacturers saveMn = mnFactsRepo.update(mn);
		model.addAttribute("listmnFacts", mn);
		return "redirect:/admin/manufacturers";

	}
	
	@RequestMapping("manufacturers/viewdetail")
	public String viewdetail(@RequestParam("id") String id,Model model) {
		
		Manufacturers mn = mnFactsRepo.findById(id);
		
		model.addAttribute("mfger_id", mn.getMfger_id());
		model.addAttribute("mfger_name", mn.getMfger_name());
		model.addAttribute("mfger_desc", mn.getMfger_desc());
		model.addAttribute("mfger_website", mn.getMfger_website());
		
		return "admin/manufacturer/detail";
	}

	@PostMapping("/manufacturers/delete")
	public String DeleteMn(Model model, @RequestParam("idMn") String idMn, Manufacturers manufacturers) {
		mnFactsRepo.deleteById(idMn);
		Iterable<Manufacturers> manufacturerslist = mnFactsRepo.findAll();
		model.addAttribute("listmnFacts", manufacturerslist);
		return "redirect:/admin/manufacturers";
	}

	@GetMapping("/manufacturers/active")
	public String Active(Model model, @RequestParam("idMn") String idMn, Manufacturers manufacturers) {
		mnFactsRepo.active(idMn);
		Iterable<Manufacturers> manufacturerslist = mnFactsRepo.findAll();
		model.addAttribute("listmnFacts", manufacturerslist);
		return "redirect:/admin/manufacturers";
	}

	@GetMapping("/manufacturers/inactive")
	public String Inactive(Model model, @RequestParam("idMn") String idMn, Manufacturers manufacturers) {
		mnFactsRepo.inactive(idMn);
		Iterable<Manufacturers> manufacturerslist = mnFactsRepo.findAll();
		model.addAttribute("listmnFacts", manufacturerslist);
		return "redirect:/admin/manufacturers";
	}
}
