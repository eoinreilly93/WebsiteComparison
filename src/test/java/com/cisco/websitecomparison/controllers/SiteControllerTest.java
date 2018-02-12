package com.cisco.websitecomparison.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SiteControllerTest {
	
	@Test
	public void removeDuplicatesTestSmall() {
		String input = "The the string String string. stringing.";
		
		SiteController sc = new SiteController();
		String result = sc.removeDuplicates(input);
		assertEquals("the string stringing", result);
	}
	
	@Test
	public void removeDuplicatesTestMedium() {
		String input = "THis is Is string has multiple duplicates. It has duplicates because strings "
				+ "are messy.";
		
		SiteController sc = new SiteController();
		String result = sc.removeDuplicates(input);
		System.out.println(result);

		assertEquals("this is string has multiple duplicates it because strings are messy", result);
	}
}
