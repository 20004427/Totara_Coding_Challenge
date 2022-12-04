package com.Totara;

public class StringFunctions {
    private static StringFunctions instance;

    private StringFunctions() {

    }

    public static StringFunctions getInstance(){
        if (instance.equals(null)) {
            instance = new StringFunctions();
        }
        return instance;
    }

    public static String wrap(String string, int length) {
    	if (length <= 0) {
    		throw new IllegalArgumentException("Length must be greater than 0");
    	}
    	if (string.length() <= length) {
    		return string;
    	}
    	String ret = "";
    	for (String word: string.split(" ")) {
    		String line = "";
    		if (word.length() > length) {
    			
    		}
    	}
        return "";
    }
}
