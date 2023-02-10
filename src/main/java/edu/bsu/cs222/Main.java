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
        String encodedUserURL = url.createURL(searchRequest);
        InputStream userInputStream = url.connectURL(encodedUserURL);
        DocumentContext jsonContextUser = JsonPath.parse(userInputStream);

        String encodedTimeStampURL = url.createURL(searchRequest);
        InputStream timeStampInputStream = url.connectURL(encodedTimeStampURL);
        DocumentContext jsonContextTimeStamp = JsonPath.parse(timeStampInputStream);

        revisionFormatter formatter = new revisionFormatter();
        ArrayList<String> userList = formatter.parseUser(jsonContextUser);
        ArrayList<String> timestampList = formatter.parseTimeStamp(jsonContextTimeStamp);
        System.out.println(formatter.formatRevisions(userList,timestampList));

    }
}