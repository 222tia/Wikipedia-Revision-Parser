package edu.bsu.cs222;


import java.util.Scanner;

public class User {

    protected String getUserSearchRequest() {

        Scanner searchRequestScanner = new Scanner(System.in);
        System.out.println("Enter your search:");
        return searchRequestScanner.nextLine();

    }

    protected String blankSearchRequestCheck() {
        String searchRequest = getUserSearchRequest();
            if (searchRequest.trim().equals("")) {

                System.err.println("User did not provide an input");
                System.exit(0);
            }
            return searchRequest;
        }

    }
