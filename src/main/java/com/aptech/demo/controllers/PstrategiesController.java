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

import com.aptech.demo.models.Materials;
import com.aptech.demo.models.Printers;
import com.aptech.demo.models.Pstrategies;
import com.aptech.demo.repositories.MaterialsRepository;
import com.aptech.demo.repositories.PrintersRepository;
import com.aptech.demo.repositories.PstrategiesRepository;

@Controller
@RequestMapping("/admin")
public class PstrategiesController {
	@Autowired
	private PstrategiesRepository pstratesRepo;
	@Autowired
	private MaterialsRepository MatesRepo;
	@Autowired
	private PrintersRepository printsRepo;

	@RequestMapping("/pstrategies")
	public String listAll(Model model) {
		List<Pstrategies> listPstrates = pstratesRepo.findAll();
		model.addAttribute("listPstrates", listPstrates);
		List<Materials> listMates = MatesRepo.findAll();
		model.addAttribute("listMates", listMates);
		List<Printers> listPrinters = printsRepo.findAll();
		model.addAttribute("listPrinters", listPrinters);
		return "admin/pstrategy/index";
	}

	@RequestMapping(value = "/pstrategies/insert")
	public String create(Model model) {
		model.addAttribute("pstrategies", new Pstrategies());
		List<Materials> listMates = MatesRepo.findActive();
		model.addAttribute("listMates", listMates);
		List<Printers> listPrinters = printsRepo.findActive();
		model.addAttribute("listPrinters", listPrinters);
		return "admin/pstrategy/insert";
	}

	@RequestMapping(value = "/pstrategies/inserted", method = RequestMethod.POST)
	public String InsertedMaterial(@RequestParam("pstrategy_id") String pstrategy_id,
			@RequestParam("pstrategy_name") String pstrategy_name, @RequestParam("matid") String matid,
			@RequestParam("printid") String printid, @RequestParam("ufabprice") Float ufabprice,
			@RequestParam("pstrategy_specs") String pstrategy_specs, @RequestParam("layerfineness") Float layerfineness,
			Model model) throws IOException {
		Pstrategies ps = new Pstrategies();
		ps.setPstrategy_id(pstrategy_id);
		ps.setPstrategy_name(pstrategy_name);
		ps.setMatid(matid);
		ps.setPrintid(printid);
		ps.setUfabprice(ufabprice);
		ps.setPstrategy_specs(pstrategy_specs);
		ps.setLayerfineness(layerfineness);
		ps.setPstrategy_continuity(1);
		ps.setPstrategy_active(1);

		Pstrategies savePstrates = pstratesRepo.insert(ps);
		return "redirect:/admin/pstrategies";
	}

	@GetMapping("/pstrategies/edit")
	public String EditView(Model model, @RequestParam("id") String id) {
		Pstrategies ps = pstratesRepo.findById(id);
		model.addAttribute("pstrategy_id", ps.getPstrategy_id());
		model.addAttribute("pstrategy_name", ps.getPstrategy_name());
		model.addAttribute("matid", ps.getMatid());
		model.addAttribute("printid", ps.getPrintid());
		model.addAttribute("ufabprice", ps.getUfabprice());
		model.addAttribute("pstrategy_specs", ps.getPstrategy_specs());
		model.addAttribute("layerfineness", ps.getLayerfineness());
		List<Materials> listMates = MatesRepo.findActive();
		model.addAttribute("listMates", listMates);
		List<Printers> listPrinters = printsRepo.findActive();
		model.addAttribute("listPrinters", listPrinters);
		System.out.println();

		return "admin/pstrategy/edit";
	}

	@PostMapping("/pstrategies/edited")
	public String UpdatePstrategy(@RequestParam("pstrategy_id") String pstrategy_id,
			@RequestParam("pstrategy_name") String pstrategy_name, @RequestParam("matid") String matid,
			@RequestParam("printid") String printid, @RequestParam("ufabprice") Float ufabprice,
			@RequestParam("pstrategy_specs") String pstrategy_specs, @RequestParam("layerfineness") Float layerfineness, Model model) throws IOException {

		Pstrategies ps = new Pstrategies();
		ps.setPstrategy_id(pstrategy_id);
		ps.setPstrategy_name(pstrategy_name);
		ps.setMatid(matid);
		ps.setPrintid(printid);
		ps.setUfabprice(ufabprice);
		ps.setPstrategy_specs(pstrategy_specs);
		ps.setLayerfineness(layerfineness);
		Pstrategies savePstrates = pstratesRepo.update(ps);
		model.addAttribute("listPstrates", ps);

		return "redirect:/admin/pstrategies";
	}
	
	@RequestMapping("pstrategies/viewdetail")
	public String viewdetail(@RequestParam("id") String id, Model model) {

		Pstrategies ps = pstratesRepo.findById(id);
		
		String materialId = ps.getMatid();
		Materials material = MatesRepo.findById(materialId);
		
		String printerId = ps.getPrintid();
		Printers printer = printsRepo.findById(printerId);

		model.addAttribute("pstrategy_id", ps.getPstrategy_id());
		model.addAttribute("pstrategy_name", ps.getPstrategy_name());
		model.addAttribute("matname", material.getMaterial_name());
		model.addAttribute("printname", printer.getPrint_name());
		model.addAttribute("ufabprice", ps.getUfabprice());
		model.addAttribute("pstrategy_specs", ps.getPstrategy_specs());
		model.addAttribute("layerfineness", ps.getLayerfineness());
		
		return "admin/pstrategy/detail";
	}

	@PostMapping("/pstrategies/delete")
	public String DeletePstrates(Model model, @RequestParam("id") String id, Pstrategies ps) {
		pstratesRepo.deleteById(id);
		Iterable<Pstrategies> pstrateslist = pstratesRepo.findAll();
		model.addAttribute("listPstrates", pstrateslist);
		return "redirect:/admin/pstrategies";
	}

	@GetMapping("/pstrategies/active")
	public String Active(Model model, @RequestParam("id") String id, Pstrategies ps) {
		pstratesRepo.active(id);
		Iterable<Pstrategies> pstrateslist = pstratesRepo.findAll();
		model.addAttribute("listPstrates", pstrateslist);
		return "redirect:/admin/pstrategies";
	}

	@GetMapping("/pstrategies/inactive")
	public String Inactive(Model model, @RequestParam("id") String id, Pstrategies ps) {
		pstratesRepo.inactive(id);
		Iterable<Pstrategies> pstrateslist = pstratesRepo.findAll();
		model.addAttribute("listPstrates", pstrateslist);
		return "redirect:/admin/pstrategies";
	}
}
