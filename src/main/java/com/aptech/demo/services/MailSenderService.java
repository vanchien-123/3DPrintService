package com.aptech.demo.services;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	private final TemplateEngine templateEngine;

	public MailSenderService(JavaMailSender mailSender, TemplateEngine templateEngine) {
		this.mailSender = mailSender;
		this.templateEngine = templateEngine;
	}

	public void sendEmailHTML(String to, String subject, Map<String, Object> model, String templateName) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);

			String content = templateEngine.process(templateName, new Context(Locale.getDefault(), model));
			helper.setText(content, true);

			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendMailRegister(String toEmail, String subject, String content) {

		/*
		 * SimpleMailMessage message = new SimpleMailMessage();
		 * message.setFrom("group3sem4@gmail.com"); message.setTo(toEmail);
		 * message.setSubject(subject); message.setText(body); mailSender.send(message);
		 * 
		 * System.out.print("Send mail success");
		 */

		Map<String, Object> model = new HashMap<>();
		model.put("toEmail", toEmail);
		model.put("subject", subject);
		model.put("content", content);

		sendEmailHTML(toEmail, subject, model, "email-register");

	}

	public void sendMailToMe(String toEmail, String subject, String content) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("group3sem4@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);

		System.out.print("Send mail success");
	}

	public void sendEmailContact(String email, String name, String phone, String message) {
		Map<String, Object> model = new HashMap<>();
		model.put("name", name);
		model.put("phone", phone);
		model.put("email", email);
		model.put("message", message);

		sendEmailHTML("group3sem4@gmail.com", "Quote", model, "email-contact");
	}
	
	public void sendMailToUserCheckOut(String toEmail, String subject, String content) {

		Map<String, Object> model = new HashMap<>();
		model.put("toEmail", toEmail);
		model.put("subject", subject);
		model.put("content", content);
		
		sendEmailHTML(toEmail, "Email Confirmation Information Order", model, "email-checkout");
	}
	
public void sendEmailReview(String id,String proName, String name, String email, String review) {
		
		Map<String, Object> model = new HashMap<>();
		model.put("proid", id);
		model.put("proname", proName);
		model.put("name", name);
		model.put("email", email);
		model.put("review", review);

		sendEmailHTML("vanchien0830@gmail.com", "Review", model, "email-review");
	}
	
	public void sendMailToMeCheckOut(String toEmail, String subject, String content) {

		Map<String, Object> model = new HashMap<>();
		model.put("toEmail", toEmail);
		model.put("subject", subject);
		model.put("content", content);
		
		sendEmailHTML(toEmail, "Order", model, "email-checkout");
	}
	
	public void sendMailCheckout(String toEmail, String subject, String content) {
		
		sendMailToUserCheckOut(toEmail, subject, content);
		
		sendMailToMeCheckOut("group3sem4@gmail", subject, content);
		
	}
}
