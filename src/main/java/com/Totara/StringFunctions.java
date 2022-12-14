package com.Totara;

import java.util.ArrayList;

public class StringFunctions {
    private static StringFunctions instance = null;

    private StringFunctions() {

    }

    public static StringFunctions getInstance(){
        if (instance == null) {
            instance = new StringFunctions();
        }
        return instance;
    }

    public String wrap(String string, int length) {
    	string = string.strip();
    	if (length <= 0) {
    		throw new IllegalArgumentException("Length must be greater than 0");
    	}
    	else if (string.length() == 0) {
    		throw new IllegalArgumentException("The string cannot be empty");
    	}
    	if (string.length() <= length) {
    		return string;
    	}
    	ArrayList<String> ret = new ArrayList<>();
    	ArrayList<String> line = new ArrayList<>();
    	String[] words = string.split(" ");
    	for (String word: words) {
    		line.add(word);
    		if (line.stream().mapToInt(String::length).sum() + line.size() - 1 > length) {
    			line.remove(line.size() - 1);
    			if (word.length() > length) {
    				int index = length - line.stream().mapToInt(String::length).sum() - line.size();
    				if (index > 0) {
	    				line.add(word.substring(0, index));
    				}
    				ret.add(String.join(" ", line));
    				line.clear();
    				String[] remainder;
    				if (index > 0) {
    					remainder = word.substring(index).split("(?<=\\G.{" + length + "})");
    				} else {
    					remainder = word.split("(?<=\\G.{" + length + "})");
    				}
    				for (String s: remainder) {
    					if (s.length() < length) {
    						line.add(s);
    					} else {
    						ret.add(s);
    					}
    				}
    				
    			} else {
	    			ret.add(String.join(" ", line));
	    			line.clear();
	    			line.add(word);
    			}
    		}
    	}
    	if (!line.isEmpty()) {
    		ret.add(String.join(" ", line));
    	}
        return String.join("\n", ret);
    }
}
