package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String searchRequest;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your search:");
        searchRequest = scanner.nextLine();

        User user = new User();
        user.userSearchRequest(searchRequest);

        URL url = new URL();
        String encodedUserURL = url.createURL(searchRequest);
        InputStream userInputStream = url.connectURL(encodedUserURL);
        String encodedTimeStampURL = url.createURL(searchRequest);
        InputStream timeStampInputStream = url.connectURL(encodedTimeStampURL);

        revisionFormatter formatter = new revisionFormatter();
        ArrayList<String> userList = formatter.parseUser(userInputStream);
        ArrayList<String> timestampList = formatter.parseTimeStamp(timeStampInputStream);
        System.out.println(formatter.formatRevisions(userList,timestampList));

    }
}