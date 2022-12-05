package com.Totara;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Tests {
	private static StringFunctions stringFunctions;
	
	//_____ INIT _____
	@BeforeAll
	public static void init() {
		stringFunctions = StringFunctions.getInstance();
	}
	
	//_____ EXPECTED TESTS _____
	@Test
	void testOneWordLessThanLineLength() {
		String expected = "Test";
		String input = "Test";
		int length = 12;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test 
	void testOneWordLongerThanLineLength() {
		String expected = "Tes\nt";
		String input = "Test";
		int length = 3;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	void testOneWordLongerThanDoubleLineLength() {
		String expected = "Tes\ntin\ng";
		String input = "Testing";
		int length = 3;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	void testMultipleWords() {
		String expected = "Test\nOwO\nUwU";
		String input = "Test OwO UwU";
		int length = 4;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	void testSentence() {
		String expected = "The quick\nbrown fox\njumps over\nthe lazy\ndog";
		String input = "The quick brown fox jumps over the lazy dog";
		int length = 10;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	void testParagraph() {
		String expected = "According to all\nknown laws of\naviation, "
				+ "there is\nno way that a bee\nshould be able to\nfly. "
				+ "Its wings are\ntoo small to get its\nfat little body off\nthe ground. "
				+ "The bee,\nof course, flies\nanyway. "
				+ "Because bees\ndon’t care what\nhumans think is\nimpossible";
		String input = "According to all known laws of aviation, "
				+ "there is no way that a bee should be able to fly. "
				+ "Its wings are too small to get its fat little body off the ground. "
				+ "The bee, of course, flies anyway. "
				+ "Because bees don’t care what humans think is impossible";
		int length = 20;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	void testSentenceIncludingWordsLongerThanLength() {
		String expected = "An a\npple\na\nday\nkeep\ns an\nyone\naway\nif\nyou\nthro\nw it\nhard\nenou\ngh!";
		String input = "An apple a day keeps anyone away if you throw it hard enough!";
		int length = 4;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	//____ BOUNDARY TESTS _____
	@Test()
	void testLengthOfOne() {
		String expected = "T\ne\ns\nt";
		String input = "Test";
		int length = 1;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test()
	void testStringOfOne() {
		String expected = "F";
		String input = "F";
		int length = 1;
		
		String actual = stringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	//_____ UNEXPECTED TESTS _____
	@Test()
	void testNegativeLength() {
		String input = "Test";
		int length = -10;
		
		assertThrows(IllegalArgumentException.class, 
				() -> {stringFunctions.wrap(input, length);}, 
				"Length must be greater than 0");
	}
	
	@Test()
	void testZeroLength() {
		String input = "Test";
		int length = 0;
		
		assertThrows(IllegalArgumentException.class, 
				() -> {stringFunctions.wrap(input, length);}, 
				"Length must be greater than 0");
	}
	
	@Test()
	void testEmptyString() {
		String input = "";
		int length = 1;
		
		assertThrows(IllegalArgumentException.class, 
				() -> {stringFunctions.wrap(input, length);}, 
				"The string cannot be empty");
	}
	
	@Test()
	void testEmptyStringWithSpaces() {
		String input = "    ";
		int length = 1;
		
		assertThrows(IllegalArgumentException.class, 
				() -> {stringFunctions.wrap(input, length);}, 
				"The string cannot be empty");
	}

}
