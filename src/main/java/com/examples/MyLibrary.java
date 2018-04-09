package com.examples;

import java.util.*;

import org.apache.log4j.Logger;


public class MyLibrary {
	
	String name;
	List<Book> books;
	List<Book> unavailableBooks = new ArrayList<>();
	List<Person> persons;
	private static final Logger logger = Logger.getLogger(MyLibrary.class);
	
	public MyLibrary(String name) {
		this.name = name;
		books = new ArrayList<>();
		persons = new ArrayList<>();
	}
	
	public String getLibName() {
		return name;
	}

	public void setLibName(String libName) {
		this.name = libName;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	public void removeBook(Book b) {
		books.remove(b);
	}
	
	public void addPerson(Person p) {
		persons.add(p);
	}
	
	public List<Book> getBooks(){
		return books;
	}
	
	public boolean checkOut(Book b, Person p) {
		if(books.size()==0 || !books.contains(b) || p.getNoOfBooks() >= 1)
			return false;
		books.remove(b);
		unavailableBooks.add(b);
		b.setIssuedPerson(p);
		p.setNoOfBooks(p.getNoOfBooks()+1);
		p.addBook(b);
		logger.info("Book '" + b.getTitle() + "' issued by " + p.getName());
		return true;
	}
	
	public boolean checkIn(Book b1) {
		if(books.contains(b1) || b1.getIssuedPerson()==null)
			return false;
		books.add(b1);
		unavailableBooks.remove(b1);
		Person p = b1.getIssuedPerson();
		b1.setIssuedPerson(null);
		p.setNoOfBooks(p.getMaxBooks()-1);
		p.removeBook(b1);
		logger.info("Book '" + b1.getTitle() + "' returned by " + p.getName());
		return true;
	}
	
	public ArrayList<Book> getBooksForPerson(Person p1) {
		if(p1.booksIssued().size()==0)
			return new ArrayList<>();
		
		return (ArrayList<Book>) p1.booksIssued();
	}
	public ArrayList<Book> getAvailableBooks() {
		if(books.size() == 0)
			return new ArrayList<>();
		return (ArrayList<Book>) books;
	}

	public ArrayList<Book> getUnAvailableBooks() {
		if(unavailableBooks.size() == 0)
			return new ArrayList<>();
		
		return (ArrayList<Book>) unavailableBooks;
	}
	
	@Override
	public String toString() {
		return ("Test : " + books.size() + " Books; " + persons.size() + " Persons.");
	}
public static void main(String[] args) {
		
		
		MyLibrary m1 = new MyLibrary("Demo Library");
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		
		p1.setName("John");
		p2.setName("Michael");
		p3.setName("Christine");
		p4.setName("Ben");
		
		Book b1 = new Book("Java Revisited");
		Book b2 = new Book("Intro to Python");
		Book b3 = new Book("Sample Book");
		Book b4 = new Book("CTCI");
		
		b1.setAuthor("abc");
		b2.setAuthor("lmn");
		b3.setAuthor("xyz");
		b4.setAuthor("pqrs");
		
		m1.addPerson(p1);
		m1.addPerson(p2);
		m1.addPerson(p3);
		m1.addPerson(p4);
		m1.addBook(b1);
		m1.addBook(b2);
		m1.addBook(b3);
		m1.addBook(b4);
		
		logger.info("Initial State of " + m1.name + " ==> " + m1.books.size() + " Available Books " 
							+ m1.persons.size() + " Members.");
		
		m1.checkOut(b1, p1);
		m1.checkOut(b2,p2);
		m1.checkIn(b1);
		m1.checkOut(b3,p3);
		m1.checkOut(b4,p4);
		m1.checkIn(b3);
		
		logger.info("Final State of " + m1.name + " ==> " + m1.books.size() + " Available Books " 
				+ m1.persons.size() + " Members.");
		
	}

}
