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

import com.aptech.demo.models.Payments;
import com.aptech.demo.repositories.PaymentsRepository;



@Controller
@RequestMapping("/admin")
public class PaymentsController {
	@Autowired

	private PaymentsRepository paymRepo;

	@RequestMapping("/payments")
	public String listAll(Model model) {
		List<Payments> listPayments = paymRepo.findAll();
		model.addAttribute("listPayments", listPayments);
		return "admin/payment/index";
	}

	@RequestMapping(value = "/payments/insert")
	public String create(Model model) {
		model.addAttribute("payments", new Payments());
		return "admin/payment/insert";
	}

	@RequestMapping(value = "/payments/inserted", method = RequestMethod.POST)
	public String InsertedPayment(@RequestParam("payment_id") String payment_id, @RequestParam("payment_name") String payment_name,
			@RequestParam("payment_type") String payment_type, Model model) throws IOException {
		Payments paym = new Payments();
		paym.setPayment_id(payment_id);
		paym.setPayment_name(payment_name);
		paym.setPayment_type(payment_type);
		paym.setPayment_active(1);
		Payments savePaym = paymRepo.insert(paym);
		return "redirect:/admin/payments";
	}

	@GetMapping("/payments/edit")
	public String EditView(Model model, @RequestParam("id") String id) {
		Payments paym = paymRepo.findById(id);
		model.addAttribute("payment_id", paym.getPayment_id());
		model.addAttribute("payment_name", paym.getPayment_name());
		model.addAttribute("payment_type", paym.getPayment_type());
		model.addAttribute("payment_active", paym.getPayment_active());
		System.out.println();

		return "admin/payment/edit";
	}

	@PostMapping("/payments/edited")
	public String UpdatePayment(@RequestParam("payment_id") String payment_id, @RequestParam("payment_name") String payment_name,
			@RequestParam("payment_type") String payment_type, Model model) throws IOException {

		Payments paym = new Payments();
		paym.setPayment_id(payment_id);
		paym.setPayment_name(payment_name);
		paym.setPayment_type(payment_type);
		Payments savePaym = paymRepo.update(paym);
		model.addAttribute("listProducts", paym);

		return "redirect:/admin/payments";

	}

	/*
	 * @PostMapping("/cats/delete") public String Delete(@RequestParam String id) {
	 * catRepo.deleteById(id); return "redirect:/admin/cats"; }
	 */

	@PostMapping("/payments/delete")
	public String DeletePayment(Model model, @RequestParam("id") String id, Payments paym) {
		paymRepo.deleteById(id);
		Iterable<Payments> paymlist = paymRepo.findAll();
		model.addAttribute("listPayments", paymlist);
		return "redirect:/admin/payments";
	}

	@GetMapping("/payments/active")
	public String Active(Model model, @RequestParam("id") String id, Payments paym) {
		// cat.setActive(cat_active);
		paymRepo.active(id);
		Iterable<Payments> paymlist = paymRepo.findAll();
		model.addAttribute("listPayments", paymlist);
		return "redirect:/admin/payments";
	}

	@GetMapping("/payments/inactive")
	public String Inactive(Model model, @RequestParam("id") String id, Payments paym) {
		// cat.setActive(cat_active);
		paymRepo.inactive(id);
		Iterable<Payments> paymlist = paymRepo.findAll();
		model.addAttribute("listPayments", paymlist);
		return "redirect:/admin/payments";
	}
}
