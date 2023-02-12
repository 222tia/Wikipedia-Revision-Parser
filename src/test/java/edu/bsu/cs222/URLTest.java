package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class URLTest {
    @Test
    public void testCreateURL(){
        final URL url = new URL();
        final String input = "Frank Zappa";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final String output = url.createURL();
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank+Zappa&rvprop=timestamp|user&rvlimit=27&redirects", output);
    }
}