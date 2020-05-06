package com.kodluyoruz.myLibrary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodluyoruz.myLibrary.dao.entity.Book;
import com.kodluyoruz.myLibrary.dao.repository.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getBookList() {
		return this.bookRepository.getBookList();
	}

	public List<Book> getBookListByTitle(String title) {
		return this.bookRepository.getBookByTitle(title);
	}
	
	public Book getBookByNo(Long bookNo) {
		return this.bookRepository.getBookByNo(bookNo);
	}
	
	public Long findMaxNo() {
		return this.bookRepository.findMaxNo();
	}
	
	public void save(Book book) {
		this.bookRepository.save(book);
	}
	
	public Book produceNewBook() {
		Book book = new Book();
		book.setBookNo(findMaxNo()+1L);
		return book;
	}
}
