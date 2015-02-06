package com.example.sparkh.epiandroid.Data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * For the /project GET request
 */
public class ProjectInfo {
    public String scolaryear = null;
    public String codeModule = null;
    public String codeInstance = null;
    public String codeActivity = null;
    public String instanceLocation = null;
    public String nameModule = null;
    public String titleProject = null;
    public String type = null;
    public String codeType = null;
    public boolean isRegistered = false;
    public String start = null;
    public String end = null;
    public String endRegister = null;
    public String nameProject = null;
    public boolean isClosed = false;
    public String note = null;

    public ProjectInfo (JSONObject response) {
        try {
            scolaryear = response.getString("scolaryear");
            codeModule = response.getString("codemodule");
            codeInstance = response.getString("codeinstance");
            codeActivity = response.getString("codeacti");
            instanceLocation = response.getString("instance_location");
            nameModule = response.getString("module_title");
            titleProject = response.getString("project_title");
            type = response.getString("type_title");
            codeType = response.getString("type_code");
            isRegistered = response.getBoolean("register");
            start = response.getString("begin");
            end = response.getString("end");
            endRegister = response.getString("end_register");
            nameProject = response.getString("title");
            isClosed = response.getBoolean("closed");
            note = response.getString("note");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
