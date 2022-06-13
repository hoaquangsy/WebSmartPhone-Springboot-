package com.example.demo.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.DTO.ProductRqDTO;
import com.example.demo.entities.SmartPhone;
import com.example.demo.mapper.SmartPhoneMapper;
import com.example.demo.service.CategoryService;
import com.example.demo.service.SmartPhoneService;

@MultipartConfig
@Controller
@RequestMapping(path = "Smartphone/product")
public class SmartPhoneController {
	@Autowired
	private SmartPhoneService productService;

	@Autowired
	private SmartPhoneMapper mapper;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ServletContext app;

	// index
	@GetMapping("index")
	public String index(Model model,HttpServletRequest request
			, @RequestParam(name = "pageNumber", defaultValue = "0", required = false )int pageNumber) {
		model.addAttribute("products", productService.getAll());
		model.addAttribute("Product", new ProductRqDTO());
		return "admin/product/index";
	}
	@GetMapping("/admin/home")
	public String home() {
		return "admin/layoutAdmin";
	}
	

	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		Integer idInteger = Integer.parseInt(id);
		productService.delete(idInteger);
		return "redirect:/Smartphone/product/index";
	}

   @GetMapping("edit/{id}")
   public String formUpdate(@PathVariable(name = "id") Integer id, Model model) { 
	   SmartPhone product=productService.getById(id);
	   System.out.println(id+" ||"+product.toString());
	 model.addAttribute("categories",categoryService.getAll());
   	model.addAttribute("Product", product);
   	return "admin/product/update";
   }


	@PostMapping("update/{id}")
	public String update(Model model, ProductRqDTO dto, @RequestParam("image") MultipartFile partFile)
			throws ParseException, java.text.ParseException {
		String filePart = "";
		if (!partFile.isEmpty()) {
			String part = app.getRealPath("/");
			try {
				filePart = part + "/image/" + partFile.getOriginalFilename();
				partFile.transferTo(Path.of(filePart));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		SmartPhone product = mapper.convertToEntity(dto);
		product.setImage(partFile.getOriginalFilename());
		System.out.println("1");
		productService.update(product);
		System.out.println("2");
		return "redirect:/Smartphone/product/index";
	}

	@GetMapping("create")
	public String formAdd(Model model, SmartPhone product) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("Product", product);
		return "admin/product/create";
	}

	// create product
	@PostMapping("store")
	public String add(ProductRqDTO dto, @RequestParam("image") MultipartFile partFile, Model model)
			throws java.text.ParseException, IllegalStateException, IOException {
		String filePart = "";
		if (!partFile.isEmpty()) {
			String part = app.getRealPath("/");
			try {
				filePart = part + "/image/" + partFile.getOriginalFilename();
				partFile.transferTo(Path.of(filePart));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		SmartPhone product = mapper.convertToEntity(dto);
		product.setImage(partFile.getOriginalFilename());
		productService.add(product);
		return "redirect:/Smartphone" + "/product/index";
	}

	// delete list
	@PostMapping("/deletes")
	public String deletes(@RequestParam(value = "select", required = false) List<Integer> list) {
		productService.deleteList(list);
		return "redirect:/Smartphone/product/index";
	}
	@PostMapping("search")
	public String search(@RequestParam(name = "name") String name, Model model) {
		List<SmartPhone> products=productService.getByName(name);
		System.out.println(name);
		model.addAttribute("Product", new ProductRqDTO());
		model.addAttribute("products", products);
		return "admin/product/index";
		
	}
	
	
	
	
	
	

}
