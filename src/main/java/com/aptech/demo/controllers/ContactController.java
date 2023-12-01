package com.aptech.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aptech.demo.models.Materials;
import com.aptech.demo.repositories.MaterialsRepository;
import com.aptech.demo.services.MailSenderService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@Autowired
	private MaterialsRepository mateRepo;
	
	@RequestMapping("")
	public String contactPage(Model model) {
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);

		return "default/contact";
	}
	
	@RequestMapping(value = "/sendtome", method = RequestMethod.POST)
	public String SendMailToMe(String message,String email, String first_name, String last_name, String phone) {
		
		String name =first_name + " " +  last_name;
		
	mailSenderService.sendEmailContact(email, name, phone, message);
		/* return "HTML email sent successfully!"; */
				
		return "redirect:/contact";
	}
}
