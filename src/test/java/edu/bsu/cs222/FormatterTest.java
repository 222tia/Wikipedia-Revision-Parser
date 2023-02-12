package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;

public class FormatterTest extends Formatter{
    Formatter formatter = new Formatter();
    InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
    private final DocumentContext jsonContext = JsonPath.parse(inputStream);
    @Test
    public void combineFirst4Revisions(){

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("2023-01-07T16:32:37Z Jpgordon"+"\n");
        expectedList.add("2023-01-07T16:03:11Z 109.236.0.36"+"\n");
        expectedList.add("2023-01-05T17:30:34Z A. Randomdude0000"+"\n");
        expectedList.add("2023-01-05T13:00:13Z 2A00:23C4:7996:B901:74EA:481D:CB34:C5E"+"\n");
        ArrayList<String> output = formatter.timestampsAndUsersCombiner(jsonContext);
        Assertions.assertEquals(expectedList,output);
    }
   @Test
    public void formatFirst4Revisions(){
        String expectedFormattedRevisions = """
                2023-01-07T16:32:37Z Jpgordon
                2023-01-07T16:03:11Z 109.236.0.36
                2023-01-05T17:30:34Z A. Randomdude0000
                2023-01-05T13:00:13Z 2A00:23C4:7996:B901:74EA:481D:CB34:C5E
                """;
        String formattedRevisions = formatter.revisionsToStringFormatter(jsonContext);
        Assertions.assertEquals(expectedFormattedRevisions,formattedRevisions);
    }

    @Test
    public void formatRedirectTest(){
        String formattedRedirect = formatter.formatRedirect(jsonContext);
        Assertions.assertEquals("Redirected to Frank Zappa",formattedRedirect);
    }
}
