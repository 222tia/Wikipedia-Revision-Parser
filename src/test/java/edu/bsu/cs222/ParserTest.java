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

        Parser parser = new Parser();
        ArrayList<String> output = parser.parseUser(jsonContext);
        Assertions.assertEquals("Jpgordon", output.get(0));

    }

    @Test
    public void parseForTimeStampTest() {

        Parser parser = new Parser();
        ArrayList<String> output = parser.parseTimeStamp(jsonContext);
        Assertions.assertEquals("2023-01-07T16:32:37Z", output.get(0));

    }

    @Test
    public void parseForRedirectTest() {

        Parser parser = new Parser();
        ArrayList<String> output = parser.parseRedirectTo(jsonContext);
        Assertions.assertEquals("Frank Zappa", output.get(0));

    }

    @Test
    public void parseRevisionListUserTest() {
        Parser parser = new Parser();
        ArrayList<Revision> revisionArrayList = parser.parse(jsonContext);
        Assertions.assertEquals("Jpgordon", revisionArrayList.get(0).user);
    }

    @Test
    public void parseRevisionListTimeStampTest() {
        Parser parser = new Parser();
        ArrayList<Revision> revisionArrayList = parser.parse(jsonContext);
        Assertions.assertEquals("2023-01-05T13:00:13Z", revisionArrayList.get(3).timestamp);
    }

    @Test
    public void parseRevisionListLengthTest() {
        Parser parser = new Parser();
        ArrayList<Revision> revisionArrayList = parser.parse(jsonContext);
        Assertions.assertEquals(4, revisionArrayList.size());
    }

}

