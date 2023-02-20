package edu.bsu.cs222;


import java.util.Scanner;

public class User {

    protected String getUserSearchRequest() {

        System.out.println("Enter your search:");
        String searchRequest = blankSearchRequestCheck();
        blankSearchRequestWithSpacesCheck(searchRequest);
        return searchRequest;
    }
    public String blankSearchRequestCheck() {
        try {
            Scanner searchRequestScanner = new Scanner(System.in);
            return searchRequestScanner.nextLine();
        } catch (RuntimeException NoSuchElementException){
            throw new Error("User did not provide an input");
        }
    }
    protected void blankSearchRequestWithSpacesCheck(String searchRequest) {
            if (searchRequest.trim().equals("")) {
                throw new Error("User did not provide an input");
            }
    }
    }

