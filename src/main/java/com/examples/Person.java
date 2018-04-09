package com.examples;

import java.util.*;

public class Person {
	private String name;
	private int NoOfBooks;
	private int maxBooks;
	private List<Book> booksIssued = new ArrayList<>();
	
	public Person() {
		this.maxBooks = 0;
		this.NoOfBooks = 0;
	}

	public int getMaxBooks() {
		return maxBooks;
	}

	public void setMaxBooks(int maxBooks) {
		this.maxBooks = maxBooks;
	}

	public int getNoOfBooks() {
		return NoOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		NoOfBooks = noOfBooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addBook(Book b) {
		booksIssued.add(b);
	}
	
	
	public void removeBook(Book b) {
		booksIssued.remove(b);
	}
	
	public List<Book> booksIssued(){
		return booksIssued;
	}
	
	@Override
	public String toString() {
		return getName()+" has : "+ "(" + getNoOfBooks() + " books)";
	}
}
