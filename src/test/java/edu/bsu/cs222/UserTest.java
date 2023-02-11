package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    final User user = new User();
    @Test
    public void testInput() {
        final String searchRequest = "Frank Zappa";
        final String output = user.userSearchRequest(searchRequest);
        Assertions.assertEquals("Frank Zappa", output);
    }

    @Test
    public void testNoSpaceInput(){
        final String searchRequest = "";
        final String output = user.userSearchRequest(searchRequest);
        Assertions.assertEquals("", output);
    }

}
