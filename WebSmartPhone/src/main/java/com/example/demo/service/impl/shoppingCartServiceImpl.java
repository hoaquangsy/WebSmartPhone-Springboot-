package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.DTO.ProductRqDTO;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.SmartPhone;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.ShoppingCartService;

@Service
@SessionScope
public class shoppingCartServiceImpl implements ShoppingCartService{
	Map<Integer, CartItem> map=new HashMap<Integer, CartItem>();
	
	@Autowired
	SmartPhoneService productService; 
	
	@Override
	public void add(CartItem item) {
		CartItem existedItem= map.get(item.getId());
		SmartPhone product=productService.getById(item.getId());
		if (existedItem !=null) {
			if (existedItem.getQuantity()>=product.getQuantity()) {
				existedItem.setQuantity(product.getQuantity());
			}else {
				existedItem.setQuantity(1+ existedItem.getQuantity());
			}
			
		}else {
			item.setQuantity(1);
			map.put(item.getId(), item);
		}
	}
	@Override
	public void remove(int productId) {
		map.remove(productId);
	}
	
	@Override
	public Collection<CartItem> getCartItems(){
		for (Map.Entry<Integer, CartItem> entry : map.entrySet()) {
			CartItem cart= entry.getValue();
			SmartPhone smartPhone=productService.findById(cart.getId()).get();
			cart.setPrice(smartPhone.getPrice());
			BigDecimal quatity= new BigDecimal(cart.getQuantity());
			cart.setTotal(cart.getPrice().multiply(quatity));
		}
		return map.values();		
	}
	@Override
	public void clear() {
		map.clear();
	}
	@Override
	public void update(int productId, int quantity) {
		CartItem item=map.get(productId);
		item.setQuantity(quantity);
		
		if (item.getQuantity()<=0) {
			map.remove(productId);
		}
	}
	@Override
	public BigDecimal total() {
		BigDecimal total=new BigDecimal(0);;
		for (Map.Entry<Integer, CartItem> entry : map.entrySet()) {
			CartItem cart= entry.getValue();
			BigDecimal price=cart.getPrice();
			BigDecimal quantity=new BigDecimal(cart.getQuantity());
			BigDecimal sum=price.multiply(quantity);
			total=total.add(sum);
		}
		return total;
	
	}

}
