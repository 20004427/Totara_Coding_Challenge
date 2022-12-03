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
        return "";
    }
}
