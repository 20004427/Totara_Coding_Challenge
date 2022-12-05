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
	
	@Test
	public void testSentence() {
		String expected = "The quick\nbrown fox\njumps over\nthe lazy\ndog";
		String input = "The quick brown fox jumps over the lazy dog";
		int length = 10;
		
		String actual = StringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testParagraph() {
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
		
		String actual = StringFunctions.wrap(input, length);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSentenceIncludingWordsLongerThanLength() {
		String expected = "An a\npple\na\nday\nkeep\ns an\nyone\naway\nif\nyou\nthro\nw it\nhard\nenou\ngh!";
		String input = "An apple a day keeps anyone away if you throw it hard enough!";
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
