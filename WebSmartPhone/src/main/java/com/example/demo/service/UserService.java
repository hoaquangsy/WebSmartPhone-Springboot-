package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repositories.IAccountRepository;
import com.example.demo.utils.CustomUserDetails;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IAccountRepository iUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("name: "+username);
		Account account=iUserRepository.findAccountByEmail(username);
		System.out.println(account.getEmail());
		System.out.println(account.getPassword());
		if (account==null) {
			throw new UsernameNotFoundException(username);
		}
		return  new CustomUserDetails(account);
	}

}
