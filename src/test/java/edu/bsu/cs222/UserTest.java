package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testInput() {
        final User user = new User();
        final String userSearchRequest = "Frank Zappa";
        final String output = user.userInput(userSearchRequest);
        Assertions.assertEquals("Frank Zappa", output);
    }

    @Test
    public void testNoInput(){
        final User user = new User();
        final String userSearchRequest = "";
        final String output = user.userInput(userSearchRequest);
        Assertions.assertEquals("", output);
    }

    @Test
    public void testNoInputSpaces(){
        final User user = new User();
        final String userSearchRequest = "   ";
        final String output = user.userInput(userSearchRequest);
        Assertions.assertEquals("",output);
    }
}