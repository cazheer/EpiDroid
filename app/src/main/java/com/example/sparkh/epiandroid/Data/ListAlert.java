package com.example.sparkh.epiandroid.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * For the /alerts GET request
 */
public class ListAlert {
    public List<String> listAlert= new ArrayList<>();

    public ListAlert(JSONArray response) {
        for (int i = 0 ; i < response.length() ; i++) {
            try {
                listAlert.add(response.getJSONObject(i).getString("title").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
