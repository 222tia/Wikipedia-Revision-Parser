package edu.bsu.cs222;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String searchRequest;

        Scanner scanner = new Scanner(System.in); //name the scanner something more specific to follow cc
        System.out.println("Enter your search:");
        searchRequest = scanner.nextLine();

        User user = new User();
        user.userSearchRequest(searchRequest);

        URL url = new URL();
        String encodedurl = url.createURL(searchRequest);
        InputStream inputStream = url.connectURL(encodedurl);

    }
}