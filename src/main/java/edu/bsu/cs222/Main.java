package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        try {
            DocumentContext jsonContext = parser.createJSONContext();

            Formatter formatter = new Formatter();
            formatter.parsePageMissing(jsonContext);
            ArrayList<String> redirects = formatter.parseRedirectTo(jsonContext);
            ArrayList<String> userList = formatter.parseUser(jsonContext);
            ArrayList<String> timestampList = formatter.parseTimeStamp(jsonContext);
            ArrayList<String> formattedList = formatter.timestampsAndUsersCombiner(timestampList, userList);
            String formattedStringList = formatter.revisionsToStringFormatter(formattedList);
            if (formatter.checkIfRedirect(jsonContext)) {
                System.out.println(formatter.formatRedirect(redirects));
            }
            System.out.println(formattedStringList);
        } catch (RuntimeException ioException) {
            System.err.println("Network connection problem" + ioException.getMessage());
            System.exit(0);
        }
    }
}