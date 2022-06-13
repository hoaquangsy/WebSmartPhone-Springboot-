package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Account;

public interface IUserRepository extends JpaRepository<Account, Integer>  {
	@Query("select a from Account a where a.email like %:email%")
public Account findAccountByEmail(@Param("email")String email);
}
