package com.kodluyoruz.myLibrary.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kodluyoruz.myLibrary.dao.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	@Query(value="Select c From Category c")
	public List<Category> getCategoryList();
	
	@Query(value="from Category c where c.categoryNo = :categoryNo")
	public Category getCategoryByNo(@Param("categoryNo") Long categoryNo);
	
}
