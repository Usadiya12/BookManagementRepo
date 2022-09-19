package com.app.book.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.book.model.BookDetails;

public interface BookRepository  extends JpaRepository<BookDetails, Integer> , CrudRepository<BookDetails, Integer>{
	

	 @Query("select b from BookDetails b where b.id=:id")    
	 BookDetails findBookById(@Param("id") Integer id);

}
