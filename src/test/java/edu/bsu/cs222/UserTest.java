package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testInput() {
        final User user = new User();
        final String userSearchRequest = "resources/Martin_Blume_Jr._Farm.json";
        final String output = user.userInput(userSearchRequest);
        Assertions.assertEquals("resources/Martin_Blume_Jr._Farm.json", output);
    }

    @Test
    public void testNoSpaceInput(){
        final User user = new User();
        final String userSearchRequest = "";
        final String output = user.userInput(userSearchRequest);
        Assertions.assertEquals("", output);
    }

    @Test
    public void testNoInputWithSpaces(){
        final User user = new User();
        final String userSearchRequest = "   ";
        final String output = user.userInput(userSearchRequest);
        Assertions.assertEquals("",output);
    }
}
