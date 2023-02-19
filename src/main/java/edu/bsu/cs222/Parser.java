package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Parser extends URL{

    public DocumentContext createJSONContext(){
        return JsonPath.parse(connectURL());
    }

    public ArrayList<Revision> parse(DocumentContext jsonContext){
        List<Map<String, Object>> jsonList = jsonContext.read("$..revisions[*]");
        ArrayList<Revision> revisionArrayList = new ArrayList<>();
        for (Map<String,Object> revisionObject : jsonList){
            Revision revision = new Revision();
            revision.setTimestamp((String) revisionObject.get("timestamp"));
            revision.setUser((String) revisionObject.get("user"));
            revisionArrayList.add(revision);
        }
        return  revisionArrayList;
    }

    public ArrayList<String> parseUser(DocumentContext jsonContext) {
        JSONArray usersResult = jsonContext.read( "$..user");
        ArrayList<String> parsedUsersList = new ArrayList<>();

        for (int item=0;item < usersResult.toArray().length;item++){
            parsedUsersList.add(usersResult.get(item).toString());
        }

        return parsedUsersList;
    }

    public ArrayList<String> parseTimeStamp(DocumentContext jsonContext) {

        JSONArray timestampResult = jsonContext.read("$..timestamp");
        ArrayList<String> parsedTimeStampList = new ArrayList<>();

        for (int item=0;item < timestampResult.toArray().length;item++){

            parsedTimeStampList.add(timestampResult.get(item).toString());

        }

        return parsedTimeStampList;
    }
    public boolean checkIfRedirect(DocumentContext jsonContext){
        JSONArray result = jsonContext.read("$..to");
        return result.size() != 0;
    }

    protected ArrayList<String> parseRedirectTo(DocumentContext jsonContext) {
        JSONArray result = jsonContext.read("$..to");
        ArrayList<String> parsedRedirect = new ArrayList<>();
        if (checkIfRedirect(jsonContext)) {
            parsedRedirect.add(result.get(0).toString());
            return parsedRedirect;
        }
        return null;
    }

    public boolean checkIfPageMissing(DocumentContext jsonContext){
        JSONArray result = jsonContext.read("$..missing");
        return result.size() != 0;
    }

    public void parsePageMissing(DocumentContext jsonContext) {
        if (checkIfPageMissing(jsonContext)) {
            throw new Error("Page does not exist");
        }
    }
}
