package com.example.demo.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Account;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Order;
import com.example.demo.entities.OrderDetail;
import com.example.demo.entities.SmartPhone;
import com.example.demo.mapper.SmartPhoneMapper;
import com.example.demo.service.AccountService;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.ShoppingCartService;

@Controller
@RequestMapping("/user/shopSmartPhone")
public class ShopController {
	@Autowired
	private SmartPhoneService smartphoneSevice;
	
	@Autowired
	private SmartPhoneMapper mapper;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private HttpSession session;
		
	@GetMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response,Model model
			, @RequestParam(name = "pageNumber", defaultValue = "0", required = false )int pageNumber) throws ServletException, IOException {
		request.setAttribute("view", "/WEB-INF/views/user/indexShop.jsp");
		model.addAttribute("dsProduct", smartphoneSevice.findPage(pageNumber));
		Page<SmartPhone> page=smartphoneSevice.findPage(pageNumber);
		model.addAttribute("pages", page);
		return "/user/layoutShop";
	}
	@GetMapping("detailSmartPhone/{id}")
	   public String formUpdate(@PathVariable(name = "id") Integer id, Model model,HttpServletRequest request, HttpServletResponse response) { 
		SmartPhone product=smartphoneSevice.getById(id);
		request.setAttribute("view", "/WEB-INF/views/user/detailProduct.jsp");
	   	model.addAttribute("product", product);
	   	return "/user/layoutShop";
	   }
	
	@GetMapping("addToCart/{productId}")
	public String addToCart(@PathVariable("productId") SmartPhone product, Model model,HttpServletRequest request) {
		if (product !=null) {
			if (product.getQuantity()<=0) {
				return "redirect:/user/shopSmartPhone/index";
			}
			CartItem item=new CartItem();
			BeanUtils.copyProperties(product, item);
			shoppingCartService.add(item);		
		}
		return "redirect:/user/shopSmartPhone/myCart";
	}
	@GetMapping("myCart")
	public String myCart(Model model,HttpServletRequest request) {
		Collection<CartItem> listcarts= shoppingCartService.getCartItems();
		request.setAttribute("view", "/WEB-INF/views/user/cart.jsp");
		model.addAttribute("carts",listcarts);
		BigDecimal total=shoppingCartService.total();
		DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
		model.addAttribute("total", df.format(total));
		return "/user/layoutShop";
	}
	@GetMapping("myCart/delete/{id}")
	public String myCartDelete(@PathVariable("id") Integer id) {
		shoppingCartService.remove(id);
		return "redirect:/user/shopSmartPhone/myCart";
	}
	@PostMapping("updateToCart")
	public String updateToCart(@RequestParam(name = "id") Integer id, @RequestParam(name = "quantity") Integer quantity, Model model) {
		SmartPhone product=smartphoneSevice.getById(id);
		if (product.getQuantity()<quantity) {
			session.setAttribute("error", "Số lượng sản phẩm không đủ");
			return "redirect:/user/shopSmartPhone/myCart";
		}
		shoppingCartService.update(id, quantity)	;
		return "redirect:/user/shopSmartPhone/myCart";
	}
	@GetMapping("order")
	public String order() throws ParseException {
		
		BigDecimal total=shoppingCartService.total();
		
		DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
		Order order= new Order();
		//acc fake
		Account acc=accountService.getById(1);
		
		//
		order.setAccount(acc);
		order.setAddress(acc.getAddress());
		order.setCreateDate(new Date());
		System.out.println(df.format(total)+"alo");
		order.setTotal(total);
		order.setStatus(0);
		orderService.add(order);
		
		Collection<CartItem> listcarts= shoppingCartService.getCartItems();
		for (CartItem cartItem : listcarts) {
			SmartPhone product=smartphoneSevice.getById(cartItem.getId());
			product.setQuantity(product.getQuantity()-cartItem.getQuantity());
			smartphoneSevice.update(product);
			
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setProduct(smartphoneSevice.getById(cartItem.getId()));
			orderDetail.setPrice(cartItem.getPrice());
			orderDetail.setQuantity(cartItem.getQuantity());
			orderDetailService.add(orderDetail);
		}
		shoppingCartService.clear();

		return "redirect:/user/shopSmartPhone/index";
	}
	@GetMapping("myOrder/{id}")
	public String getOrder(@PathVariable("id") Integer id, Model model,HttpServletRequest request) {
		List<Order> listOrders=orderService.getAll();
		model.addAttribute("order", listOrders);
		request.setAttribute("view", "/WEB-INF/views/user/order.jsp");
		return "/user/layoutShop";
	}
	
	@GetMapping("detailOrder/{id}")
	public String getDetailOrder(@PathVariable("id") Order order, Model model,HttpServletRequest request) {
		System.out.println(order.getId());
		List<OrderDetail> listOd= orderDetailService.getByOrder(order);
		request.setAttribute("view", "/WEB-INF/views/user/billDetail.jsp");
		model.addAttribute("orderDetails",listOd);
		return "/user/layoutShop";
	}
	
	@PostMapping("search")
	public String search(@RequestParam(name = "name") String name,HttpServletRequest request, Model model) {
		List<SmartPhone> products=smartphoneSevice.getByName(name);
		request.setAttribute("view", "/WEB-INF/views/user/indexShop.jsp");
		model.addAttribute("dsProduct", products);
		return "/user/layoutShop";
		
	}
	
	
}









