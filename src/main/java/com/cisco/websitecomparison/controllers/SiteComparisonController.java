package com.cisco.websitecomparison.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.websitecomparison.services.CompareWebsiteService;

@RestController
public class SiteComparisonController {
	
	@Autowired
	CompareWebsiteService compareWebsiteService;
	
	@RequestMapping(value = "compare", method = RequestMethod.GET)
    public @ResponseBody String compareSites(@RequestParam(value="url1", required=true) String firstUrl,
    	    @RequestParam(value="url2", required=true) String secondUrl) {
		
		String firstURLText = compareWebsiteService.getUrlContentText(firstUrl);
		String secondURLText = compareWebsiteService.getUrlContentText(secondUrl);
		
		firstURLText = compareWebsiteService.removeDuplicates(firstURLText);
		secondURLText = compareWebsiteService.removeDuplicates(secondURLText);
		
		String JaccardIndex = compareWebsiteService.calculateSimilarityScore(firstURLText, secondURLText);
        return "The JaccardIndex is " + JaccardIndex;
    }
}
	
