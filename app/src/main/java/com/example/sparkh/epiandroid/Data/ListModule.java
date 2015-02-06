package com.example.sparkh.epiandroid.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * For the /allmodules GET request
 */
public class ListModule {
    public List<Module> listModule = new ArrayList<>();

    public ListModule(JSONObject response) {
        try {
            JSONArray arrayModule = response.getJSONArray("items");
            for (int i = 0 ; i < arrayModule.length() ; i++) {
                listModule.add(new Module(arrayModule.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static class Module {
        public int semester = -1;
        public String start = null;
        public String end = null;
        public String endRegister = null;
        public int scolaryear = -1;
        public String codeModule = null;
        public String codeInstance = null;
        public String location = null;
        public String flags =  null;
        public String credit = null;
        public boolean isRegistered = false;
        public String waitGrade = null;
        public String activePromo = null;
        public String isOpen = null;
        public String name = null;

        public Module(JSONObject obj){
            try {
                semester = obj.getInt("semester");
                start = obj.getString("begin");
                end = obj.getString("end");
                endRegister = obj.getString("end_register");
                scolaryear = obj.getInt("scolaryear");
                codeModule = obj.getString("code");
                codeInstance = obj.getString("codeinstance");
                location = obj.getString("location_title");
                flags = obj.getString("flags");
                credit = obj.getString("credits");
                String r = obj.getString("status");
                if (r.equals(null) == false || r.equals("notregistered") == false)
                    isRegistered = true;
                waitGrade = obj.getString("waiting_grade");
                activePromo = obj.getString("active_promo");
                isOpen = obj.getString("open");
                name = obj.getString("title");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
