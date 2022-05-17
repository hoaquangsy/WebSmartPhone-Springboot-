package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Account;
import com.example.demo.repository.IAccountRepository;

@Controller
public class AccountController {
	@Autowired
	IAccountRepository iAccountRepository;
	
	@GetMapping("/name")
	@ResponseBody
	public void name() {
		List<Account> accs=iAccountRepository.findByName("sy");
		for (Account account : accs) {
			System.out.println(account.getName());
		}
	}

}
