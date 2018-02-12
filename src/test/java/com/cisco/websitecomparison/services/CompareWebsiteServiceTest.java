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
		String input = "THis is Is string has multiple duplicates. It has duplicates because strings "
				+ "are messy.";
		
		CompareWebsiteService cws = new CompareWebsiteService();
		String result = cws.removeDuplicates(input);
		System.out.println(result);

		assertEquals("this is string has multiple duplicates it because strings are messy", result);
	}
	
	@Test
	public void getTotalOverlappingWordsTest() {
		
		String text1 = "This is an apple";
		String text2 = "This is a book";
		
		CompareWebsiteService cws = new CompareWebsiteService();
		int result = cws.getTotalOverlappingWords(text1, text2);
		assertEquals(2, result);
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
	public void calculateSimilarityScoreTest() {
		
		CompareWebsiteService cws = new CompareWebsiteService();
		String text1 = "This is an apple";
		String text2 = "This is a book";
		String result = cws.calculateSimilarityScore(text1, text2);
		assertEquals("0.33",result);
	}
}
