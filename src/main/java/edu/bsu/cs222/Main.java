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
        InputStream inputStream = url.connectURL(encodedURL);
        DocumentContext jsonContext = JsonPath.parse(inputStream);

        formatter formatter = new formatter();
        ArrayList<String> userList = formatter.parseUser(jsonContext);
        ArrayList<String> timestampList = formatter.parseTimeStamp(jsonContext);
        ArrayList<String> formattedList = formatter.timestampsAndUsersCombiner(timestampList,userList);
        String formattedStringList = formatter.revisionsToStringFormatter(formattedList);
        System.out.println(formattedStringList);
    }
}