package com.example.demo.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DTO.CategoryRqDTO;
import com.example.demo.entities.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.service.CategoryService;

@Controller
@RequestMapping(path = "Smartphone/category")
public class CategoryController {
	
   @Autowired
   CategoryService categoryService;
   
   @Autowired
   private CategoryMapper mapper;
   
   @GetMapping("index")
   public String index(Model model) {
	   model.addAttribute("categories",categoryService.getAll());
	   return "admin/category/index";
   }
   
   @GetMapping("delete/{id}")
   public String delete(@PathVariable String id) {
	   Integer idInteger=Integer.parseInt(id);
	   categoryService.delete(idInteger);
	   return "redirect:/Smartphone/category/index";
	   
   }
   @GetMapping("edit/{id}")
   public String formUpdate(@PathVariable(name = "id") Category category, Model model) { 
	   CategoryRqDTO categoryRqDTO=mapper.ConvertToDto(category);   	
	   model.addAttribute("category",categoryRqDTO);
	   return "admin/category/update";
   }
   @GetMapping("create")
   public String formCreate(Model model, Category category) {
	   model.addAttribute("Category",category);
	   return "admin/category/create";
   }
   
   @PostMapping("update/{id}")
   public String update(Model model, CategoryRqDTO dto) { 
	   Category category=mapper.ConvertToEntity(dto);
	   categoryService.update(category);
	   return "redirect:/Smartphone/category/index";
   }
   
   @PostMapping("store")
   public String addCategory(CategoryRqDTO dto) {
	   Category category=mapper.ConvertToEntity(dto);
	   categoryService.add(category);
	   return "redirect:/Smartphone/category/index";
   }
   
   @PostMapping("/deletes")
   public String deletes(@RequestParam(value = "select", required = false) List<Integer> list) {
	   categoryService.deleteList(list);
	   return "redirect:/Smartphone/category/index";
   }
   
   
}
