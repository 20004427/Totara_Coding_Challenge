package com.Totara;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class Tests {
	private static StringFunctions stringFunctions;
	
	//_____ INIT _____
	@BeforeAll
	public void init() {
		stringFunctions = StringFunctions.getInstance();
	}
	
	//_____ EXPECTED TESTS _____
	@Test
	public void testOneWordLessThanLineLength() {
		String expected = "Test";
		String input = "Test";
		int length = 12;
		
		String actual = StringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testOneWordLongerThanLineLength() {
		String expected = "Tes\nt";
		String input = "Test";
		int length = 3;
		
		String actual = StringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testOneWordLongerThanDoubleLineLength() {
		String expected = "Tes\ntin\ng";
		String input = "Testing";
		int length = 3;
		
		String actual = StringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultipleWords() {
		String expected = "Test\nOwO\nUwU";
		String input = "Test OwO UwU";
		int length = 4;
		
		String actual = StringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	//_____ UNEXPECTED TESTS _____
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeLength() {
		String input = "Test";
		int length = -10;
		
		StringFunctions.wrap(input, length);
		assert(false);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testZeroLength() {
		String input = "Test";
		int length = 0;
		
		StringFunctions.wrap(input, length);
		assert(false);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyString() {
		String input = "";
		int length = 1;
		
		StringFunctions.wrap(input, length);
		assert(false);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyStringWithSpaces() {
		String input = "    ";
		int length = 1;
		
		StringFunctions.wrap(input, length);
		assert(false);
	}

}
