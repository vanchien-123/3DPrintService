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
import com.aptech.demo.models.Printers;
import com.aptech.demo.models.Technologies;
import com.aptech.demo.repositories.ColorsRepository;
import com.aptech.demo.repositories.ManufacturersRepository;
import com.aptech.demo.repositories.MaterialsRepository;
import com.aptech.demo.repositories.PrintersRepository;
import com.aptech.demo.repositories.TechnologiesRepository;

@Controller
@RequestMapping("/admin")
public class PrintersController {
	@Autowired
	private PrintersRepository PtRepo;
	@Autowired
	private TechnologiesRepository TnRepo;
	@Autowired
	private ManufacturersRepository MnRepo;

	@RequestMapping("/printers")
	public String listAll(Model model) {
		List<Printers> listPris = PtRepo.findAll();
		model.addAttribute("listPris", listPris);
		List<Technologies> listTechs = TnRepo.findAll();
		model.addAttribute("listTechs", listTechs);
		List<Manufacturers> listManus = MnRepo.findAll();
		model.addAttribute("listManus", listManus);
		return "admin/printer/index";
	}

	@RequestMapping(value = "/printers/insert")
	public String Create(Model model) {
		model.addAttribute("pris", new Printers());
		List<Technologies> listTechs = TnRepo.findActive();
		model.addAttribute("listTechs", listTechs);
		List<Manufacturers> listManus = MnRepo.findActive();
		model.addAttribute("listManus", listManus);
		return "admin/printer/insert";
	}

	@RequestMapping(value = "/printers/inserted", method = RequestMethod.POST)
	public String InsertedMaterial(@RequestParam("print_id") String print_id, @RequestParam("mfgerid") String mfgerid,
			@RequestParam("technolid") String technolid, @RequestParam("print_name") String print_name,
			@RequestParam("print_specs") String print_specs, Model model) throws IOException {
		Printers pt = new Printers();
		pt.setPrint_id(print_id);
		pt.setMfgerid(mfgerid);
		pt.setTechnolid(technolid);
		pt.setPrint_name(print_name);
		pt.setPrint_specs(print_specs);
		Printers savePrinters = PtRepo.insert(pt);
		return "redirect:/admin/printers";
	}

	@GetMapping("/printers/edit")
	public String EditView(Model model, @RequestParam("idPt") String id) {
		Printers pt = PtRepo.findById(id);
		model.addAttribute("print_id", pt.getPrint_id());
		model.addAttribute("mfgerid", pt.getMfgerid());
		model.addAttribute("technolid", pt.getTechnolid());
		model.addAttribute("print_name", pt.getPrint_name());
		model.addAttribute("print_specs", pt.getPrint_specs());
		List<Technologies> listTechs = TnRepo.findActive();
		model.addAttribute("listTechs", listTechs);
		List<Manufacturers> listManus = MnRepo.findActive();
		model.addAttribute("listManus", listManus);
		System.out.println();
		return "admin/printer/edit";
	}

	@PostMapping("/printers/edited")
	public String UpdateMaterial(@RequestParam("print_id") String print_id, @RequestParam("mfgerid") String mfgerid,
			@RequestParam("technolid") String technolid, @RequestParam("print_name") String print_name,
			@RequestParam("print_specs") String print_specs, Model model) throws IOException {

		Printers pt = new Printers();
		pt.setPrint_id(print_id);
		pt.setMfgerid(mfgerid);
		pt.setTechnolid(technolid);
		pt.setPrint_name(print_name);
		pt.setPrint_specs(print_specs);
		Printers savePrinters = PtRepo.update(pt);
		model.addAttribute("listPris", pt);

		return "redirect:/admin/printers";

	}
	
	@RequestMapping("printers/viewdetail")
	public String viewdetail(@RequestParam("id") String id,Model model) {
		
		Printers pt = PtRepo.findById(id);
		model.addAttribute("print_id", pt.getPrint_id());
		model.addAttribute("mfgerid", pt.getMfgerid());
		model.addAttribute("technolid", pt.getTechnolid());
		model.addAttribute("print_name", pt.getPrint_name());
		model.addAttribute("print_specs", pt.getPrint_specs());
		List<Technologies> listTechs = TnRepo.findActive();
		model.addAttribute("listTechs", listTechs);
		List<Manufacturers> listManus = MnRepo.findActive();
		model.addAttribute("listManus", listManus);
		
		return "admin/printer/detail";
	}

	@PostMapping("/printers/delete")
	public String DeletePrinter(Model model, @RequestParam("idPt") String idPt, Printers pts) {
		PtRepo.deleteById(idPt);
		Iterable<Printers> ptslist = PtRepo.findAll();
		model.addAttribute("listPris", ptslist);
		return "redirect:/admin/printers";
	}

	@GetMapping("/printers/active")
	public String Active(Model model, @RequestParam("idPt") String idPt, Printers pts) {
		PtRepo.active(idPt);
		Iterable<Printers> ptslist = PtRepo.findAll();
		model.addAttribute("listPris", ptslist);
		return "redirect:/admin/printers";
	}

	@GetMapping("/printers/inactive")
	public String Inactive(Model model, @RequestParam("idPt") String idPt, Printers pts) {
		PtRepo.inactive(idPt);
		Iterable<Printers> ptslist = PtRepo.findAll();
		model.addAttribute("listPris", ptslist);
		return "redirect:/admin/printers";
	}
}
