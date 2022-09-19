package com.app.book.service;


import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.book.model.BookDetails;

@Service
@Transactional
public class BookServiceImpl  implements BookService{
	private Logger logger =LogManager.getLogger(BookServiceImpl.class);
	@Autowired
	private BookRepository repo;

	@Override
	public BookDetails addBook(BookDetails book) {
		logger.info("inside BookServiceImpl.addBook() ");
		// TODO Auto-generated method stub
		return repo.save(book);
		
		
	}
	
	@Override
	public List<BookDetails> getAllBookDetails() {
		logger.info("inside BookServiceImpl.getAllBookDetails() ");
		// TODO Auto-generated method stub
		return repo.findAll();
		
		
	}

	@Override
	public void deleteBookById(Integer id) {
		logger.info("inside BookServiceImpl.deleteBookById(Integer id) ");
		 repo.deleteById(id);

		// TODO Auto-generated method stub
		
	}

	@Override
	public BookDetails updateBook(BookDetails book) {
		// TODO Auto-generated method stub
		logger.info("inside BookServiceImpl.updateBook(Integer id,, BookDetails book) ");
		if(book!=null) {
		repo.save(book);
		}
		logger.info("book updated", book);
		return book;
		
		
		
	}

	@Override
	public BookDetails getBookById(Integer id) {
		logger.info("repo.findBookById(id)");
		BookDetails book= repo.findBookById(id);
		return book;
	}

}
