package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Account;
import com.example.demo.repositories.IAccountRepository;
import com.example.demo.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	
	

}
