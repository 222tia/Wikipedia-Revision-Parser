package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParserTest {

    @Test
    public void parseForUsersTest() throws IOException {
        Parser parser = new Parser();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/Martin_Blume_Jr._Farm.json");
        ArrayList<String> output = parser.parseUser(inputStream);
        Assertions.assertEquals("PrimeBOT", output.get(0));
    }
}

