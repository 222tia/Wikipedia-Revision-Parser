package edu.bsu.cs222;

public class User {

    public String userInput(String userSearchRequest){
        if (userSearchRequest.trim().equals("")){
            System.err.println("User did not provide an input");
            System.exit(0);
        }
        return userSearchRequest;
    }

}
