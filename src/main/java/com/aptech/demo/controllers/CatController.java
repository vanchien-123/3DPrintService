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
import com.aptech.demo.repositories.CatRepository;



@Controller
@RequestMapping("/admin")
public class CatController {
	@Autowired

	private CatRepository catRepo;

	@RequestMapping("/cats")
	public String listAll(Model model) {
		List<Cat> listCats = catRepo.findAll();
		model.addAttribute("listCats", listCats);
		return "admin/cat/index";
	}

	@RequestMapping(value = "/cats/insert")
	public String create(Model model) {
		model.addAttribute("cat", new Cat());
		return "admin/cat/insert";
	}

	@RequestMapping(value = "/cats/inserted", method = RequestMethod.POST)
	public String InsertedCat(@RequestParam("cat_id") String id, @RequestParam("cat_name") String name,
			@RequestParam("cat_desc") String desc, Model model) throws IOException {
		Cat cat = new Cat();
		cat.setId(id);
		cat.setName(name);
		cat.setDesc(desc);
		// Get Current Date
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		System.out.println(date);
		cat.setCreatedat(date);
		Cat saveCat = catRepo.insert(cat);
		return "redirect:/admin/cats";
	}

	@GetMapping("/cats/edit")
	public String EditView(Model model, @RequestParam("idCat") String id) {
		Cat cat = catRepo.findById(id);
		model.addAttribute("cat_id", cat.getId());
		model.addAttribute("cat_name", cat.getName());
		model.addAttribute("cat_desc", cat.getDesc());
		model.addAttribute("cat_active", cat.getActive());
		model.addAttribute("cat_createdat", cat.getCreatedat());

		System.out.println();

		return "admin/cat/edit";
	}

	@PostMapping("/cats/edited")
	public String UpdateCustomer(@RequestParam("cat_id") String cat_id, @RequestParam("cat_name") String cat_name,
			@RequestParam("cat_desc") String cat_desc, Model model)
			throws IOException {

		Cat cat = new Cat();
		cat.setId(cat_id);
		cat.setName(cat_name);
		cat.setDesc(cat_desc);
		//cat.setActive(cat_active);
		Cat saveCat = catRepo.update(cat);
		model.addAttribute("listCats", cat);

		return "redirect:/admin/cats";

	}
	
	@RequestMapping("cats/viewdetail")
	public String viewdetail(@RequestParam("id") String id, Model model) {

		Cat cat = catRepo.findById(id);
		
		model.addAttribute("cat_id", cat.getId());
		model.addAttribute("cat_name", cat.getName());
		model.addAttribute("cat_desc", cat.getDesc());
		model.addAttribute("cat_active", cat.getActive());
		model.addAttribute("cat_createdat", cat.getCreatedat());
		
		return "admin/cat/detail";
	}

	@PostMapping("/cats/delete")
	public String DeleteCustomer(Model model, @RequestParam("idCat") String idCat, Cat cat) {
		catRepo.deleteById(idCat);
		Iterable<Cat> catlist = catRepo.findAll();
		model.addAttribute("listCats", catlist);
		return "redirect:/admin/cats";
	}

	@GetMapping("/cats/active")
	public String Active( Model model, @RequestParam("idCat") String idCat, Cat cat)
	{
		//cat.setActive(cat_active);
		catRepo.active(idCat);
		Iterable<Cat> catlist = catRepo.findAll();
		model.addAttribute("listCats", catlist);
		return "redirect:/admin/cats";
	}
	
	@GetMapping("/cats/inactive")
	public String Inactive( Model model, @RequestParam("idCat") String idCat, Cat cat)
	{
		//cat.setActive(cat_active);
		catRepo.inactive(idCat);
		Iterable<Cat> catlist = catRepo.findAll();
		model.addAttribute("listCats", catlist);
		return "redirect:/admin/cats";
	}

}
