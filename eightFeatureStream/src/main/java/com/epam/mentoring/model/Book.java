package com.epam.mentoring.model;

import java.util.List;

public class Book {

	private String title;
	private int numberOfPages;
	private List<Author> authors;

	public Book(String title, int numberOfPages, List<Author> authors) {
		super();
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String toString() {
		return title + " : pages - " + numberOfPages + " authors " + authors;
	}

}
