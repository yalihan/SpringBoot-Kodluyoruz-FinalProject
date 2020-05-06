package com.kodluyoruz.myLibrary.dao.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="book_no")
	private Long bookNo;
	@Column(name="title")
	private String title;
	@Column(name="pub_year")
	private Date pubYear;
	@Column(name="description")
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable( name="bookauthors" , joinColumns = {@JoinColumn(name="bookNo")} , inverseJoinColumns = {@JoinColumn(name="authorNo")})
	private List<Author> authors;

	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable( name="bookcategories" , joinColumns = {@JoinColumn(name="bookNo")} , inverseJoinColumns = {@JoinColumn(name="categoryNo")})
	private List<Category> categories;
	
	public Book() {}
	public Book(Long bookNo, String title, Date pubYear, String description, List<Author> authors, List<Category> categories) {
		this.bookNo = bookNo;
		this.title = title;
		this.pubYear = pubYear;
		this.description = description;
		this.authors = authors;
		this.categories = categories;
	}
	
	public Long getBookNo() {
		return bookNo;
	}
	public String getTitle() {
		return title;
	}
	public Date getPubYear() {
		return pubYear;
	}
	public String getDescription() {
		return description;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPubYear(Date pubYear) {
		this.pubYear = pubYear;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public boolean hasAuthor(Author author) {
		for (Author bookAuthors: getAuthors()) {
			if (bookAuthors.getAuthorNo() == author.getAuthorNo()) {
				return true;
			}
		}
		return false;
	}
	public boolean hasCategory(Category category) {
		for (Category bookCategory : getCategories()) {
			if (bookCategory.getCategoryNo() == category.getCategoryNo()) {
				return true;
			}
		}
		return false;
	}
}
