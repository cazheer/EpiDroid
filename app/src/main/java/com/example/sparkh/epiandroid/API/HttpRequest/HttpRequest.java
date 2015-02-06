package com.example.sparkh.epiandroid.API.HttpRequest;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.R;

import java.util.Map;

/**
 * Class created to do every HttpRequest
 */
public class HttpRequest {
    private static RequestQueue queue = null;

    /**
     * Http request : get
     * @param url url where you want to send the request
     * @param context Context to create the requestQueue
     * @param listener  Listener from where you receive the response
     */
    public static void get(final String url, final Context context, final Api.ApiListener listener) {
        if (queue == null)
            queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(context, R.string.error_network_timeout, Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(context, R.string.login_failure, Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            Toast.makeText(context, R.string.error_server, Toast.LENGTH_LONG).show();
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(context, R.string.error_network, Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(context, R.string.error_parsing, Toast.LENGTH_LONG).show();
                        }
                        error.printStackTrace();
                    }
                });
        queue.add(request);
    }

    /**
     * Http request : delete
     * @param url url where you want to send the request
     * @param context Context to create the requestQueue
     * @param listener Listener from where you receive the response
     */
    public static void delete(final String url, final Context context, final Api.ApiListener listener) {
        if (queue == null)
            queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(context, R.string.error_network_timeout, Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(context, R.string.login_failure, Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            Toast.makeText(context, R.string.error_server, Toast.LENGTH_LONG).show();
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(context, R.string.error_network, Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(context, R.string.error_parsing, Toast.LENGTH_LONG).show();
                        }
                        error.printStackTrace();
                    }
                });
        queue.add(request);
    }

    /**
     * Http request : post
     * @param url url where you want to send the request
     * @param params Map<String,String> of params
     * @param context Context to create the requestQueue
     * @param listener Listener from where you receive the response
     */
    public static void post(final String url, final Map<String,String> params, final Context context, final Api.ApiListener listener) {
        if (queue == null)
            queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(context, R.string.error_network_timeout, Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(context, R.string.login_failure, Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            Toast.makeText(context, R.string.error_server, Toast.LENGTH_LONG).show();
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(context, R.string.error_network, Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(context, R.string.error_parsing, Toast.LENGTH_LONG).show();
                        }
                        error.printStackTrace();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        queue.add(request);
    }
}
