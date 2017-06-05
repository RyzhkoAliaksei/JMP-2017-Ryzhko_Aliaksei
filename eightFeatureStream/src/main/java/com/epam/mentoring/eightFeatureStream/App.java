package com.epam.mentoring.eightFeatureStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.mentoring.model.Author;
import com.epam.mentoring.model.Book;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors = new ArrayList<Author>();
		List<Author> authors1 = new ArrayList<Author>();
		Author author1 = new Author("Lev", 18, books);
		Author author2 = new Author("Aliaksei", 23, books);
		Author author3 = new Author("Ivan", 16, books);
		Author author4 = new Author("Petr", 25, books);
		authors.add(author2);
		authors.add(author3);
		authors.add(author4);
		authors1.add(author1);
		Book book1 = new Book("Star Wars", 150, authors);
		Book book2 = new Book("Hobbit", 230, authors);
		Book book3 = new Book("The Da vinci code", 400, authors);
		Book book4 = new Book("War and Peace", 600, authors1);
		Book book = new Book("Harry Potter and the Deathly Hallows", 140, authors);
		books.add(book);
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		/// 2.3.1
		books.stream().filter(b -> b.getNumberOfPages() > 200).forEach(System.out::println);
		/// 2.3.2
		Comparator<Book> bookComparator = (b1, b2)->Integer.compare(b1.getNumberOfPages(),b2.getNumberOfPages());
		Book maxPage = books.stream().max(bookComparator).get();
		Book minPage = books.stream().min(bookComparator).get();
		System.out.println("Book with max page- " + maxPage + " Book with min page- " + minPage);
		/// 2.3.3
		System.out.println("Books with single author");
		books.stream().filter(b -> b.getAuthors().size() == 1).forEach(System.out::println);
		/// 2.3.5 and 2.3.6
		System.out.println("List titles");
		books.stream().map(b -> b.getTitle()).collect(Collectors.toList()).forEach(System.out::println);
		/// 2.3.7
		System.out.println("List authors");
		books.stream().map(Book::getAuthors).flatMap(list -> list.stream()).distinct().forEach(System.out::println);
		/// 2.3.4 and 2.4 peek and 2.5 parallel
		System.out.println("Sorted by title");
		books.stream().peek(System.out::println).parallel().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()))
				.forEach(System.out::println);
		System.out.println("Sorted by pages");
		books.stream().sorted((o1, o2) -> Integer.compare(o1.getNumberOfPages(), o2.getNumberOfPages()))
				.forEach(System.out::println);
		
	}
}
