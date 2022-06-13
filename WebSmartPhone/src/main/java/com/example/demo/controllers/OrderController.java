package com.example.demo.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Order;
import com.example.demo.repositories.IOrderRepository;

@Controller
public class OrderController {
	 @Autowired
	 private IOrderRepository orderRepository;
	 
	 @Autowired
	 
	 
     @GetMapping("/orderByAc")
     @ResponseBody
     public void getOrder() {
    	 List<Order> orders=orderRepository.findAll();
    	 for (Order order : orders) {
			System.out.println(order.getAccount().getName());
		}
    	 
     }
}
