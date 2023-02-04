package edu.bsu.cs222;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userSearchRequest;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your search:");
        userSearchRequest = scanner.nextLine();

        User user = new User();
        user.userInput(userSearchRequest);
    }
}