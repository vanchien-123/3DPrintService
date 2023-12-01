package com.aptech.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.demo.models.Materials;
import com.aptech.demo.models.News;
import com.aptech.demo.repositories.MaterialsRepository;
import com.aptech.demo.repositories.NewsRepository;

@Controller
@RequestMapping("")
public class NewPageController {

	@Autowired
	private NewsRepository newsRepo;
	
	@Autowired
	private MaterialsRepository mateRepo;
	
	@RequestMapping("/news")
	public String listAll(Model model) {
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);
		List<News> listNews = newsRepo.findAll();
		model.addAttribute("listNews", listNews);
		return "default/news/index";
	}
	
	@RequestMapping("/reviews")
	public String listReview(Model model) {
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);
		List<News> listNews = newsRepo.findReview();
		model.addAttribute("listNews", listNews);
		return "default/news/index";
	}
	
	@RequestMapping("/blogs")
	public String listBlog(Model model) {
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);
		List<News> listNews = newsRepo.findBlog();
		model.addAttribute("listNews", listNews);
		return "default/news/index";
	}
	
	@RequestMapping("/events")
	public String listEvent(Model model) {
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);
		List<News> listNews = newsRepo.findEvent();
		model.addAttribute("listNews", listNews);
		return "default/news/index";
	}
	
	@RequestMapping("/testimonials")
	public String listTestimonial(Model model) {
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);
		List<News> listNews = newsRepo.findTestimonials();
		model.addAttribute("listNews", listNews);
		return "default/news/index";
	}
	
	@RequestMapping("/guides")
	public String listGuides(Model model) {
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);
		List<News> listNews = newsRepo.findGuides();
		model.addAttribute("listNews", listNews);
		return "default/news/index";
	}
	
	@RequestMapping("/viewdetail")
	public String viewdetail(@RequestParam("id") String id,Model model) {
		
		List<Materials> listMate = mateRepo.findAll();
		model.addAttribute("listMate", listMate);
		
		News news = newsRepo.findById(id);
		
		model.addAttribute("new_id", news.getNew_id());
		model.addAttribute("new_title", news.getNew_title());
		model.addAttribute("new_content", news.getNew_content());
		model.addAttribute("userid", news.getUserid());
		model.addAttribute("new_type", news.getNew_type());
		model.addAttribute("new_poststt", news.getNew_poststt());
		model.addAttribute("objectid", news.getObjectid());
		model.addAttribute("new_createdat", news.getNew_createdat());
		
		return "default/news/detail";
	}
}
