package com.aptech.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.demo.models.Materials;
import com.aptech.demo.models.Orderitems;
import com.aptech.demo.models.Orders;
import com.aptech.demo.models.Products;
import com.aptech.demo.models.Pstrategies;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.MaterialsRepository;
import com.aptech.demo.repositories.OrderItemRepository;
import com.aptech.demo.repositories.OrderRepository;
import com.aptech.demo.repositories.ProductsRepository;
import com.aptech.demo.repositories.PstrategiesRepository;
import com.aptech.demo.repositories.UserRepository;

@Controller
@RequestMapping("/admin")
public class OrderItemsController {
//	@Autowired
//	private CartsRepository cartRepo;
//	@Autowired
//	private CartitemsRepository cartitemRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderItemRepository orderitemRepo;
	@Autowired
	private ProductsRepository productRepo;
	@Autowired
	private MaterialsRepository matRepo;
	@Autowired
	private PstrategiesRepository pstratRepo;
	
//	@Autowired
//	private CheckoutRepository checkoutRepo;
//	@Autowired
//	private DeliveryRepository deliverRepo;

//	private final Path root = Paths.get("src", "main", "resources", "static", "upload");
//	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";


	@RequestMapping("/orderitems")
	public String listAll(Model model) {

		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Orders> listOrders = orderRepo.findAll();
		model.addAttribute("listOrders", listOrders);
		
		List<Orderitems> listOrderItems = orderitemRepo.findAll();
		model.addAttribute("listOrderItems", listOrderItems);
		
//		List<Checkouts> listCheckouts = checkoutRepo.findAll();
//		model.addAttribute("listCheckouts", listCheckouts);
//		
//		List<Delivery> listDelivery = deliverRepo.findAll();
//		model.addAttribute("listDelivery", listDelivery);

		return "admin/orderitems/index";
	}
	
	@RequestMapping("orders/orderitems")
	public String viewdetail(@RequestParam("id") String id, Model model) {

		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Orders> listOrders = orderRepo.findAll();
		model.addAttribute("listOrders", listOrders);
		
		List<Orderitems> listOrderItems = orderitemRepo.findAll();
		model.addAttribute("listOrderItems", listOrderItems);
		
		List<Products> listProducts = productRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		
		List<Materials> listMaterials = matRepo.findAll();
		model.addAttribute("listMaterias", listMaterials);
		
		List<Pstrategies> listPstrats = pstratRepo.findAll();
		model.addAttribute("listPstrats", listPstrats);
		
		Orders o = orderRepo.findById(id);
		model.addAllAttributes(listOrderItems);
		model.addAttribute("order_id", o.getOrder_id());
		model.addAttribute("buyerid", o.getBuyerid());
		model.addAttribute("order_createdat", o.getOrder_createdat());
		model.addAttribute("order_notes", o.getOrder_notes());
		model.addAttribute("total", o.getOrder_status());
		
		User u = userRepo.findById(o.getBuyerid());
		model.addAttribute("user_id", u.getUser_id());
		model.addAttribute("name", u.getName());
		model.addAttribute("email", u.getEmail());
		model.addAttribute("tel", u.getTel());
		model.addAttribute("address", u.getAddress());		
		
		Orderitems oi = orderitemRepo.findByOrderId(id);
		model.addAttribute("orderitem_id", oi.getOrderitem_id());
		model.addAttribute("orderid", oi.getOrderid());
		model.addAttribute("orderitem_notes", oi.getOrderitem_notes());
		model.addAttribute("productid", oi.getProductid());
		model.addAttribute("caritemid", oi.getCaritemid());
		model.addAttribute("subtotal", oi.getSubtotal());
		model.addAttribute("urgestt", oi.getUrgestt());
		model.addAttribute("orderitem_notes", oi.getOrderitem_notes());
		
		return "admin/order/detail";
	}


		
}