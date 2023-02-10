package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParserTest {

    @Test
    public void parseForUsersTest() throws IOException {

        revisionParser parser = new revisionParser();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<String> output = parser.parseUser(inputStream);
        Assertions.assertEquals("Jpgordon", output.get(0));

    }

    @Test
    public void parseForTimeStampTest() throws IOException {

        revisionParser parser = new revisionParser();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<String> output = parser.parseTimeStamp(inputStream);
        Assertions.assertEquals("2023-01-07T16:32:37Z", output.get(0));

    }

    @Test
    public void parseForRedirectTest() throws IOException {

        revisionParser parser = new revisionParser();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<String> output = parser.parseRedirect(inputStream);
        Assertions.assertEquals("[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"}]", output.get(0));

    }
}

