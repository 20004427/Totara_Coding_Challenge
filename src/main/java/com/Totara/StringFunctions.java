package com.Totara;

import java.util.ArrayList;

public class StringFunctions {
    private static StringFunctions instance;

    private StringFunctions() {

    }

    public static StringFunctions getInstance(){
        if (instance == null) {
            instance = new StringFunctions();
        }
        return instance;
    }

    public static String wrap(String string, int length) {
    	string = string.strip();
    	if (length <= 0 || string.length() == 0) {
    		throw new IllegalArgumentException("Length must be greater than 0");
    	}
    	if (string.length() <= length) {
    		return string;
    	}
    	String ret = "";
    	ArrayList<String> line = new ArrayList<>();
    	String[] words = string.split(" ");
    	for (String word: words) {
    		line.add(word);
    		if (line.stream().mapToInt(String::length).sum() + line.size() - 1 > length) {
    			line.remove(line.size() - 1);
    			if (word.length() > length) {
    				int index = length - line.stream().mapToInt(String::length).sum() + line.size();
    				line.add(word.substring(0, index));
    				ret += String.join(" ", line) + "\n";
    				line.clear();
    				String[] remainder = word.substring(index).split("(?<=\\G.{" + length + "})");
    				for (String s: remainder) {
    					if (s.length() < length) {
    						line.add(s);
    					} else {
    						ret += s + "\n";
    					}
    				}
    				
    			}
    			ret += String.join(" ", line) + "\n";
    			line.clear();
    			line.add(word);
    		}
    	}
        return ret.substring(0, ret.length() - 1);
    }
}
