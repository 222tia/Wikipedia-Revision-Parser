package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class URLTest {
    @Test
    public void testCreateURL(){
        final URL url = new URL();
        final String articleTitle = "Frank_Zappa.json";
        final String output = url.createURL(articleTitle);
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank+Zappa&rvprop=timestamp|user&rvlimit=27", output);
    }
}