package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;

import java.util.ArrayList;

public class Formatter extends Parser {

    protected ArrayList<String> timestampsAndUsersCombiner (DocumentContext jsonContext){
        ArrayList<String> parsedUserList = parseUser(jsonContext);
        ArrayList<String> parseTimeStampList = parseTimeStamp(jsonContext);
        ArrayList<String> revisionsList = new ArrayList<>();

        for (int item = 0; item < parseTimeStampList.size(); item++) {
            revisionsList.add(parseTimeStampList.get(item) + " " + parsedUserList.get(item)+"\n");
        }

        return revisionsList;
    }

    public String revisionsToStringFormatter (DocumentContext jsonContext){
        ArrayList<String> revisionsList = timestampsAndUsersCombiner(jsonContext);
        return String.join("", revisionsList);

    }

    public String formatRedirect(DocumentContext jsonContext){
        ArrayList<String> redirect = parseRedirectTo(jsonContext);
        return "Redirected to " + redirect.get(0);
    }
}
