package com.example.sparkh.epiandroid.Data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 01/02/15.
 * For the /user GET request
 */
public class StudentInfo {
    public String   login = null;
    public String   fullName = null;
    public String   email = null;
    public int      promo = -1;
    public int      semester = -1;
    public String   location = null;
    public boolean  isClose = false;
    public String   courseCode = null;
    public int      currentYear = -1;
    public int      credit = -1;
    public String   gpa = null;
    public String   cycle = null;
    public int   spice = 0;
    public int   activeLogIn = -1;
    public int   iddleLogIn = -1;
    public int   activeLogOut = -1;
    public int   iddleLogOut = -1;

    public StudentInfo(JSONObject obj) {
        try {
            login = obj.getString("login");
            fullName = obj.getString("title");
            email = obj.getString("internal_email");
            promo = obj.getInt("promo");
            semester = obj.getInt("semester");
            location = obj.getString("location");
            isClose = obj.getBoolean("close");
            courseCode = obj.getString("course_code");
            currentYear = obj.getInt("studentyear");
            credit = obj.getInt("credits");
            getGPA(obj.getJSONArray("gpa").getJSONObject(0));
            getCycle(obj.getJSONArray("gpa").getJSONObject(0));
            try {
                spice = Integer.valueOf(obj.getJSONObject("spice").getString("available_spice").toString());
            } catch (JSONException e) {
            }
            activeLogIn = obj.getJSONObject("nsstat").getInt("active");
            iddleLogIn = obj.getJSONObject("nsstat").getInt("idle");
            activeLogOut = obj.getJSONObject("nsstat").getInt("out_active");
            iddleLogOut = obj.getJSONObject("nsstat").getInt("out_idle");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getGPA(JSONObject obj) {
        try {
            gpa = obj.getString("gpa");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getCycle(JSONObject obj) {
        try {
            cycle = obj.getString("cycle");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
