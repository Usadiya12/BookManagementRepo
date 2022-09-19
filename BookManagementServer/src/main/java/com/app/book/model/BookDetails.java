package com.app.book.model;

import javax.persistence.*;

@Entity
@Table(name="book_details")
public class BookDetails {

	private Integer id;
	private String title;
	private String author;
	private String publisher;
	private Long price;
	
	
	public BookDetails() {
	
	}

	public BookDetails(Integer id, String title, String author, String publisher, Long price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="book_title", length=100, nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="book_author", length=100, nullable = false)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name="book_publisher", length=100, nullable = false)
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Column(name="book_price", nullable = false)
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}

	
}
