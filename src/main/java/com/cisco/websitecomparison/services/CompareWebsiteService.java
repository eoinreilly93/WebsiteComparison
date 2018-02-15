package com.cisco.websitecomparison.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class CompareWebsiteService {
	
	/**
	 * Takes in a url, retrieves the content body and returns the page text
	 * excluding html/css/js tags using Jsoup
	 * 
	 * @param url	- Site to retrieve data from
	 * @return		- Text present on the webpage only
	 */
	public String getUrlContentText(String url) {
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse response = null;
		String result = "";

		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			StringBuilder sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
			  sb.append(line);
			}
			
			Document doc = Jsoup.parse(sb.toString());
			result = doc.body().text();
			
		} 
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;				
	}
	
	
	/**
	 * Finds the biggest number of recurring or overlapping words between two strings
	 * 
	 * @param firstURL			- Input text
	 * @param secondURL			- Input text
	 * @return Integer 			- Biggest overlap 
	 */
	public Integer getTotalOverlappingWords(String firstURL, String secondURL) {
		
		String firstURLCleaned = removeDuplicates(firstURL);
		String secondURLCleaned = removeDuplicates(secondURL);
		
		int firstCount = 0;
		String[] firstURLWords = firstURLCleaned.split("\\s+");
		String[] secondURLWords = secondURLCleaned.split("\\s+");
		
		for(String word : firstURLWords) {
			if(Arrays.asList(secondURLWords).contains(word)) {
				firstCount++;
			}
		}
		
		int secondCount = 0;
		for(String word : secondURLWords) {
			if(Arrays.asList(firstURLWords).contains(word)) {
				secondCount++;
			}
		}
		return firstCount > secondCount ? firstCount : secondCount;
	}
	
	/**
	 * Finds the number of unique words between two strings
	 * 
	 * @param firstURLText			- Input text
	 * @param secondURLText			- Input text
	 * @return	Integer 			- Number of unique words
	 */
	public Integer getTotalNumberUniqueWords(String firstURLText, String secondURLText) {
		
		String combinedWords = firstURLText + " " + secondURLText;
		String uniqueWords = removeDuplicates(combinedWords);
		
		String[] words = uniqueWords.split(" ");
		
		return words.length;		
	}
	
	/**
	 * Removes duplicate words from a string input
	 * 
	 * @param text		- Full text
	 * @return			- Text with duplicate words removed
	 */
	public String removeDuplicates(String text) {
		 
		text = text.toLowerCase().replaceAll("[.,?!()]", "");
		text = text.replaceAll("\\[", "").replaceAll("\\]","");
		
		String[] words = text.split("\\s+");
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
	
	
	/**
	 * Determines similarity of two strings based on JaacardIndex formula
	 * 
	 * @param firstURLText				- String input
	 * @param secondURLText				- String input
	 * @return							- JaacardIndex
	 */
	public String calculateSimilarityScore(String firstURLText, String secondURLText) {
		
		double totalOverlappingWords = getTotalOverlappingWords(firstURLText, secondURLText);
		double totalUniqueWords = getTotalNumberUniqueWords(firstURLText, secondURLText);
		
		double result = totalOverlappingWords/totalUniqueWords;
		
		DecimalFormat df = new DecimalFormat("0.00");
		String JaccardIndex = df.format(result);

		return JaccardIndex;
	}
}
