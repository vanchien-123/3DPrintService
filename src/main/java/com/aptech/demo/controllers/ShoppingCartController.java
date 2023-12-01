package com.aptech.demo.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.demo.models.Cartitems;
import com.aptech.demo.models.Carts;
import com.aptech.demo.models.Materials;
import com.aptech.demo.models.Products;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.CartitemsRepository;
import com.aptech.demo.repositories.CartsRepository;
import com.aptech.demo.repositories.MaterialsRepository;
import com.aptech.demo.repositories.ProductsRepository;


import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

	@Autowired
	private CartsRepository cartRepo;
	
	@Autowired
	private MaterialsRepository MatesRepo;
	
	@Autowired
	private ProductsRepository productRepo;
	
	@Autowired
	private CartitemsRepository cartitemRepo;
	
	

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public String viewCart(@RequestParam("proid") String proid, @RequestParam("mate") Float matPrice,
			@RequestParam("print") String printid,
			@RequestParam("subtotal") Float subtotal, HttpSession session) {

		Products pro = productRepo.findById(proid);
		
		if(pro != null) {
			
			String cartitemId = "CT001" + generate();
			String cartId = "C01" + generate();
			System.out.print(cartitemId + "---" + cartId);

			Carts carts = new Carts();

			carts.setCart_id(cartId);
			Object obj = session.getAttribute("object");
			User user = (User)obj;
			String userId = user.getUser_id();
			System.out.print(  "---" + userId);
			carts.setBuyerid(userId);
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			carts.setCart_createdat(date);
			carts.setCart_notes("note again");
			carts.setCart_status(1);

			cartRepo.insert(carts);
			
			
			Materials material = MatesRepo.findByPrice(matPrice);
			String materialId = material.getMaterial_id();

			Cartitems cartItem = new Cartitems();

			cartItem.setCartitem_id(cartitemId);
			cartItem.setCartid(cartId);
			cartItem.setProductid(proid);
			cartItem.setScaleup((float) 1.00);
			cartItem.setQtt(1);
			cartItem.setPrintid(printid);
			cartItem.setMatid(materialId);
			cartItem.setCartitem_status(1);
			cartItem.setSubtotal(subtotal);

			cartitemRepo.insert(cartItem);
		}
		
		
		
		return "redirect:/";
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
