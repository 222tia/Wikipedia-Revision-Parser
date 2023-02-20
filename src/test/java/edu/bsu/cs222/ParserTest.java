package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;

public class ParserTest {

    private final InputStream inputTestStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
    private final InputStream missingPage = Thread.currentThread().getContextClassLoader().getResourceAsStream("missingPage.json");
    private final DocumentContext jsonContext = JsonPath.parse(inputTestStream);
    private final DocumentContext missingPageJSON = JsonPath.parse(missingPage);
    Parser parser = new Parser();

    @Test
    public void parseForUsersTest() {

        ArrayList<String> output = parser.parseUser(jsonContext);
        Assertions.assertEquals("Jpgordon", output.get(0));

    }

    @Test
    public void parseForTimeStampTest() {

        ArrayList<String> output = parser.parseTimeStamp(jsonContext);
        Assertions.assertEquals("2023-01-07T16:32:37Z", output.get(0));

    }

    @Test
    public void parseForRedirectTest() {

        ArrayList<String> output = parser.parseRedirectTo(jsonContext);
        Assertions.assertEquals("Frank Zappa", output.get(0));

    }

    @Test
    public void parseRevisionListUserTest() {

        ArrayList<Revision> revisionArrayList = parser.parse(jsonContext);
        Assertions.assertEquals("Jpgordon", revisionArrayList.get(0).user);

    }

    @Test
    public void parseRevisionListTimeStampTest() {

        ArrayList<Revision> revisionArrayList = parser.parse(jsonContext);
        Assertions.assertEquals("2023-01-05T13:00:13Z", revisionArrayList.get(3).timestamp);

    }

    @Test
    public void parseRevisionListLengthTest() {

        ArrayList<Revision> revisionArrayList = parser.parse(jsonContext);
        Assertions.assertEquals(4, revisionArrayList.size());

    }

    @Test
    public void missingPageTest(){
        try {
            parser.parsePageMissing(missingPageJSON);
        } catch (Error error){
            assert(error).getMessage().equals("Page does not exist");
        }
    }
}


