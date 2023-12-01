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
import com.aptech.demo.models.Paymentservices;
import com.aptech.demo.repositories.PaymentsRepository;
import com.aptech.demo.repositories.PaymentservicesRepository;

@Controller
@RequestMapping("/admin")
public class PaymentservicesController {
	@Autowired
	private PaymentservicesRepository payserRepo;
	@Autowired
	private PaymentsRepository paymRepo;


	@RequestMapping("/paysers")
	public String listAll(Model model) {
		List<Paymentservices> listPaysers = payserRepo.findAll();
		model.addAttribute("listPaysers", listPaysers);
		List<Payments> listPayments = paymRepo.findActive();
		model.addAttribute("listPayments", listPayments);
		return "admin/paymentservice/index";
	}

	@RequestMapping(value = "/paysers/insert")
	public String create(Model model) {
		model.addAttribute("paymentservices", new Paymentservices());
		List<Payments> listPayments = paymRepo.findActive();
		model.addAttribute("listPayments", listPayments);
		return "admin/paymentservice/insert";
	}

	@RequestMapping(value = "/paysers/inserted", method = RequestMethod.POST)
	public String Inserted(@RequestParam("paymentservice_id") String paymentservice_id,
			@RequestParam("paymentid") String paymentid,
			@RequestParam("paymentservice_name") String paymentservice_name,
			@RequestParam("payment_desc") String payment_desc, 
			Model model) throws IOException {
		Paymentservices payser = new Paymentservices();
		payser.setPaymentservice_id(paymentservice_id);
		payser.setPaymentservice_name(paymentservice_name);
		payser.setPayment_desc(payment_desc);
		payser.setPayment_active(1);
		payser.setPaymentid(paymentid);		
		Paymentservices savePayser = payserRepo.insert(payser);
		return "redirect:/admin/paysers";
	}

	@GetMapping("/paysers/edit")
	public String EditView(Model model, @RequestParam("id") String id) {
		List<Payments> listPayments = paymRepo.findActive();
		model.addAttribute("listPayments", listPayments);
		Paymentservices payser = payserRepo.findById(id);
		model.addAttribute("paymentservice_id", payser.getPaymentservice_id());
		model.addAttribute("paymentservice_name", payser.getPaymentservice_name());
		model.addAttribute("paymentid", payser.getPaymentid());
		model.addAttribute("payment_desc", payser.getPayment_desc());
		model.addAttribute("payment_active", payser.getPayment_active());

		System.out.println();

		return "admin/paymentservice/edit";
	}

	@PostMapping("/paysers/edited")
	public String UpdatePayser(@RequestParam("paymentservice_id") String paymentservice_id,
			@RequestParam("paymentid") String paymentid,
			@RequestParam("paymentservice_name") String paymentservice_name,
			@RequestParam("payment_desc") String payment_desc, Model model) throws IOException {

		Paymentservices perser = new Paymentservices();
		perser.setPaymentservice_id(paymentservice_id);
		perser.setPaymentid(paymentid);
		perser.setPaymentservice_name(paymentservice_name);
		perser.setPayment_desc(payment_desc);
		Paymentservices savePayser = payserRepo.update(perser);
		model.addAttribute("listPersers", perser);

		return "redirect:/admin/paysers";

	}
	
	@RequestMapping("paysers/viewdetail")
	public String viewdetail(@RequestParam("id") String id,Model model) {
		
		Paymentservices payser = payserRepo.findById(id);
		
		String prodgroupid = payser.getPaymentid();
		Payments payment = paymRepo.findById(prodgroupid);
		
		model.addAttribute("paymentservice_id", payser.getPaymentservice_id());
		model.addAttribute("paymentservice_name", payser.getPaymentservice_name());
		model.addAttribute("paymentname", payment.getPayment_name());
		model.addAttribute("paymentservice_desc", payser.getPayment_desc());
		model.addAttribute("payment_active", payser.getPayment_active());
		
		return "admin/paymentservice/detail";
	}

	/*
	 * @PostMapping("/cats/delete") public String Delete(@RequestParam String id) {
	 * catRepo.deleteById(id); return "redirect:/admin/cats"; }
	 */

	@PostMapping("/paysers/delete")
	public String DeletePayser(Model model, @RequestParam("id") String id, Paymentservices payser) {
		payserRepo.deleteById(id);
		Iterable<Paymentservices> payserlist = payserRepo.findAll();
		model.addAttribute("listPaysers", payserlist);
		return "redirect:/admin/paysers";
	}

	@GetMapping("/paysers/active")
	public String Active(Model model, @RequestParam("id") String id, Paymentservices payser) {
		// cat.setActive(cat_active);
		payserRepo.active(id);
		Iterable<Paymentservices> payserlist = payserRepo.findAll();
		model.addAttribute("listPaysers", payserlist);
		return "redirect:/admin/paysers";
	}

	@GetMapping("/paysers/inactive")
	public String Inactive(Model model, @RequestParam("id") String id, Paymentservices payser) {
		// cat.setActive(cat_active);
		payserRepo.inactive(id);
		Iterable<Paymentservices> payserlist = payserRepo.findAll();
		model.addAttribute("listPaysers", payserlist);
		return "redirect:/admin/paysers";
	}
}
