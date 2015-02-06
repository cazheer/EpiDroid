package com.example.sparkh.epiandroid.Data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 29/01/15.
 */
public class User {
    public static String token = null;
    /* infos */
    public static String login = null;
    public static String mdp = null;
    public String lastName = null;
    public String firstName = null;
    public String email = null;
    public int promo = -1;
    public String location = null;
    public String netsoul = null;
    public boolean isClosed = false;
    public String closeReason = null;

    /* Current */
    public String currentLog = null;
    public String objectifCredit = null;
    public String normalLog = null;
    public String semester = null;
    public String currentCredit = null;
    public String inProgressCredit = null;


    public User(JSONObject response) {
        try {
            JSONObject info = response.getJSONObject("infos");
            lastName = info.getString("lastName");
            firstName = info.getString("firstName");
            email = info.getString("internal_email");
            promo = info.getInt("promo");
            location = info.getString("location");
            netsoul = info.getString("netsoul");
            isClosed = info.getBoolean("close");
            closeReason = info.getString("close_reason");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject current = response.getJSONObject("current");
            currentLog = current.getString("active_log");
            objectifCredit = current.getString("credits_obj");
            normalLog = current.getString("nslog_norm");
            semester = current.getString("semester_num");
            currentCredit = current.getString("achieved");
            inProgressCredit = current.getString("inprogress");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
