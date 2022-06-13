package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entities.SmartPhone;
import com.example.demo.repositories.ISmartPhoneRepository;

@Service
public class SmartPhoneService {
	@Autowired
	ISmartPhoneRepository iProductRepository;

	public List<SmartPhone> getAll() {
		return iProductRepository.findAll();
	}
	public Page<SmartPhone> findPage(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, 2);
		return iProductRepository.findAll(pageable);
	}
	
	public List<SmartPhone> getByName(String name) {
		return iProductRepository.findSmartPhoneByNameLike(name);
	}

	public SmartPhone getById(Integer id) {
		return iProductRepository.getById(id);
	}

	public Optional<SmartPhone> findById(Integer id) {
		return iProductRepository.findById(id);
	}

	public SmartPhone update(SmartPhone product) {
		Integer id = product.getId();
		if (id != null) {
			Optional<SmartPhone> productOp = iProductRepository.findById(id);
			if (productOp.isPresent()) {
				iProductRepository.save(product);
				return iProductRepository.save(product);
			}
		}
		return null;
	}

	public SmartPhone add(SmartPhone product) throws ParseException {
		product.setId(null);
		return iProductRepository.save(product);
	}

	public SmartPhone delete(Integer id) {
		Optional<SmartPhone> product = iProductRepository.findById(id);
		if (product.isPresent()) {
			iProductRepository.deleteById(id);
			return product.get();
		} else {
			return null;
		}
	}

	public void deleteList(List<Integer> list) {
//		List<Category> listCategories=iCategoryRepository.findAllById(list);
		iProductRepository.deleteAllByIdInBatch(list);
	}

}
