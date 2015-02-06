package com.example.sparkh.epiandroid.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * For the /messages GET request
 */
public class ListMessage {
    public List<Message> listMessage = new ArrayList<>();

    public ListMessage (JSONArray response) {
        for (int i = 0 ; i < response.length() ; i++) {
            try {
                listMessage.add(new Message(response.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Message {
        public String   message = null;
        public String   date = null;

        public Message(JSONObject obj) {
            try {
                message = obj.getString("title");
                date = obj.getString("date");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
