package edu.bsu.cs222;

import java.util.Scanner;
public class User {

    public String userInput(){
        String userSearchRequest;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your search:");
        userSearchRequest = scanner.nextLine();
        if (userSearchRequest.equals("")){
            System.out.println("Error: User did not provide an input");
            System.exit(0);
        }
        return userSearchRequest;
    }

}
