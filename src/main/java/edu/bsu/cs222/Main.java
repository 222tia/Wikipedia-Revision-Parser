package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String searchRequest;

        Scanner searchRequestScanner = new Scanner(System.in);
        System.out.println("Enter your search:");
        searchRequest = searchRequestScanner.nextLine();

        User user = new User();
        user.userSearchRequest(searchRequest);

        URL url = new URL();
        String encodedURL = url.createURL(searchRequest);

        try {
            InputStream inputStream = url.connectURL(encodedURL);
            DocumentContext jsonContext = JsonPath.parse(inputStream);

        } catch (RuntimeException ioException){
            System.err.println("Network connection problem" + ioException.getMessage());
            System.exit(0);
        }
        InputStream inputStream = url.connectURL(encodedURL);
        DocumentContext jsonContext = JsonPath.parse(inputStream);

        Formatter formatter = new Formatter();
        formatter.parsePageMissing(jsonContext);
        ArrayList<String> redirects = formatter.parseRedirectTo(jsonContext);
        ArrayList<String> userList = formatter.parseUser(jsonContext);
        ArrayList<String> timestampList = formatter.parseTimeStamp(jsonContext);
        ArrayList<String> formattedList = formatter.timestampsAndUsersCombiner(timestampList,userList);
        String formattedStringList = formatter.revisionsToStringFormatter(formattedList);
        if (formatter.checkIfRedirect(jsonContext)) {
            System.out.println(formatter.formatRedirect(redirects));
        }
        System.out.println(formattedStringList);
    }
}