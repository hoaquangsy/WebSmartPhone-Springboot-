package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.SmartPhone;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Integer> {
	@Query("select sp from SmartPhone sp where sp.name like %:name%")
	public List<SmartPhone> findSmartPhoneByNameLike(@Param("name")String name);
	@Query("select sp from SmartPhone sp")
	Page<SmartPhone> findAll(Pageable pageable);

}
