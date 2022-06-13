package com.example.demo.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderDetail;
import com.example.demo.repositories.IOrderDetailRepository;

@Service
public class OrderDetailService {
  @Autowired
  private IOrderDetailRepository iOrderDetailRepository;
  
  public List<OrderDetail> getAll() {
		return iOrderDetailRepository.findAll();
	}
  public List<OrderDetail> getByOrder(Order order) {
		return iOrderDetailRepository.findOrderDetailByOrder(order);
	}

	public OrderDetail getById(Integer id) {
		return iOrderDetailRepository.getById(id);
	}

	public Optional<OrderDetail> findById(Integer id) {
		return iOrderDetailRepository.findById(id);
	}

	public OrderDetail update(OrderDetail OrderDetail) {
		Integer id = OrderDetail.getId();
		if (id != null) {
			Optional<OrderDetail> OrderDetailOp = iOrderDetailRepository.findById(id);
			if (OrderDetailOp.isPresent()) {
				iOrderDetailRepository.save(OrderDetail);
				return iOrderDetailRepository.save(OrderDetail);
			}
		}
		return null;
	}

	public OrderDetail add(OrderDetail OrderDetail) throws ParseException {
		OrderDetail.setId(null);
		return iOrderDetailRepository.save(OrderDetail);
	}

	public OrderDetail delete(Integer id) {
		Optional<OrderDetail> OrderDetail = iOrderDetailRepository.findById(id);
		if (OrderDetail.isPresent()) {
			iOrderDetailRepository.deleteById(id);
			return OrderDetail.get();
		} else {
			return null;
		}
}
}