package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
   @GetMapping("/home")
   public String home(HttpServletRequest request, HttpServletResponse response) {
	   request.setAttribute("view", "home.jsp");
	   request.setAttribute("mess", "mess");
	   return "Layout";
   }
}
