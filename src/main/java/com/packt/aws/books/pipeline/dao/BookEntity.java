package com.packt.aws.books.pipeline.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "book")
public class BookEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String title;
	private String author;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
