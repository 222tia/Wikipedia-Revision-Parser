package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;

public class UserTest extends User{
    @Test
    public void testInput() {
        final String input = "Frank Zappa";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final String output = getUserSearchRequest();
        Assertions.assertEquals("Frank Zappa", output);
    }
    @Test
    public void testBlankInput() {
        try {
            final String input = "";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            getUserSearchRequest();
        } catch (Error error){
            assert(error).getMessage().equals("User did not provide an input");
        }
    }

}
