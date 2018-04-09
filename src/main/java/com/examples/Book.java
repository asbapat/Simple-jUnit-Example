package com.examples;

public class Book {
	
	private String title;
	private String author;
	private Person issuedPerson;
	
	public Book() {
	}
	
	public Book(String name) {
		this.title = name;
		this.issuedPerson = null;
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
	
	@Override
	public String toString() {
		return getTitle()+" written by "+getAuthor();
	}

	public Person getPerson() {
		return issuedPerson;
	}
	public void setIssuedPerson(Person p) {
		this.issuedPerson = p;
	}
	public Person getIssuedPerson() {
		return issuedPerson;
	}
	
}
