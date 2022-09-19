package com.app.book.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.book.model.BookDetails;
import com.app.book.service.BookService;
import com.app.book.service.BookServiceImpl;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/book")
public class BookController {
	private Logger logger =LogManager.getLogger(BookServiceImpl.class);
	
	@Autowired
	private BookService service;
	
	@PostMapping("/addbook")
	public ResponseEntity<?> addBook(@RequestBody BookDetails book){
		logger.info("inside BookController.addBook() ");

		try {
			logger.info("book details "+book);

			return new ResponseEntity<BookDetails>(service.addBook(book), HttpStatus.CREATED);
		}
		catch(Exception e){
			logger.info("book cannot be added ");

			return new ResponseEntity<String>("Book addition faailed" +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getallbooks")
	public ResponseEntity<?> getAllBooks(){
		logger.info("inside BookController.getAllBooks() ");

		try {
			logger.info(" get all book details ");

			return new ResponseEntity<List<BookDetails>>(service.getAllBookDetails(), HttpStatus.CREATED);
		}
		catch(Exception e){
			logger.info("books cannot be found ");

			return new ResponseEntity<String>("Books cannot found" +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBook( @PathVariable Integer id,@RequestBody BookDetails book){
		logger.info("inside BookController.deleteBook() ");
		logger.info(" book got from front end "+ book);
		BookDetails newBook= new BookDetails();
		newBook.setId(book.getId());
		newBook.setTitle(book.getTitle());
		newBook.setAuthor(book.getAuthor());
		newBook.setPublisher(book.getPublisher());
		newBook.setPrice(book.getPrice());

		try {
			logger.info(" book updated successfully ");
			

			return new ResponseEntity<BookDetails>(service.updateBook(newBook),HttpStatus.CREATED);
		}
		catch(Exception e){
			logger.info("books cannot be updated ");

			return new ResponseEntity<String>("Books cannot be updated" +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value= "/getbookbyid/{id}")
	public ResponseEntity<?> getBookById( @PathVariable Integer id){
		logger.info("inside BookController.getBookById() ");

		try {
			logger.info(" book found.. ");
			 BookDetails book = service.getBookById(id);

			logger.info(book);
			return new ResponseEntity<BookDetails>(service.getBookById(id),HttpStatus.OK);
		}
		catch(Exception e){
			logger.info("books cannot be found ");

			return new ResponseEntity<String>("Books cannot be found" +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBookById(@PathVariable Integer id){
		logger.info("inside BookController.deleteBookById() ");

		try {
			logger.info(" book delete by id ");
			service.deleteBookById(id);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		catch(Exception e){
			logger.info("books cannot be deleted ");

			return new ResponseEntity<String>("Books cannot be deleted" +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
