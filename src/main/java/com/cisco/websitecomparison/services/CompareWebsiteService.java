package com.cisco.websitecomparison.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	public String getUrlBody(String url) {
		
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

}
