package com.kodluyoruz.myLibrary.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kodluyoruz.myLibrary.dao.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

	@Query(value="Select a From Author a")
	public List<Author> getAuthorList();
	
	@Query(value="from Author a where a.authorNo = :authorNo")
	public Author getAuthorByNo(@Param("authorNo") Long authorNo);
	
}
