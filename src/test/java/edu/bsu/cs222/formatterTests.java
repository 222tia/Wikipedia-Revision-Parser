package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class formatterTests {
    formatter formatter = new formatter();
    @Test
    public void combineFirst2Revisions(){
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> timestamps = new ArrayList<>();
        users.add("Jpgordon");
        users.add("109.236.0.36");
        timestamps.add("2023-01-07T16:32:37Z");
        timestamps.add("2023-01-07T16:03:11Z");

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("2023-01-07T16:32:37Z Jpgordon");
        expectedList.add("2023-01-07T16:03:11Z 109.236.0.36");

        ArrayList<String> output = formatter.timestampsAndUsersCombiner(users,timestamps);
        Assertions.assertEquals(expectedList,output);
    }
    @Test
    public void formatFirst2Revisions(){
        ArrayList<String> unformattedRevisions = new ArrayList<>();
        unformattedRevisions.add("2023-01-07T16:32:37Z Jpgordon");
        unformattedRevisions.add("2023-01-07T16:03:11Z 109.236.0.36");
        String expectedFormattedRevisions = "2023-01-07T16:32:37Z Jpgordon"+"2023-01-07T16:03:11Z 109.236.0.36";
        String formattedRevisions = formatter.revisionsToStringFormatter(unformattedRevisions);
        Assertions.assertEquals(expectedFormattedRevisions,formattedRevisions);
    }

    @Test
    public void formatRedirectTest(){
        ArrayList<String> unformattedRedirect = new ArrayList<>();
        unformattedRedirect.add("Frank Zappa");
        String formattedRedirect = formatter.formatRedirect(unformattedRedirect);
        Assertions.assertEquals("Redirected to Frank Zappa",formattedRedirect);
    }
}
