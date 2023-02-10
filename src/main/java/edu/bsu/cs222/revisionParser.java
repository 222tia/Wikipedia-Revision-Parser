package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import net.minidev.json.JSONArray;

import java.util.ArrayList;

public class revisionParser {


    public ArrayList<String> parseUser(DocumentContext jsonContext) {

        JSONArray result = jsonContext.read( "$..user");
        ArrayList<String> parsedUsersList = new ArrayList<>(); //

        for (int item=0;item < result.toArray().length;item++){
            parsedUsersList.add(result.get(item).toString());
        }

        return parsedUsersList;
    }

    public ArrayList<String> parseTimeStamp(DocumentContext jsonContext) {

        JSONArray result = jsonContext.read("$..timestamp");
        ArrayList<String> parsedTimeStampList = new ArrayList<>();

        for (int item=0;item < result.toArray().length;item++){

            parsedTimeStampList.add(result.get(item).toString());

        }

        return parsedTimeStampList;
    }

    public ArrayList<String> parseRedirect(DocumentContext jsonContext) {

        JSONArray result = jsonContext.read("$..redirects");
        ArrayList<String> parsedRedirect = new ArrayList<>();

        parsedRedirect.add(result.get(0).toString());

        return parsedRedirect;

    }
}
