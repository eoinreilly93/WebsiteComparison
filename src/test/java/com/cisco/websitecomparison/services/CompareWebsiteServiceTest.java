package com.cisco.websitecomparison.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cisco.websitecomparison.controllers.SiteController;

public class CompareWebsiteServiceTest {
	
	@Test
	public void removeDuplicatesTestSmall() {
		String input = "The the string String string. stringing.";
		
		CompareWebsiteService cws = new CompareWebsiteService();
		String result = cws.removeDuplicates(input);
		assertEquals("the string stringing", result);
	}
	
	@Test
	public void removeDuplicatesTestMedium() {
		String input = "THis is Is string has multiple duplicates ()[]It has duplicates because! strings? "
				+ "are messy.";
		
		CompareWebsiteService cws = new CompareWebsiteService();
		String result = cws.removeDuplicates(input);

		assertEquals("this is string has multiple duplicates it because strings are messy", result);
	}
	
	@Test
	public void getTotalOverlappingWordsTestSmall() {
		
		String text1 = "This is an apple";
		String text2 = "This is a book";
		
		CompareWebsiteService cws = new CompareWebsiteService();
		int result = cws.getTotalOverlappingWords(text1, text2);
		assertEquals(2, result);
	}
	
	@Test
	public void getTotalOverlappingWordsTestMedium() {
		
		String text1 = "This string is not a palidrome";
		String text2 = "a string contains multiple words, some that could be a palidrome";
		
		CompareWebsiteService cws = new CompareWebsiteService();
		int result = cws.getTotalOverlappingWords(text1, text2);
		assertEquals(3, result);
	}
	
	@Test
	public void getTotalNumberUniqueWordsTest() {
		
		String text1 = "This is an apple";
		String text2 = "This is a book";
		
		CompareWebsiteService cws = new CompareWebsiteService();
		int result = cws.getTotalNumberUniqueWords(text1, text2);
		assertEquals(6, result);
	}
	
	@Test
	public void calculateSimilarityScoreTestSmall() {
		
		CompareWebsiteService cws = new CompareWebsiteService();
		String text1 = "This is an apple";
		String text2 = "This is a book";
		String result = cws.calculateSimilarityScore(text1, text2);
		assertEquals("0.33",result);
	}
	
	@Test
	public void calculateSimilarityScoreTestMedium() {
		
		CompareWebsiteService cws = new CompareWebsiteService();
		String text1 = "There are four people on a bench, whose names are Eoin, Shane, Sarah and Claire.";
		String text2 = "There are five people on a bench whose names are Eoin, Tom, Bill and Sarah";
		String result = cws.calculateSimilarityScore(text1, text2);
		assertEquals("0.65",result);
	}
}
