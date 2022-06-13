package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductRqDTO;
import com.example.demo.entities.SmartPhone;

@Service
public class SmartPhoneMapper {
	@Autowired
    private  ModelMapper mapper;
	
	public SmartPhone convertToEntity(ProductRqDTO dto) {
		SmartPhone product= mapper.map(dto, SmartPhone.class);
		return product;
	}
	public ProductRqDTO convertToDto(SmartPhone product) {
		ProductRqDTO dto=mapper.map(product, ProductRqDTO.class);
		return dto;
	}
	
}
