package com.example.sparkh.epiandroid.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * For the /projects GET request
 */
public class ListProject {
    public List<Project>   listProject = new ArrayList<>();

    public ListProject(JSONArray response) {
        try {
            for (int i = 0 ; i < response.length() ; i++) {
                listProject.add(new Project(response.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static class Project {
        public String codeActivity = null;
        public String typeActivity = null;
        public String codeLocation = null;
        public String scolaryear = null;
        public String endActivity = null;
        public String nameModule = null;
        public boolean isRegistered = false;
        public String codeModule = null;
        public String codeInstance = null;
        public String startActivity = null;
        public String nameProject = null;
        public String nameActivity = null;

        public Project(JSONObject obj) {
            try {
                codeActivity = obj.getString("codeacti");
                typeActivity = obj.getString("type_acti");
                codeLocation = obj.getString("code_location");
                scolaryear = obj.getString("scolaryear");
                endActivity = obj.getString("end_acti");
                nameModule = obj.getString("title_module");
                if (obj.getInt("registered") == 0)
                    isRegistered = true;
                codeModule = obj.getString("codemodule");
                codeInstance = obj.getString("codeinstance");
                startActivity = obj.getString("begin_acti");
                nameProject = obj.getString("project");
                nameActivity = obj.getString("acti_title");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
