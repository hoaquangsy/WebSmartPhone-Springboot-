package com.example.demo.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.OrderDetail;
import com.example.demo.service.OrderDetailService;

@Controller
@RequestMapping(path = "/user/shopSmartPhone/orderDetail")
public class OrderDetailController {
 
	@Autowired
	OrderDetailService orderDetailService;
	
	@PostMapping("/add")
	public String addToCart(HttpServletRequest request, HttpServletResponse response,Model model,OrderDetail orderDetail) throws ParseException {
		orderDetailService.add(orderDetail);
		request.setAttribute("view", "/WEB-INF/views/user/orderDetail.jsp");
		return "/user/layoutShop";
	}
	
	@GetMapping("/myCart")
	public String myCart(HttpServletRequest request, HttpServletResponse response,Model model) throws ParseException {
		request.setAttribute("view", "/WEB-INF/views/user/orderDetail.jsp");
		model.addAttribute("carts", orderDetailService.getAll());
		return "/user/layoutShop";
	}
}
