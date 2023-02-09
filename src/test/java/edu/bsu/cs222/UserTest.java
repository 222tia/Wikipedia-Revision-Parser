package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testInput() {
        final User user = new User();
        final String searchRequest = "Frank Zappa";
        final String output = user.userSearchRequest(searchRequest);
        Assertions.assertEquals("Frank Zappa", output);
    }

    @Test
    public void testNoSpaceInput(){
        final User user = new User();
        final String searchRequest = "";
        final String output = user.userSearchRequest(searchRequest);
        Assertions.assertEquals("", output);
    }

    @Test
    public void testNoInputWithSpaces(){
        final User user = new User();
        final String searchRequest = "   ";
        final String output = user.userSearchRequest(searchRequest);
        Assertions.assertEquals("",output);
    }
}
