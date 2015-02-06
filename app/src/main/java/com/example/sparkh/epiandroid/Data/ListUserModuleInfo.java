package com.example.sparkh.epiandroid.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * For the /modules GET request
 */
public class ListUserModuleInfo {
    public List<UserModuleInfo> listUserModule = new ArrayList<>();

    public ListUserModuleInfo(JSONArray response) {
        try {
            for (int i = 0 ; i < response.length() ; i++) {
                listUserModule.add(new UserModuleInfo(response.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static class UserModuleInfo {
        public String scolaryear = null;
        public String codeModule = null;
        public String codeInstance = null;
        public String name = null;
        public String cycle = null;
        public String grade = null;
        public String flags = null;
        public int credit = -1;
        public int semester = -1;

        public UserModuleInfo(JSONObject obj) {

            try {
                scolaryear = obj.getString("scolaryear");
                codeModule = obj.getString("codemodule");
                codeInstance = obj.getString("codeinstance");
                name = obj.getString("title");
                cycle = obj.getString("cycle");
                grade = obj.getString("grade");
                flags = obj.getString("flags");
                credit = obj.getInt("credit");
                semester = obj.getInt("semester");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
