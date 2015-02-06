package com.example.sparkh.epiandroid.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sparkh on 03/02/15.
 * For /planning GET request
 */
public class ListLesson {
    public List<Lesson> day = new ArrayList<>();

    public ListLesson(JSONArray response) {
        try {
            for (int i = 0 ; i < response.length() ; i++) {
                day.add(new Lesson(response.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static class Lesson {
        public String end = null;
        public String type = null;
        public String codeEvent = null;
        public String scolaryear = null;
        public String start = null;
        public boolean isModuleRegistered = false;
        public String nameModule = null;
        public String codeModule = null;
        public String codeInstance = null;
        public String isEventRegistered = null;
        public String codeActivity = null;
        public int semester = -1;
        public String name = null;
        public String instanceLocation = null;
        public boolean allowRegister = false;
        public boolean isRegistered = false;

        public Lesson(JSONObject obj) {
            try {
                end = obj.getString("end");
                type = obj.getString("type_title");
                name = obj.getString("acti_title");
                codeEvent = obj.getString("codeevent");
                scolaryear = obj.getString("scolaryear");
                start = obj.getString("start");
                isModuleRegistered = obj.getBoolean("module_registered");
                nameModule = obj.getString("titlemodule");
                codeModule = obj.getString("codemodule");
                codeInstance = obj.getString("codeinstance");
                isEventRegistered = obj.getString("event_registered");
                codeActivity = obj.getString("codeacti");
                semester = obj.getInt("semester");
                instanceLocation = obj.getString("instance_location");
                allowRegister = obj.getBoolean("allow_register");
                isRegistered = obj.getBoolean("register_student");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
