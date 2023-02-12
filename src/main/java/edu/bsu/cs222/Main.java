package edu.bsu.cs222;


import com.jayway.jsonpath.DocumentContext;

public class Main {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        try {
            DocumentContext jsonContext = formatter.createJSONContext();
            formatter.parsePageMissing(jsonContext);
            String formattedStringList = formatter.revisionsToStringFormatter(jsonContext);
            if (formatter.checkIfRedirect(jsonContext)) {
                System.out.println(formatter.formatRedirect(jsonContext));
            }
            System.out.println(formattedStringList);
        } catch (RuntimeException ioException) {
            System.err.println("Network connection problem" + ioException.getMessage());
            System.exit(0);
        }
    }
}