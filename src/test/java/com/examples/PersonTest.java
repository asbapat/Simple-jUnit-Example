package com.examples;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testPerson() {
		Person p1 = new Person();
		p1.setName("John Doe");
		assertEquals("John Doe", p1.getName());
	}
	
	@Test
	public void testNoOfBooks() {
		Person p2 = new Person();
		p2.setName("Jane Doe");
		p2.setNoOfBooks(5);
		assertEquals(5, p2.getNoOfBooks());
	}
	
	@Test
	public void testToString() {
		Person p3 = new Person();
		p3.setName("Java Guru");
		p3.setNoOfBooks(10);
		assertEquals("Java Guru has : (10 books)",p3.toString());
	}

}
