package com.example.demo.mapper;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CategoryRqDTO;
import com.example.demo.entities.Category;

@Service
public class CategoryMapper {
	@Autowired
    private  ModelMapper mapper;
	
   public  Category ConvertToEntity(CategoryRqDTO dto) {
	   Category category= mapper.map(dto, Category.class);
	   return category;
   }
   
public  CategoryRqDTO ConvertToDto(Category entity) {
	  CategoryRqDTO dto=mapper.map(entity, CategoryRqDTO.class);
	  return dto;
	   
   }
}
