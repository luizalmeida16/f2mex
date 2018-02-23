package com.luizalmeida.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.luizalmeida.api.component.RLECompression;

@Service
public class DataFromEndpoint  {
	private static DataFromEndpoint instance;
	private String compressedData;
	
	private DataFromEndpoint() {
	}
	
	public static synchronized DataFromEndpoint getInstance() {
		if (instance == null) {
			instance = new DataFromEndpoint();
		}
		return instance;
	}
	//Get data from URL
	public BufferedReader getBufferDataFromUrl(String urlStr) throws MalformedURLException, IOException {
		URL url = new URL(urlStr);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		
		return reader;
	}
	//Converts received data to list (just to store data in memory in a good format)
	public void setData(BufferedReader reader) throws IOException {
		String line = "";
		String tempString = "";
		while ((line = reader.readLine()) != null) {
			tempString += line;
		}
			RLECompression compression = new RLECompression();
			setCompressedData(compression.encode(tempString));
			System.out.println(this.compressedData);
	}

	public String getData() {
		RLECompression compression = new RLECompression();
		String decompressed = compression.decode(this.compressedData);
		return decompressed;
	}

	public String getCompressedData() {
		return compressedData;
	}
	
	public void setCompressedData(String data) {
		this.compressedData = data;
	}

	
}
