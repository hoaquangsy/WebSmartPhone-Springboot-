package com.example.demo.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderDetail;
import com.example.demo.repositories.IOrderRepository;

@Service
public class OrderService {
 @Autowired
 private IOrderRepository iOrderRepository;
 
 public List<Order> getAll() {
		return iOrderRepository.findAll();
	}

	public Order getById(Integer id) {
		return iOrderRepository.getById(id);
	}

	public Optional<Order> findById(Integer id) {
		return iOrderRepository.findById(id);
	}

	public Order update(Order Order) {
		Integer id = Order.getId();
		if (id != null) {
			Optional<Order> OrderOp = iOrderRepository.findById(id);
			if (OrderOp.isPresent()) {
				iOrderRepository.save(Order);
				return iOrderRepository.save(Order);
			}
		}
		return null;
	}

	public Order add(Order Order) throws ParseException {
		Order.setId(null);
		return iOrderRepository.save(Order);
	}

	public Order delete(Integer id) {
		Optional<Order> Order = iOrderRepository.findById(id);
		if (Order.isPresent()) {
			iOrderRepository.deleteById(id);
			return Order.get();
		} else {
			return null;
		}
}
}
