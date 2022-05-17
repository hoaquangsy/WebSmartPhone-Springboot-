package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

@Query("select a  from Account a where a.name like %:name%")
public List<Account> findByName(@Param("name")String name);
}
