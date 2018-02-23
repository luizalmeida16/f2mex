package com.luizalmeida.api.component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class RLECompression {
	
	public String encode(String str) {
	    StringBuffer dest = new StringBuffer();
	    for (int i = 0; i < str.length(); i++) {
	        int runLength = 1;
	        while (i + 1 < str.length()
	                && str.charAt(i) == str.charAt(i + 1)) {
	            runLength++;
	            i++;
	        }
	        dest.append(runLength);
	        dest.append(str.charAt(i));
	    }
	    return dest.toString();
	}

	public String decode(String str) {
	    StringBuffer dest = new StringBuffer();
	    Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
	    Matcher matcher = pattern.matcher(str);
	    while (matcher.find()) {
	        int number = Integer.parseInt(matcher.group());
	        matcher.find();
	        while (number-- != 0) {
	            dest.append(matcher.group());
	        }
	    }
	    return dest.toString();
	}

}
