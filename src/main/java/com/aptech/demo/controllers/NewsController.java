package com.aptech.demo.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.demo.models.News;
import com.aptech.demo.repositories.NewsRepository;

@Controller
@RequestMapping("/admin")
public class NewsController {
	
	@Autowired
	private NewsRepository newsRepo;

	@RequestMapping("/news")
	public String listAll(Model model) {
		List<News> listNews = newsRepo.findAll();
		model.addAttribute("listNews", listNews);
		return "admin/news/index";
	}
	
	@RequestMapping("/reviews")
	public String listReview(Model model) {
		List<News> listNews = newsRepo.findReview();
		model.addAttribute("listNews", listNews);
		return "admin/news/index";
	}
	
	@RequestMapping("/blogs")
	public String listBlog(Model model) {
		List<News> listNews = newsRepo.findBlog();
		model.addAttribute("listNews", listNews);
		return "admin/news/index";
	}
	
	@RequestMapping("/events")
	public String listEvent(Model model) {
		List<News> listNews = newsRepo.findEvent();
		model.addAttribute("listNews", listNews);
		return "admin/news/index";
	}
	
	@RequestMapping("/testimonials")
	public String listTestimonial(Model model) {
		List<News> listNews = newsRepo.findTestimonials();
		model.addAttribute("listNews", listNews);
		return "admin/news/index";
	}
	@RequestMapping("/guides")
	public String listGuides(Model model) {
		List<News> listNews = newsRepo.findGuides();
		model.addAttribute("listNews", listNews);
		return "admin/news/index";
	}
	
	@RequestMapping(value = "/news/insert")
	public String create(Model model) {
		model.addAttribute("news", new News());
		return "admin/news/insert";
	}

	@RequestMapping(value = "/news/inserted", method = RequestMethod.POST)
	public String InsertedNews(@RequestParam("new_id") String new_id,
			@RequestParam("new_title") String new_title,
			@RequestParam("new_content") String new_content,
			@RequestParam("userid") String userid,
			@RequestParam("new_type") String new_type,
			@RequestParam("new_poststt") String new_poststt,
			@RequestParam("objectid") String objectid,
			/* @RequestParam("new_createdat") Date new_createdat, */
			/* @RequestParam("new_active") int new_active, */
			Model model) throws IOException {
		
		News news = new News();
		news.setNew_id(new_id);
		news.setNew_title(new_title);
		news.setNew_content(new_content);
		news.setUserid(userid);
		news.setNew_type(new_type);
		news.setNew_poststt(new_poststt);
		news.setObjectid(objectid);
		// Get Current Date
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		System.out.println(date);
		/* new_createdat = date; */
		news.setNew_createdat(date);
		news.setNew_active(0);
		@SuppressWarnings("unused")
		News saveNews = newsRepo.insert(news);
		return "redirect:/admin/news";
	}
	
	@GetMapping("/news/edit")
	public String EditView(Model model, @RequestParam("new_id") String new_id) {
		News news = newsRepo.findById(new_id);
		model.addAttribute("new_id", news.getNew_id());
		model.addAttribute("new_title", news.getNew_title());
		model.addAttribute("new_content", news.getNew_content());
		model.addAttribute("userid", news.getUserid());
		model.addAttribute("new_type", news.getNew_type());
		model.addAttribute("new_poststt", news.getNew_poststt());
		model.addAttribute("objectid", news.getObjectid());
		model.addAttribute("new_createdat", news.getNew_createdat());

		System.out.println(news);

		return "admin/news/edit";
	}

	@PostMapping("/news/edited")
	public String UpdateCustomer(@RequestParam("new_id") String new_id,
			@RequestParam("new_title") String new_title,
			@RequestParam("new_content") String new_content,
			@RequestParam("userid") String userid,
			@RequestParam("new_type") String new_type,
			@RequestParam("new_poststt") String new_poststt,
			@RequestParam("objectid") String objectid,
			Model model)
			throws IOException {

		News news = new News();
		
		news.setNew_id(new_id);
		news.setNew_title(new_title);
		news.setNew_content(new_content);
		news.setUserid(userid);
		news.setNew_type(new_type);
		news.setNew_poststt(new_poststt);
		news.setObjectid(objectid);
		// Get Current Date
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		System.out.println(date);
		news.setNew_createdat(date);
		
		News listNews = newsRepo.update(news);
		model.addAttribute("listNews", listNews);

		return "redirect:/admin/news";

	}
	
	@RequestMapping("news/viewdetail")
	public String viewdetail(@RequestParam("id") String id,Model model) {
		News news = newsRepo.findById(id);
		
		model.addAttribute("new_title", news.getNew_title());
		model.addAttribute("new_createdat", news.getNew_createdat());
		model.addAttribute("userid", news.getUserid());
		model.addAttribute("new_content", news.getNew_content());
		
		return "admin/news/detail";
	}
	

	/*
	 * @PostMapping("/cats/delete") public String Delete(@RequestParam String id) {
	 * catRepo.deleteById(id); return "redirect:/admin/cats"; }
	 */

	@PostMapping("/news/delete")
	public String DeleteCustomer(Model model, @RequestParam("new_id") String new_id, News news) {
		newsRepo.deleteById(new_id);
		Iterable<News> newsList = newsRepo.findAll();
		model.addAttribute("listNews", newsList);
		return "redirect:/admin/news";
	}

	@GetMapping("/news/active")
	public String Active( Model model, @RequestParam("new_id") String new_id, News news)
	{
		//cat.setActive(cat_active);
		newsRepo.active(new_id);
		Iterable<News> newslist = newsRepo.findAll();
		model.addAttribute("listNews", newslist);
		return "redirect:/admin/news";
	}
	
	@GetMapping("/news/inactive")
	public String Inactive( Model model, @RequestParam("new_id") String new_id, News news)
	{
		//cat.setActive(cat_active);
		newsRepo.inactive(new_id);
		Iterable<News> newslist = newsRepo.findAll();
		model.addAttribute("listNews", newslist);
		return "redirect:/admin/news";
	}
}
