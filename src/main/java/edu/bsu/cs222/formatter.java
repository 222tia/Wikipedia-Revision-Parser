package edu.bsu.cs222;

import java.util.ArrayList;

public class formatter extends Parser {

    public ArrayList<String> timestampsAndUsersCombiner (ArrayList<String> parsedTimeStampList, ArrayList<String> parsedUsersList){

        ArrayList<String> revisionsList = new ArrayList<>();

        for (int item = 0; item < parsedTimeStampList.size(); item++) {
            revisionsList.add(parsedTimeStampList.get(item) + " " + parsedUsersList.get(item)+"\n");
        }

        return revisionsList;
    }

    public String revisionsToStringFormatter (ArrayList<String> revisionsList){
        return String.join("", revisionsList);

    }

    public String formatRedirect(ArrayList<String> redirect){
        String redirectAsString = redirect.toString();
        return "Redirected to" + redirectAsString;
    }
}
