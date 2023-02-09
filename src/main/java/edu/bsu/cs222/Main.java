package edu.bsu.cs222;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userSearchRequest;

        Scanner scanner = new Scanner(System.in); //name the scanner something more specific to follow cc
        System.out.println("Enter your search:");
        userSearchRequest = scanner.nextLine();

        User user = new User();
        user.userInput(userSearchRequest);

        URL url = new URL();
        String encodedurl = url.createURL(userSearchRequest);
        InputStream inputStream = url.connectURL(encodedurl);

    }
}