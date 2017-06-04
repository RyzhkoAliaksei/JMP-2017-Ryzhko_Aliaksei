package com.epam.mentoring.model;

import java.util.List;

public class Author {
	private String name;
	private int age;
	private List<Book> books;
	
	public Author(String name, int age, List<Book> books) {
		super();
		this.name = name;
		this.age = age;
		this.books = books;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String toString() {
		return name + " : age" + age ;
	}
}
