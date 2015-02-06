package com.example.sparkh.epiandroid.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**.
 * For the /marks GET request
 */
public class ListMark {
    public List<Mark> listMark = new ArrayList<>();

    public ListMark(JSONObject response) {

        try {
            JSONArray arrayResponse = response.getJSONArray("notes");

            for (int i = 0; i < arrayResponse.length(); i++) {
                try {
                    listMark.add(new Mark(arrayResponse.getJSONObject(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static class Mark {
        public String   scolaryear = null;
        public String   codeModule = null;
        public String   nameModule = null;
        public String   codeInstance = null;
        public String   codeActivity = null;
        public String   name = null;
        public String   date = null;
        public String   corrector = null;
        public int      note = -50000; /* -50000 = no value */
        public String   comment = null;

        public Mark(JSONObject obj) {
            try {
                scolaryear = obj.getString("scolaryear");
                codeModule = obj.getString("codemodule");
                nameModule = obj.getString("titlemodule");
                codeInstance = obj.getString("codeinstance");
                codeActivity = obj.getString("codeacti");
                name = obj.getString("title");
                date = obj.getString("date");
                corrector = obj.getString("correcteur");
                note = obj.getInt("final_note");
                comment = obj.getString("comment");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
