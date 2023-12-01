package com.aptech.demo.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.demo.models.Checkouts;
import com.aptech.demo.models.Delivery;
import com.aptech.demo.models.Deliveryitems;
import com.aptech.demo.models.Orderitems;
import com.aptech.demo.models.Orders;
import com.aptech.demo.models.Products;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.CheckoutRepository;
import com.aptech.demo.repositories.DeliveryItemRepository;
import com.aptech.demo.repositories.DeliveryRepository;
import com.aptech.demo.repositories.OrderItemRepository;
import com.aptech.demo.repositories.OrderRepository;
import com.aptech.demo.repositories.ProductsRepository;
import com.aptech.demo.repositories.UserRepository;

@Controller
@RequestMapping("/admin")
public class DeliveryController {
	@Autowired	
	private UserRepository userRepo;
	@Autowired
	private ProductsRepository prodRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderItemRepository orderitemRepo;
	@Autowired
	private DeliveryRepository deliveryRepo;	
	@Autowired
	private DeliveryItemRepository deliveryitemRepo;

	@RequestMapping("/deliveries")
	public String listAll(Model model) {

		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Delivery> listDeliveries = deliveryRepo.findAll();
		model.addAttribute("listDeliveries", listDeliveries);
		
//		List<Deliveryitems> listDeliveryItems = deliveryitemRepo.findAll();
//		model.addAttribute("listDeliveryItems", listDeliveryItems);
		
//		List<Checkouts> listCheckouts = checkoutRepo.findAll();
//		model.addAttribute("listCheckouts", listCheckouts);

		return "admin/delivery/index";
	}
	
	@RequestMapping("deliveries/viewdetail")
	public String viewdetail(@RequestParam("id") String id, Model model) {

		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Products> listProducts = prodRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		
		List<Orders> listOrders = orderRepo.findAll();
		model.addAttribute("listOrders", listOrders);
		
		List<Orderitems> listOrderItems = orderitemRepo.findAll();
		model.addAttribute("listOrderItems", listOrderItems);
		
		List<Delivery> listDeliveries = deliveryRepo.findAll();
		model.addAttribute("listDeliveries", listDeliveries);
		
		List<Deliveryitems> listDeliveryItems = deliveryitemRepo.findAll();
		model.addAttribute("listDeliveryItems", listDeliveryItems);
		
		Delivery d = deliveryRepo.findById(id);
		String deliveryid = d.getDelivery_id();
		String orderid = d.getOrder_id();
		
		Orders o = orderRepo.findById(orderid);
		String buyerid = o.getBuyerid();
		
		User u = userRepo.findById(buyerid);
		
		Deliveryitems di = deliveryitemRepo.findByDeliveryId(deliveryid);
//		String diDeliveryid = di.getDeliveryid();
		String orderitemid = di.getOrderitem_id();		
		
		Orderitems oi = orderitemRepo.findById(orderid);
//		String oiOrderid = oi.getOrderid();
		String productid = oi.getProductid();
		
		Products prod = prodRepo.findById(productid);
		String productname = prod.getProduct_name();
				
		model.addAttribute("delivery_id", d.getDelivery_id());
		model.addAttribute("order_id", d.getOrder_id());
		model.addAttribute("orderitem_id", oi.getOrderitem_id());
		
		model.addAttribute("product_name", prod.getProduct_name());		
		model.addAttribute("delivery_id", d.getDelivery_id());
		model.addAttribute("orderid", d.getOrderid());
		model.addAttribute("delivery_createdat", d.getDelivery_createdat());
		model.addAttribute("delivery_address", d.getDelivery_address());
		model.addAttribute("delivery_notes", d.getDelivery_notes());
		model.addAttribute("delivery_status", d.getDelivery_status());
		
		model.addAttribute("order_id", o.getOrder_id());
		model.addAttribute("order_createdat", o.getOrder_createdat());
		
		model.addAttribute("user_id", u.getUser_id());
		model.addAttribute("usertype", u.getUsertype());
		model.addAttribute("name", u.getName());
		model.addAttribute("email", u.getEmail());
		model.addAttribute("tel", u.getTel());
						
		return "admin/delivery/detail";
	}
	
}
