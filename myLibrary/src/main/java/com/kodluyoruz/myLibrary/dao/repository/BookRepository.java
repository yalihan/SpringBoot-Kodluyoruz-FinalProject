package com.kodluyoruz.myLibrary.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kodluyoruz.myLibrary.dao.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	@Query(value="Select b From Book b")
	public List<Book> getBookList();
	
	@Query(value="from Book b where b.title like '%:title%'")
	public List<Book> getBookByTitle(@Param("title") String title);

	@Query(value="from Book b where b.bookNo = :bookNo")
	public Book getBookByNo(@Param("bookNo") Long bookNo);
	
	@Query(value="Select max(b.bookNo) from Book b")
	public Long findMaxNo();
	
}
