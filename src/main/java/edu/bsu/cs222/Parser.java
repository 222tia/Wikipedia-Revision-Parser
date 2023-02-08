package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Parser {
    public ArrayList<String> parseUser(InputStream inputStream) throws IOException {
        JSONArray result =(JSONArray) JsonPath.read(inputStream, "$..user");
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i < result.toArray().length;i++){
            list.add(result.get(i).toString());
        }
        return list;
    }
}
