package com.app.book.service;

import java.util.List;


import com.app.book.model.BookDetails;

public interface BookService {
	
public BookDetails addBook(BookDetails book);
public List<BookDetails> getAllBookDetails();
public void deleteBookById(Integer id);
public BookDetails getBookById(Integer id);
public BookDetails updateBook(BookDetails book);

}
