package edu.bsu.cs222;


import java.util.Scanner;

public class User {

    protected String getUserSearchRequest() {

        Scanner searchRequestScanner = new Scanner(System.in);
        System.out.println("Enter your search:");
        try {
            return searchRequestScanner.nextLine();
        } catch (RuntimeException NoSuchElementException){
            throw new Error("User did not provide an input");
        }
    }

    protected String blankSearchRequestWithSpacesCheck() {
        String searchRequest = getUserSearchRequest();
            if (searchRequest.trim().equals("")) {
                throw new Error("User did not provide an input");
            }
            return searchRequest;
        }
    }
