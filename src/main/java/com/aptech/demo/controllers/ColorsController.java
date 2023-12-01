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
import com.aptech.demo.repositories.ColorsRepository;

@Controller
@RequestMapping("/admin")
public class ColorsController {
	@Autowired

	private ColorsRepository colorsRepo;

	@RequestMapping("/colors")
	public String listAll(Model model) {
		List<Colors> listColors = colorsRepo.findAll();
		model.addAttribute("listColors", listColors);
		return "admin/color/index";
	}

	@RequestMapping(value = "/colors/insert")
	public String create(Model model) {
		model.addAttribute("colors", new Colors());
		return "admin/color/insert";
	}

	@RequestMapping(value = "/colors/inserted", method = RequestMethod.POST)
	public String InsertedColor(@RequestParam("color_id") String color_id,
			@RequestParam("color_name") String color_name, @RequestParam("color_hex") String color_hex, Model model)
			throws IOException {
		Colors cl = new Colors();
		cl.setColor_id(color_id);
		cl.setColor_name(color_name);
		cl.setColor_hex(color_hex);
		String co_id = color_id.toString();
		Colors saveColor = colorsRepo.insert(cl);
		return "redirect:/admin/colors";
	}

	@GetMapping("/colors/edit")
	public String EditView(Model model, @RequestParam("idCo") String id) {
		Colors cl = colorsRepo.findById(id);
		model.addAttribute("color_id", cl.getColor_id());
		model.addAttribute("color_name", cl.getColor_name());
		model.addAttribute("color_hex", cl.getColor_hex());
		System.out.println();

		return "admin/color/edit";
	}

	@PostMapping("/colors/edited")
	public String UpdateColor(@RequestParam("color_id") String color_id, @RequestParam("color_name") String color_name,
			@RequestParam("color_hex") String color_hex, Model model) throws IOException {

		Colors cl = new Colors();
		cl.setColor_id(color_id);
		cl.setColor_name(color_name);
		cl.setColor_hex(color_hex);
		Colors saveColor = colorsRepo.update(cl);
		model.addAttribute("listColors", cl);
		return "redirect:/admin/colors";

	}


	@PostMapping("/colors/delete")
	public String DeleteColor(Model model, @RequestParam("idCo") String idCo, Colors color) {
		colorsRepo.deleteById(idCo);
		Iterable<Colors> colorlist = colorsRepo.findAll();
		model.addAttribute("listColors", colorlist);
		return "redirect:/admin/colors";
	}

	@GetMapping("/colors/active")
	public String Active(Model model, @RequestParam("idCo") String idCo, Colors color) {
		colorsRepo.active(idCo);
		Iterable<Colors> colorlist = colorsRepo.findAll();
		model.addAttribute("listColors", colorlist);
		return "redirect:/admin/colors";
	}

	@GetMapping("/colors/inactive")
	public String Inactive(Model model, @RequestParam("idCo") String idCo, Colors color) {
		colorsRepo.inactive(idCo);
		Iterable<Colors> colorlist = colorsRepo.findAll();
		model.addAttribute("listColors", colorlist);
		return "redirect:/admin/colors";
	}

}
