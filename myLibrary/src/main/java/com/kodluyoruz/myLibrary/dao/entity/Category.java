package com.kodluyoruz.myLibrary.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categories")
public class Category {

	@Id
	@Column(name="category_no")
	private Long categoryNo;
	@Column(name="category_name")
	private String categoryName;
	
	@JsonIgnore
	@ManyToMany(mappedBy="categories",fetch = FetchType.LAZY)
	private List<Book> books;
	
	public Category() {
		
	}
	public Category(Long categoryNo, String categoryName, List<Book> books) {
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.books = books;
	}
	
	public Long getCategoryNo() {
		return categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public List<Book> getBooks() {
		return books;
	}
	
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
