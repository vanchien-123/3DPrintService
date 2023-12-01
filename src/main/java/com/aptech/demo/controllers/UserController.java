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

import com.aptech.demo.models.User;
import com.aptech.demo.repositories.UserRepository;
import com.aptech.demo.services.MailSenderService;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired

	private UserRepository userRepo;
	@Autowired
	private MailSenderService mailSenderService;

	@RequestMapping("/user")
	public String listAll(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "admin/user/index";
	}
	
	@RequestMapping(value = "/user/insert")
	public String create(Model model) {
		model.addAttribute("user", new User());
		return "admin/user/insert";
	}

	@RequestMapping(value = "/user/inserted", method = RequestMethod.POST)
	public String InsertedCat(@RequestParam("user_id") String user_id,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("tel") String tel,
			@RequestParam("address") String address,
			@RequestParam("role") String role,
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
		
		mailSenderService.sendMailRegister(
				email,
				"Mail Confirmation",
				"Your account has been created successfully!!"
				);
		
		User saveUser = userRepo.insert(user);
		return "redirect:/admin/user";
	}
	
	@GetMapping("/user/edit")
	public String EditView(Model model, @RequestParam("user_id") String user_id) {
		User user = userRepo.findById(user_id);
		model.addAttribute("id", user.getUser_id());
		model.addAttribute("name", user.getName());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("tel", user.getTel());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("role", user.getRole());

		System.out.println(user);

		return "admin/user/edit";
	}
	
	@PostMapping("/user/edited")
	public String UpdateCustomer(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("tel") String tel,
			@RequestParam("address") String address,
			@RequestParam("role") String role,
			Model model)
			throws IOException {

		User user = new User();
		
		user.setUser_id(id);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setTel(tel);
		user.setAddress(address);
		user.setRole(role);
		
		User listUser = userRepo.update(user);
		model.addAttribute("listUser", listUser);

		return "redirect:/admin/user";

	}
	
	
//	========================
//	update method for Users
//	========================
	
	
	@PostMapping("/user/delete")
	public String DeleteCustomer(Model model, @RequestParam("user_id") String user_id, User user) {
		userRepo.deleteById(user_id);
		Iterable<User> userList = userRepo.findAll();
		model.addAttribute("userList", userList);
		return "redirect:/admin/user";
	}

	@GetMapping("/user/active")
	public String Active( Model model, @RequestParam("user_id") String user_id, User user)
	{
		//cat.setActive(cat_active);
		userRepo.active(user_id);
		Iterable<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "redirect:/admin/user";
	}
	
	@GetMapping("/user/inactive")
	public String Inactive( Model model, @RequestParam("user_id") String user_id, User user)
	{
		//cat.setActive(cat_active);
		userRepo.inactive(user_id);
		Iterable<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "redirect:/admin/user";
	}
	
}
