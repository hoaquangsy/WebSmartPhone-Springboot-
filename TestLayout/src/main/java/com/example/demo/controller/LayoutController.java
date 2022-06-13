package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutController {
   @GetMapping("/home/indexUser")
   public String getLayout1() {
	   return "home/indexUser";
   }
   
   @GetMapping("/home/indexAdmin")
   public String getLayout() {
	   return "admin/indexAdmin";
   }
}
