package com.aptech.demo.controllers;

import com.aptech.demo.models.Manufacturers;
import com.aptech.demo.models.Materials;
import com.aptech.demo.models.Prodgroups;
import com.aptech.demo.models.Products;
import com.aptech.demo.models.Subcats;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.ManufacturersRepository;
import com.aptech.demo.repositories.MaterialsRepository;
import com.aptech.demo.repositories.ProdgroupsRepository;
import com.aptech.demo.repositories.ProductsRepository;
import com.aptech.demo.repositories.SubcatsRepository;
import com.aptech.demo.repositories.UserRepository;
import com.aptech.demo.services.MailSenderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class AuthController {
	
	@Autowired
	JdbcTemplate db;
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
	private MailSenderService mailSenderService;
	@Autowired
	private MaterialsRepository mateRepo;

	/*
	 * @GetMapping("/login") public String loginPage(Model model) {
	 * model.addAttribute("loginRequest", new User()); return "default/login"; }
	 */
	@RequestMapping("/admins")
	public String adminIndex(Model model, HttpServletRequest request) {
		String roles = (String) request.getSession().getAttribute("roles");
		List<Products> listProducts = proRepo.findActive();
		model.addAttribute("listProducts", listProducts);
		List<Prodgroups> listProdgroups = prodgrRepo.findAll();
		model.addAttribute("listProdgroups", listProdgroups);
		List<Subcats> listScats = scatRepo.findAll();
		model.addAttribute("listScats", listScats);
		List<Manufacturers> listMfgers = mnFactsRepo.findAll();
		model.addAttribute("listMfgers", listMfgers);
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);
		return "default/user/index";
	}

	@RequestMapping(value = { "/login" })
	public String UserLogin(Model model) {
		
		System.out.println("\n-------- HomeController.login --- ");
		return "default/login";
		
	}
	
	@RequestMapping("/logout")
	public String log(HttpSession session) {
		session.removeAttribute("admin");
		session.removeAttribute("customer");
		session.removeAttribute("object");
		return "redirect:/";
	}

	// Request register khi submit button
	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public String CreateUser(@RequestParam("usertype") String username, @RequestParam("name") String fullname,
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("tel") String tel, @RequestParam("address") String address, Model model) throws IOException {

		String alert = "";
		String notice = "";
		try {

			String sql = "SELECT count(email) email FROM users WHERE email = ?";
			int count = db.queryForObject(sql, Integer.class, email);
			
			if (count >= 1) {
				notice = "Email is exists, please try another email! ";
				model.addAttribute("notice", notice);
				return "default/login";
			}
			User user = new User();
			String id = "U001001" + generate();
			user.setUser_id(id);
			user.setUsertype(username);
			user.setName(fullname);
			user.setPassword(password);
			user.setEmail(email);
			user.setTel(tel);
			user.setAddress(address);
			user.setRole("customer");
			user.setUser_active(1);

			model.addAttribute("users", new User());

			

			// thêm user
			User saveUser = userRepo.insert(user);
			System.out.println("register success, please try login");
			alert = "Register Success";
			model.addAttribute("alert", alert);
			
			mailSenderService.sendMailRegister(email, "Mail Confirmation",
					"Your account has been created successfully!!");
			
			return "default/login";
			
		} catch (Exception e) {
			/*
			 * notice = "Email is exists, please try another email! ";
			 * model.addAttribute("notice", notice); return "default/login";
			 */
			
			System.out.print(e.getMessage());
		}
		return "";
		

	}

	// check login
	@RequestMapping(value = "/logined", method = RequestMethod.POST)
	public String check_account(@RequestParam("email") String email, @RequestParam("password") String password,
			 HttpSession session) {

		String sql = "select count(*) from users where email = ? and password= ? and user_active = '1'";
		int count = db.queryForObject(sql, Integer.class, email,password);
		 
		 if(count == 0) {
			 return "redirect:/login";
		 }else if(count == 1){
			 User user = userRepo.findByEmail(email);
			 
			 String tmp = "";
			 
			 if(user.getRole().contains("admin")) {
				 tmp = "admin";
				 session.setAttribute("admin", tmp);
			 }else {
				 tmp = "customer";
				 session.setAttribute("customer", tmp);
			 }
			 
			System.out.print(tmp);
			
			session.setAttribute("object", user);
			System.out.print(user);
			
			 return "redirect:/";
		 } else {
			 return "redirect:/login";
		 }

	}

	// Create random id for user
	public String generate() {
		final String Letters = "abcdefghijklmnopqstuvwxyz";
		final char[] Alpha = (Letters + Letters.toUpperCase() + "0123456789").toCharArray();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			result.append(Alpha[new Random().nextInt(Alpha.length)]);
		}
		return result.toString();
	}
}
