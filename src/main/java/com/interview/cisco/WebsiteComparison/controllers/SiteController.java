package com.interview.cisco.WebsiteComparison.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteController {
	
	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }	
}
	
