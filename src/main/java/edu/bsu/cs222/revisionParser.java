package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class revisionParser {
    public ArrayList<String> parseUser(InputStream inputStream) throws IOException {
        JSONArray result =(JSONArray) JsonPath.read(inputStream, "$..user");
        ArrayList<String> parsedUsersList = new ArrayList<>(); //
        for (int i=0;i < result.toArray().length;i++){
            parsedUsersList.add(result.get(i).toString());
        }
        return parsedUsersList;
    }

    public ArrayList<String> parseTimeStamp(InputStream inputStream) throws IOException {
        JSONArray result =(JSONArray) JsonPath.read(inputStream, "$..timestamp");
        ArrayList<String> parsedTimeStampList = new ArrayList<>(); //
        for (int i=0;i < result.toArray().length;i++){
            parsedTimeStampList.add(result.get(i).toString());
        }
        return parsedTimeStampList;
    }
}
