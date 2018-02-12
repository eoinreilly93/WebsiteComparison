package com.cisco.websitecomparison.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompareWebsiteServiceTest {
	
	@Test
	public void getTotalOverlappingWordsTest() {
		
		String text1 = "This is an apple";
		String text2 = "This is a book";
		
		CompareWebsiteService cws = new CompareWebsiteService();
		int result = cws.getTotalOverlappingWords(text1, text2);
		assertEquals(2, result);
	}
}
