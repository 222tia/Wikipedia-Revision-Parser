package edu.bsu.cs222;

public class User {

    public String userSearchRequest(String searchRequest){
        if (searchRequest.trim().equals("")){
            System.err.println("User did not provide an input");
            System.exit(0);
        }
        return searchRequest;
    }

}
