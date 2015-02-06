package com.example.sparkh.epiandroid.API;

import android.content.Context;

import com.example.sparkh.epiandroid.API.HttpRequest.HttpRequest;
import com.example.sparkh.epiandroid.Data.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Interface between the application and the server
 *
 * -> contains every request to needed
 * -> work in asynchronous style so you need to use a Listener to work with it
 */
public class Api {
    private final static String https = "https://epitech-api.herokuapp.com/";

    /**
     * Interface to help the creation of the Listener
     */
    public static interface ApiListener {
        /**
         * @param json  JsonObject or JsonArray in form of String (depend of the request)
         */
        public void onResponse(String json);
    }

    /**
     * first request needed to etablish a connexion
     * @param login Login of the user
     * @param password Password of the user
     * @param context Context to create the requestQueue
     * @param listener Listener from where you receive the response
     */
    public static void postConnectToApi(final String login, final String password, final Context context, final ApiListener listener) {
        String url = https + "login";

        Map<String,String> params = new HashMap<>();
        params.put("login", login);
        params.put("password", password);

        HttpRequest.post(url, params, context, listener);
    }

    /**
     * request to get user's information
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void postUserInfo(Context context, final ApiListener listener) {
        String url = https + "infos";

        Map<String,String> params = new HashMap<>();
        params.put("token", User.token);

        HttpRequest.post(url, params, context, listener);
    }

    /**
     * request to get the planning
     * -> need start and end date (in format : YYYY-MM-DD)
     * @param start date where it start
     * @param end date where it ends
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getPlanning(String start, String end, final Context context, final ApiListener listener) {
        String url = https + "planning?token=" + User.token + "&start=" + start + "&end=" + end;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get the planning of the susies
     * -> need start and end date (in format : YYYY-MM-DD)
     * @param start date where it start
     * @param end date where it ends
     * @param state "all" | "free" | "registered"
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getSusies(String start, String end, String state, final Context context, final ApiListener listener) {
        String url = https + "susies?token=" + User.token + "&start=" + start + "&end=" + end + "&state=" + state;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get information about a susie
     * @param id id of the requested susie
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getSusie(String id, final Context context, final ApiListener listener) {
        String url = https + "susies?token=" + User.token + "&id=" + id;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to subscribe from a susie
     * @param id id of the requested susie
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void postSubscribeSusie(String id, Context context, final ApiListener listener) {
        String url = https + "susies";

        Map<String,String> params = new HashMap<>();
        params.put("token", User.token);

        HttpRequest.post(url, params, context, listener);
    }

    /**
     * request to unsubscribe from a susie
     * @param id id of the requested susie
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void deleteUnsubscribeSusie(String id, Context context, final ApiListener listener) {
        String url = https + "susies?token=" + User.token + "&id=" + id;

        HttpRequest.delete(url, context, listener);
    }

    /**
     * request to get a list of projects
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getProject(final Context context, final ApiListener listener) {
        String url = https + "projects?token=" + User.token;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get a project
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param activity activity from (example : "acti-167486")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getProject(String year, String module, String instance, String activity, final Context context, final ApiListener listener) {
        String url = https + "project?token=" + User.token + "&scolaryear=" + year + "&codemodule=" + module + "&codeinstance=" + instance + "&codeacti=" + activity;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to subscribe from a project
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param activity activity from (example : "acti-167486")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void postSubscribeProject(String year, String module, String instance, String activity, Context context, final ApiListener listener) {
        String url = https + "project";

        Map<String,String> params = new HashMap<>();
        params.put("token", User.token);
        params.put("scolaryear", year);
        params.put("codemodule", module);
        params.put("codeinstance", instance);
        params.put("codeacti", activity);

        HttpRequest.post(url, params, context, listener);
    }

    /**
     * request to unsubscribe from a project
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param activity activity from (example : "acti-167486")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void deleteUnsubscribeProject(String year, String module, String instance, String activity, final Context context, final ApiListener listener) {
        String url = https + "project?token=" + User.token + "&scolaryear=" + year + "&codemodule=" + module + "&codeinstance=" + instance + "&codeacti=" + activity;

        HttpRequest.delete(url, context, listener);
    }

    /**
     * request to get the project's files
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param activity activity from (example : "acti-167486")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getProjectFiles(String year, String module, String instance, String activity, final Context context, final ApiListener listener) {
        String url = https + "project/files?token=" + User.token + "&scolaryear=" + year + "&codemodule=" + module + "&codeinstance=" + instance + "&codeacti=" + activity;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get the user's modules
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getUserModules(final Context context, final ApiListener listener) {
        String url = https + "modules?token=" + User.token;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get all modules
     * @param year year requested
     * @param location location requested (example : "FR/PAR" or "FR/LIL")
     * @param course "bachelor/classic" | "bachelor/tek1ed" | "bachelor/tek2ed"
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getAllModules(String year, String location, String course, final Context context, final ApiListener listener) {
        String url = https + "allmodules?token=" + User.token + "&scolaryear=" + year + "&location=" + location + "&course=" + course;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get a module
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getModule(String year, String module, String instance, final Context context, final ApiListener listener) {
        String url = https + "modules?token=" + User.token + "&scolaryear=" + year + "&codemodule=" + module + "&codeinstance=" + instance;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to subscribe from a module
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void postSubscribeModule(String year, String module, String instance, Context context, final ApiListener listener) {
        String url = https + "modules";

        Map<String,String> params = new HashMap<>();
        params.put("token", User.token);
        params.put("scolaryear", year);
        params.put("codemodule", module);
        params.put("codeinstance", instance);

        HttpRequest.post(url, params, context, listener);
    }

    /**
     * request to unsubscribe from a module
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void deleteUnsubscribeModule(String year, String module, String instance, Context context, final ApiListener listener) {
        String url = https + "modules?token=" + User.token + "&scolaryear=" + year + "&codemodule=" + module + "&codeinstance=" + instance;

        HttpRequest.delete(url, context, listener);
    }

    /**
     * request to get an event
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param activity activity from (example : "acti-167486")
     * @param event event requested (example : "event-173408")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getEvent(String year, String module, String instance, String activity, String event, final Context context, final ApiListener listener) {
        String url = https + "event?token=" + User.token + "&scolaryear=" + year + "&codemodule=" + module + "&codeinstance=" + instance + "&codeacti=" + activity + "&codeevent=" + event;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to subscribe from an event
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param activity activity from (example : "acti-167486")
     * @param event event requested (example : "event-173408")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void postSubscribeEvent(String year, String module, String instance, String activity, String event, Context context, final ApiListener listener) {
        String url = https + "event";

        Map<String,String> params = new HashMap<>();
        params.put("token", User.token);
        params.put("scolaryear", year);
        params.put("codemodule", module);
        params.put("codeinstance", instance);
        params.put("codeacti", activity);
        params.put("codeevent", event);

        HttpRequest.post(url, params, context, listener);
    }

    /**
     * request to unsubscribe from an event
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param activity activity from (example : "acti-167486")
     * @param event event requested (example : "event-173408")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void deleteUnsubscribeEvent(String year, String module, String instance, String activity, String event, Context context, final ApiListener listener) {
        String url = https + "event?token=" + User.token + "&scolaryear=" + year + "&codemodule=" + module + "&codeinstance=" + instance + "&codeacti=" + activity + "&codeevent=" + event;

        HttpRequest.delete(url, context, listener);
    }

    /**
     * request to get all marks
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getMarks(final Context context, final ApiListener listener) {
        String url = https + "marks?token=" + User.token;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get all messages
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getMessages(final Context context, final ApiListener listener) {
        String url = https + "messages?token=" + User.token;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get all alerts
     * @param context Context classtoken
     * @param listener Listener from where you receive the response
     */
    public static void getAlerts(final Context context, final ApiListener listener) {
        String url = https + "alerts?token=" + User.token;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get the url of the requested login
     * @param login requested login
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getPicture(String login, final Context context, final ApiListener listener) {
        String url = https + "photo?token=" + User.token + "&login=" + login;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to validate a token
     * @param year year requested
     * @param module module from (example : "B-GPR-360-0")
     * @param instance instance of (example : "PAR-6-1")
     * @param activity activity from (example : "acti-167486")
     * @param code code of the token (example : "00000000")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void postValidateToken(String year, String module, String instance, String activity, String event, String code, Context context, final ApiListener listener) {
        String url = https + "token";

        Map<String,String> params = new HashMap<>();
        params.put("token", User.token);
        params.put("scolaryear", year);
        params.put("codemodule", module);
        params.put("codeinstance", instance);
        params.put("codeacti", activity);
        params.put("codeevent", event);
        params.put("tokenvalidationcode", code);

        HttpRequest.post(url, params, context, listener);
    }

    /**
     * request to get the trombi
     * @param year year requested
     * @param location location requested (example : "FR/PAR" or "FR/LIL")
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getTrombi(String year, String location, final Context context, final ApiListener listener) {
        String url = https + "trombi?token=" + User.token + "&year=" + year + "&location=" + location;

        HttpRequest.get(url, context, listener);
    }

    /**
     * request to get the user info
     * @param login Login of the user
     * @param context Context class
     * @param listener Listener from where you receive the response
     */
    public static void getUser(String login, final Context context, final ApiListener listener) {
        String url = https + "user?token=" + User.token + "&user=" + login;

        HttpRequest.get(url, context, listener);
    }
}
