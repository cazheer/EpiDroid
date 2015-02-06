package com.example.sparkh.epiandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.Adapter.ListLessonAdapter;
import com.example.sparkh.epiandroid.Data.ListLesson;
import com.example.sparkh.epiandroid.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class PlanningFragment extends Fragment {
    private static Date date;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planning, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        date = new Date();

        String d = new SimpleDateFormat("yyyy-MM-dd").format(date);

        final TextView textView = (TextView) view.findViewById(R.id.text_date);
        textView.setText(d);

        final ListView listView = (ListView) view.findViewById(R.id.list_view);
        Api.getPlanning(d, d, getActivity(), new Api.ApiListener() {
            @Override
            public void onResponse(String json) {
                ListLesson listLesson;
                try {
                    listLesson = new ListLesson(new JSONArray(json));
                    ListLessonAdapter listLessonAdapter = new ListLessonAdapter(getActivity(), listLesson);
                    listView.setAdapter(listLessonAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        final ImageButton prev = (ImageButton) view.findViewById(R.id.prev_button);
        final ImageButton next = (ImageButton) view.findViewById(R.id.next_button);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);

                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, -1);
                date = c.getTime();

                String d = new SimpleDateFormat("yyyy-MM-dd").format(date);
                textView.setText(d);

                Api.getPlanning(d, d, getActivity(), new Api.ApiListener() {
                    @Override
                    public void onResponse(String json) {
                        ListLesson listLesson;
                        try {
                            listLesson = new ListLesson(new JSONArray(json));
                            ListLessonAdapter listLessonAdapter = new ListLessonAdapter(getActivity(), listLesson);
                            listView.setAdapter(listLessonAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);

                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();

                String d = new SimpleDateFormat("yyyy-MM-dd").format(date);
                textView.setText(d);

                Api.getPlanning(d, d, getActivity(), new Api.ApiListener() {
                    @Override
                    public void onResponse(String json) {
                        ListLesson listLesson;
                        try {
                            listLesson = new ListLesson(new JSONArray(json));
                            ListLessonAdapter listLessonAdapter = new ListLessonAdapter(getActivity(), listLesson);
                            listView.setAdapter(listLessonAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
