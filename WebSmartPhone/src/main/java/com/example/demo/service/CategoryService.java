package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Category;
import com.example.demo.repositories.ICategoryRepository;

@Service
public class CategoryService {
	@Autowired
	 private ICategoryRepository iCategoryRepository;
	
	public List<Category> getAll(){
		return iCategoryRepository.findAll();
	}
	
	public Category getById(Integer id) {
		return iCategoryRepository.getById(id);
	}
	
	public Category update(Category category) {
		Integer id = category.getId();
		if (id!=null) {
			Optional<Category> categoryOptional=iCategoryRepository.findById(id);
			if (categoryOptional.isPresent()) {
				return iCategoryRepository.save(category);
			}
		}
	return null;
	}
	
	public Category add(Category category) {
		category.setId(null);
		return iCategoryRepository.save(category);
	}
	
	public Category delete(Integer id) {
		Optional<Category> category=iCategoryRepository.findById(id);
		if (category.isPresent()) {
			iCategoryRepository.deleteById(id);
			return category.get();
	   }else {
		   return null;
	   }
    }
	
	public void deleteList(List<Integer> list) {
		    iCategoryRepository.deleteAllByIdInBatch(list);
	    }
}
