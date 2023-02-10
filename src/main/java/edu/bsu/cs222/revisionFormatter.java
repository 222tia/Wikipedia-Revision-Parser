package edu.bsu.cs222;

import java.util.ArrayList;

public class revisionFormatter extends revisionParser{

    public ArrayList<String> formatRevisions (ArrayList<String> parsedUsersList, ArrayList<String> parsedTimeStampList){

        ArrayList<String> revisionsList = new ArrayList<>();

        for (int item = 0; item < parsedUsersList.size(); item++) {
            revisionsList.add(parsedTimeStampList.get(item) + " " + parsedUsersList.get(item)+"\n");
        }

        return revisionsList;
    }
}
