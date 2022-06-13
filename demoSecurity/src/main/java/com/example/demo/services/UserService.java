//package com.example.demo.services;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.Account;
//import com.example.demo.repositories.IUserRepository;
//import com.example.demo.utils.CustomUserDetails;
//
//
//@Service
//public class UserService implements UserDetailsService {
//    @Autowired
//    private IUserRepository iUserRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("name: "+username);
//		Account account=iUserRepository.findAccountByEmail(username);
//		System.out.println(account.getEmail());
//		System.out.println(account.getPassword());
//		if (account==null) {
//			throw new UsernameNotFoundException(username);
//		}
//		return  new CustomUserDetails(account);
//	}
//
//}
