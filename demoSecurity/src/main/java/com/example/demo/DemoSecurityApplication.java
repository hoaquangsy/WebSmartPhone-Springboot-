package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entity.Account;
import com.example.demo.repositories.IUserRepository;

@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {
   @Autowired
   IUserRepository iUserRepository;
   
   @Autowired
   PasswordEncoder passwordEncoder ;
   
	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Account user= new Account();
		user.setAddress("Hn");
		user.setGender(1);
		user.setName("sy");
		user.setPhoneNumber("00000");
		user.setRole(0);
		user.setAvatar("null");
		user.setEmail("syhq24@gmail.com");
		try {
			user.setPassword(passwordEncoder.encode("22"));
			iUserRepository.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
