package com.kodluyoruz.myLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodluyoruz.myLibrary.dao.entity.Category;
import com.kodluyoruz.myLibrary.dao.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> getCategoryList() {
		return this.categoryRepository.getCategoryList();
	}
	
	public Category getCategoryByNo(Long categoryNo) {
		return this.categoryRepository.getCategoryByNo(categoryNo);
	}

}
