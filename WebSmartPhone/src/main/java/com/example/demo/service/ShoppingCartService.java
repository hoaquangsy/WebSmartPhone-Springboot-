package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.example.demo.entities.CartItem;

public interface ShoppingCartService {

	BigDecimal total();

	void update(int productId, int quantity);

	void clear();

	Collection<CartItem> getCartItems();

	void remove(int productId);

	void add(CartItem item);

}
