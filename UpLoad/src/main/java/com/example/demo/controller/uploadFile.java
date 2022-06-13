package com.example.demo.controller;

import java.io.File;
import java.nio.file.Path;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class uploadFile {

	@Autowired
	ServletContext app;
	
	@GetMapping("/index")
		public String form() {
			return "index";
		}
	
    @PostMapping("/upload")
    public String send(@RequestParam("myFile") MultipartFile partFile, Model model) {
    	    if (!partFile.isEmpty()) {
    		String part=app.getRealPath("/");
    		System.out.println("part: "+part);
    		try {	
    		String filePart=part +"/image/" + partFile.getOriginalFilename();
    		partFile.transferTo(Path.of(filePart));		
    		model.addAttribute("img",partFile.getOriginalFilename());
		    } catch (Exception e) {
			e.printStackTrace();
		    }
    	    }
    	return "index";
    }
}
	

