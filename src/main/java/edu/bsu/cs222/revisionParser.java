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

        for (int item=0;item < result.toArray().length;item++){
            parsedUsersList.add(result.get(item).toString());
        }

        return parsedUsersList;
    }

    public ArrayList<String> parseTimeStamp(InputStream inputStream) throws IOException {

        JSONArray result =(JSONArray) JsonPath.read(inputStream, "$..timestamp");
        ArrayList<String> parsedTimeStampList = new ArrayList<>();

        for (int item=0;item < result.toArray().length;item++){

            parsedTimeStampList.add(result.get(item).toString());

        }

        return parsedTimeStampList;
    }

    public ArrayList<String> parseRedirect(InputStream inputStream) throws IOException {

        JSONArray result =(JSONArray) JsonPath.read(inputStream, "$..redirects");
        ArrayList<String> parsedRedirect = new ArrayList<>();
        parsedRedirect.add(result.get(0).toString());
        return parsedRedirect;

    }
}
