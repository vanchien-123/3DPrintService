package com.aptech.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.demo.models.Manufacturers;
import com.aptech.demo.models.Materials;
import com.aptech.demo.models.Printers;
import com.aptech.demo.models.Prodgroups;
import com.aptech.demo.models.Products;
import com.aptech.demo.models.Pstrategies;
import com.aptech.demo.models.Subcats;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.ManufacturersRepository;
import com.aptech.demo.repositories.MaterialsRepository;
import com.aptech.demo.repositories.PrintersRepository;
import com.aptech.demo.repositories.ProdgroupsRepository;
import com.aptech.demo.repositories.ProductsRepository;
import com.aptech.demo.repositories.PstrategiesRepository;
import com.aptech.demo.repositories.SubcatsRepository;
import com.aptech.demo.repositories.UserRepository;
import com.aptech.demo.services.MailSenderService;

@Controller
public class HomeController {
	@Autowired
	private ProductsRepository proRepo;
	@Autowired
	private ProdgroupsRepository prodgrRepo;
	@Autowired
	private SubcatsRepository scatRepo;
	@Autowired
	private ManufacturersRepository mnFactsRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MaterialsRepository MatesRepo;
	@Autowired
	private PstrategiesRepository pstratesRepo;
	@Autowired
	private PrintersRepository PtRepo;
	@Autowired
	private MailSenderService mailSenderService;

	@GetMapping("/")
	public String homePage(Model model) {
		List<Products> listProducts = proRepo.findActive();
		model.addAttribute("listProducts", listProducts);
		List<Prodgroups> listProdgroups = prodgrRepo.findAll();
		model.addAttribute("listProdgroups", listProdgroups);
		List<Subcats> listScats = scatRepo.findAll();
		model.addAttribute("listScats", listScats);
		List<Manufacturers> listMfgers = mnFactsRepo.findAll();
		model.addAttribute("listMfgers", listMfgers);
		List<Materials> listMate = MatesRepo.findAll();
		model.addAttribute("listMate", listMate);

		return "default/index";
	}

	

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String UserRegister(@RequestParam("user_id") String user_id, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("tel") String tel, @RequestParam("address") String address, @RequestParam("role") String role,
			Model model) throws IOException {

		User user = new User();

		user.setUser_id(user_id);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setTel(tel);
		user.setAddress(address);
		user.setRole(role);
		user.setUser_active(1);

		mailSenderService.sendMailRegister(email, "Mail Confirmation", "Your account has been created successfully!!");
		User saveUser = userRepo.insert(user);
		
		return "default/login";
	}
	
	@RequestMapping("productgroup-viewdetail")
	public String viewdetail1(@RequestParam("id") String id,Model model) {
		List<Materials> listMate = MatesRepo.findAll();
		model.addAttribute("listMate", listMate);
		List<Prodgroups> listProdgroups = prodgrRepo.findAll();
		model.addAttribute("listProdgroups", listProdgroups);
		Prodgroups mates = prodgrRepo.findById(id);
		
		return "default/productgroupDetail";
	}
	
	@RequestMapping("material-viewdetail")
	public String viewdetail(@RequestParam("id") String id,Model model) {
		
		List<Materials> listMate = MatesRepo.findAll();
		model.addAttribute("listMate", listMate);
		
		Materials mates = MatesRepo.findById(id);
		
		model.addAttribute("material_id", mates.getMaterial_id());
		model.addAttribute("material_name", mates.getMaterial_name());
		model.addAttribute("colorid", mates.getColorid());
		model.addAttribute("density", mates.getDensity());
		model.addAttribute("material_uprice", mates.getMaterial_uprice());
		model.addAttribute("mfgerid", mates.getMfgerid());
		model.addAttribute("material_desc", mates.getMaterial_desc());
		model.addAttribute("material_continuity", mates.getMaterial_continuity());	
		
		return "default/materialDetail";
	}
	
	@GetMapping("/productDetails")
	public String productDetails(Model model, @RequestParam("id") String id) {

		Products pro = proRepo.findById(id);

		String prodgroupid = pro.getProdgroupid();
		Prodgroups prod = prodgrRepo.findById(prodgroupid);

		String subcatId = pro.getSubcatid();
		Subcats subcat = scatRepo.findById(subcatId);

		String mfgerid = pro.getMfgerid();
		Manufacturers mfger = mnFactsRepo.findById(mfgerid);

		model.addAttribute("product_id", pro.getProduct_id());
		model.addAttribute("subcatid",pro.getSubcatid());
		model.addAttribute("prodgroupid",pro.getProdgroupid());
		model.addAttribute("prodgroupname", prod.getProdgroup_name());
		model.addAttribute("subcatname", subcat.getSubcat_name());
		model.addAttribute("mfgername", mfger.getMfger_name());
		model.addAttribute("product_name", pro.getProduct_name());
		model.addAttribute("product_desc", pro.getProduct_desc());
		model.addAttribute("sizeX", pro.getSizeX());
		model.addAttribute("sizeY", pro.getSizeY());
		model.addAttribute("sizeZ", pro.getSizeZ());
		model.addAttribute("vol", pro.getVol());
		model.addAttribute("weight", pro.getWeight());
		model.addAttribute("img1", pro.getImg1());
		model.addAttribute("img2", pro.getImg2());
		model.addAttribute("img3", pro.getImg3());
		model.addAttribute("stl", pro.getStl());
		model.addAttribute("product_continuity", pro.getProduct_continuity());
		model.addAttribute("product_active", pro.getProduct_active());
		model.addAttribute("product_createdat", pro.getProduct_createdat());		
		List<Products> listProducts = proRepo.findActive();
		model.addAttribute("listProducts", listProducts);
		List<Prodgroups> listProdgroups = prodgrRepo.findAll();
		model.addAttribute("listProdgroups", listProdgroups);
		List<Subcats> listScats = scatRepo.findAll();
		model.addAttribute("listScats", listScats);
		List<Manufacturers> listMfgers = mnFactsRepo.findAll();
		model.addAttribute("listMfgers", listMfgers);
		List<Materials> listMates = MatesRepo.findAll();
		model.addAttribute("listMates", listMates);
		List<Pstrategies> listPstrates = pstratesRepo.findAll();
		model.addAttribute("listPstrates", listPstrates);
		List<Printers> listPris = PtRepo.findAll();
		model.addAttribute("listPris", listPris);
		
		return "default/product_details";
	}
	
	@RequestMapping(value = "/sendreview", method = RequestMethod.POST)
	public String SendMailReview(String productid, String productname, String name, String email, String review) {
		
		mailSenderService.sendEmailReview(productid, productname, name, email, review);
				
		return "redirect:/";
	}
}
