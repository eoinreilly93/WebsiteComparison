package com.cisco.websitecomparison.controllers;

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
    public String getURLDetails(@RequestParam(value="url1", required=true) String param1,
    	    @RequestParam(value="url2", required=true) String param2) {
		
		String result = compareWebsiteService.getUrlBody(param1);
        return result;
    }	
}
	
