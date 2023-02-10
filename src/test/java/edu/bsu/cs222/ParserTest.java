package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;

public class ParserTest {

    private final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
    private final DocumentContext jsonContext = JsonPath.parse(inputStream);

    @Test
    public void parseForUsersTest() {

        revisionParser parser = new revisionParser();
        ArrayList<String> output = parser.parseUser(jsonContext);
        Assertions.assertEquals("Jpgordon", output.get(0));

    }

    @Test
    public void parseForTimeStampTest() {

        revisionParser parser = new revisionParser();
        ArrayList<String> output = parser.parseTimeStamp(jsonContext);
        Assertions.assertEquals("2023-01-07T16:32:37Z", output.get(0));

    }

    @Test
    public void parseForRedirectTest() {

        revisionParser parser = new revisionParser();
        ArrayList<String> output = parser.parseRedirect(jsonContext);
        Assertions.assertEquals("[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"}]", output.get(0));

    }
}

