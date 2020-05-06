package com.kodluyoruz.myLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodluyoruz.myLibrary.dao.entity.Author;
import com.kodluyoruz.myLibrary.dao.repository.AuthorRepository;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public List<Author> getAuthorList() {
		return this.authorRepository.getAuthorList();
	}
	
	public Author getAuthorByNo(Long authorNo) {
		return this.authorRepository.getAuthorByNo(authorNo);
	}
	
}
