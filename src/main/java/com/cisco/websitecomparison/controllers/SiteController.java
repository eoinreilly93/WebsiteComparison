package com.cisco.websitecomparison.controllers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.websitecomparison.services.CompareWebsiteService;

@RestController
public class SiteController {
	
	@Autowired
	CompareWebsiteService compareWebsiteService;
	
	@RequestMapping("compare")
    public String compareSites(@RequestParam(value="url1", required=true) String firstUrl,
    	    @RequestParam(value="url2", required=true) String secondUrl) {
		
		String firstURLText = compareWebsiteService.getUrlContentText(firstUrl);
		String secondURLText = compareWebsiteService.getUrlContentText(secondUrl);
		
		firstURLText = removeDuplicates(firstURLText);
		secondURLText = removeDuplicates(secondURLText);
		
        return "There are " + firstURLText.length() + " total unique words in the first url "
        		+ "\n There are " + secondURLText.length() + " total unique words in the second url";
    }	

	public String removeDuplicates(String text) {
				 
		text = text.toLowerCase().replaceAll("[.,]", "");
		
		String[] words = text.split(" ");
		Set<String> uniqueWords = new LinkedHashSet<String>();
		for (String word : words) {
		    uniqueWords.add(word);
		}

		StringBuilder sb = new StringBuilder();
		for (String character : uniqueWords) {
		    sb.append(character + " ");
		}
 
        return sb.toString().trim();
	}
}
	
