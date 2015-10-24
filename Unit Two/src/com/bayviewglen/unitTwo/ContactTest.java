package com.bayviewglen.unitTwo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContactTest {

	private static Contact x = null;
	
	@Before
	public void initialize() {
		x = new Contact("yan", "daniel", "123");
	}
	
	@Test
	public void testGetLname() {
		assertEquals("This should return last name", "yan", x.getLname());
	}
	
	@Test
	public void testGetFname() {
		assertEquals("This should return first name", "daniel", x.getFname());
	}
	
	@Test
	public void testGetPhone() {
		assertEquals("This should return phone #", "123", x.getPhone());
	}

}
