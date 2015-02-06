package com.example.sparkh.epiandroid.Data;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * For the /event GET request
 */
public class Event {
    public String scolaryear = null;
    public String codeModule = null;
    public String codeInstance = null;
    public String codeActivity = null;
    public String codeEvent = null;
    public int semester = -1;
    public String instanceLocation = null;
    public String nameModule = null;
    public String nameActivity = null;
    public String descriptionActivity = null;
    public String typeActivity = null;
    public String typeCodeActivity = null;
    public String time = null;
    public String start = null;
    public String end = null;
    public String roomName = null;
    public int seat = -1;

    public Event(JSONObject obj) {
        try {
            scolaryear = obj.getString("scolaryear");
            codeModule = obj.getString("codemodule");
            codeInstance = obj.getString("codeinstance");
            codeActivity = obj.getString("codeacti");
            codeEvent = obj.getString("codeevent");
            semester = obj.getInt("semester");
            instanceLocation = obj.getString("instance_location");
            nameModule = obj.getString("module_title");
            nameActivity = obj.getString("acti_title");
            descriptionActivity = obj.getString("acti_description");
            typeActivity = obj.getString("type_title");
            typeCodeActivity = obj.getString("type_code");
            time = obj.getString("nb_hours");
            start = obj.getString("start");
            end = obj.getString("end");
            roomName = obj.getJSONObject("room").getString("code").toString();
            seat = obj.getInt("seats");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
