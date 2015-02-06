package com.example.sparkh.epiandroid.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * For the /module GET request
 */
public class ModuleInfo {
    public String scolaryear = null;
    public String codeModule = null;
    public String codeInstance = null;
    public int semester = -1;
    public String name = null;
    public String start = null;
    public String endRegister = null;
    public String end = null;
    public int credit = -1;
    public String description = null;
    public String competence = null;
    public String flags = null;
    public String instanceLocation = null;
    public List<String> responsable = new ArrayList<>();
    public List<String> assistant = new ArrayList<>();
    public boolean isRegistered = false;
    public String grade = null;
    public List<ActivityModule> listActivityModule = new ArrayList<>();


    public ModuleInfo(JSONObject response) {
        try {
            scolaryear = response.getString("scolaryear");
            codeModule = response.getString("codemodule");
            codeInstance = response.getString("codeinstance");
            semester = response.getInt("semester");
            name = response.getString("title");
            start = response.getString("begin");
            endRegister = response.getString("end_register");
            end = response.getString("end");
            credit = response.getInt("credits");
            description = response.getString("description");
            competence = response.getString("competence");
            flags = response.getString("flags");
            instanceLocation = response.getString("instance_location");

            try {
                JSONArray resp = response.getJSONArray("resp");
                for (int i = 0 ; i < resp.length() ; i++) {
                    responsable.add(resp.getJSONObject(i).getString("login"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                JSONArray assist = response.getJSONArray("assistant");
                for (int i = 0 ; i < assist.length() ; i++) {
                    assistant.add(assist.getJSONObject(i).getString("login"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (response.getInt("student_registered") == 0)
                isRegistered = true;
            grade = response.getString("student_grade");

            try {
                JSONArray activity = response.getJSONArray("activities");
                for (int i = 0 ; i < activity.length() ; i++) {
                    listActivityModule.add(new ActivityModule(activity.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static class ActivityModule {
        public String codeActivity = null;
        public String instanceLocation = null;
        public String nameModule = null;
        public String nameActivity = null;
        public String description = null;
        public String start = null;
        public String endRegister = null;
        public String end = null;
        public String isRegistered = null;
        public String nameProject = null;
        public String note = null;

        public ActivityModule(JSONObject obj) {
            try {
                codeActivity = obj.getString("codeacti");
                instanceLocation = obj.getString("instance_location");
                nameModule = obj.getString("module_title");
                nameActivity = obj.getString("title");
                description = obj.getString("description");
                start = obj.getString("start");
                endRegister = obj.getString("end_register");
                end = obj.getString("end");
                isRegistered = obj.getString("register");
                nameProject = obj.getString("project_title");
                note = obj.getString("note");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
