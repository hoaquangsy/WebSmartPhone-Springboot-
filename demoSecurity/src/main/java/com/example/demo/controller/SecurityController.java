package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {
  @GetMapping("/home")
//  @ResponseBody
  public String home() {
	  return "home";
  }
  
  @GetMapping("/hello")
//@ResponseBody
public String hello() {
	  return "hello";
}

  }

