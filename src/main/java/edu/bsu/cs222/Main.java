package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String searchRequest;

        Scanner searchRequestscanner = new Scanner(System.in);
        System.out.println("Enter your search:");
        searchRequest = searchRequestscanner.nextLine();

        User user = new User();
        user.userSearchRequest(searchRequest);

        URL url = new URL();
        String encodedURL = url.createURL(searchRequest);
        InputStream inputStream = url.connectURL(encodedURL);
        DocumentContext jsonContext = JsonPath.parse(inputStream);

        revisionFormatter formatter = new revisionFormatter();
        ArrayList<String> userList = formatter.parseUser(jsonContext);
        ArrayList<String> timestampList = formatter.parseTimeStamp(jsonContext);
        System.out.println(formatter.formatRevisions(userList,timestampList));

    }
}