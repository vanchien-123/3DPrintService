package com.aptech.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aptech.demo.models.Checkouts;
import com.aptech.demo.models.Delivery;
import com.aptech.demo.models.Orderitems;
import com.aptech.demo.models.Orders;
import com.aptech.demo.models.Products;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.CartitemsRepository;
import com.aptech.demo.repositories.CartsRepository;
import com.aptech.demo.repositories.CheckoutRepository;
import com.aptech.demo.repositories.DeliveryRepository;
import com.aptech.demo.repositories.OrderItemRepository;
import com.aptech.demo.repositories.OrderRepository;
import com.aptech.demo.repositories.ProductsRepository;
import com.aptech.demo.repositories.UserRepository;

@Controller
@RequestMapping("/admin")
public class OrdersController {
//	@Autowired
//	private CartsRepository cartRepo;
	@Autowired
	private CartitemsRepository cartitemRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderItemRepository orderitemRepo;
	@Autowired
	private ProductsRepository prodRepo;
	
//	@Autowired
//	private CheckoutRepository checkoutRepo;
//	@Autowired
//	private DeliveryRepository deliverRepo;

	@RequestMapping("/orders")
	public String listAll(Model model) {

		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Orders> listOrders = orderRepo.findAll();
		model.addAttribute("listOrders", listOrders);
		
//		List<Orderitems> listOrderItems = orderitemRepo.findAll();
//		model.addAttribute("listOrderItems", listOrderItems);
		
//		List<Checkouts> listCheckouts = checkoutRepo.findAll();
//		model.addAttribute("listCheckouts", listCheckouts);
//		
//		List<Delivery> listDelivery = deliveryRepo.findAll();
//		model.addAttribute("listDelivery", listDelivery);

		return "admin/order/index";
	}
	
	@RequestMapping("orders/viewdetail")
	public String viewdetail(@RequestParam("id") String id, Model model) {
		
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Products> listProducts = prodRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		
		List<Orders> listOrders = orderRepo.findAll();
		model.addAttribute("listOrders", listOrders);
		
		List<Orderitems> listOrderItems = orderitemRepo.findAll();
		model.addAttribute("listOrderItems", listOrderItems);
		
//		List<Deliveryitems> listDeliveryItems = deliveryitemRepo.findAll();
//		model.addAttribute("listDeliveryItems", listDeliveryItems);
		Orders o = orderRepo.findById(id);
		String orderid = o.getOrder_id();
		String buyerid = o.getBuyerid();
		
		User u = userRepo.findById(buyerid);
		
		Orderitems oi = orderitemRepo.findByOrderId(orderid);
//		String oiOrderid = oi.getOrderid();
		String productid = oi.getProductid();
				
		Products prod = prodRepo.findById(productid);
		String productname = prod.getProduct_name();
				
		model.addAttribute("product_name", prod.getProduct_name());
		model.addAttribute("order_id", o.getOrder_id());
		model.addAttribute("buyerid", o.getBuyerid());
		model.addAttribute("order_createdat", o.getOrder_createdat());
		model.addAttribute("order_notes", o.getOrder_notes());
		model.addAttribute("total", o.getTotal());
		model.addAttribute("order_status", o.getOrder_status());
		
		model.addAttribute("user_id", u.getUser_id());
		model.addAttribute("usertype", u.getUsertype());
		model.addAttribute("name", u.getName());
		model.addAttribute("email", u.getEmail());
		model.addAttribute("tel", u.getTel());
		model.addAttribute("address", u.getAddress());
		
		model.addAttribute("orderitem_id", oi.getOrderitem_id());
		model.addAttribute("orderid", oi.getOrderid());
		model.addAttribute("productid", oi.getProductid());
		model.addAttribute("caritemid", oi.getCaritemid());
		model.addAttribute("subtotal", oi.getSubtotal());
		model.addAttribute("urgestt", oi.getUrgestt());
		model.addAttribute("orderitem_notes", oi.getOrderitem_notes());
		
		return "admin/order/detail";
	}
	
}