package com.example.sparkh.epiandroid.Fragment.InformationPackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.Adapter.ListMarksAdapter;
import com.example.sparkh.epiandroid.Data.ListMark;
import com.example.sparkh.epiandroid.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public class MarksFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final ListView listView = (ListView) view.findViewById(R.id.list_view);

        Api.getMarks(getActivity(),
                new Api.ApiListener() {
                @Override
                public void onResponse(String json) {
                    ListMark listMark;
                    try {
                        listMark = new ListMark(new JSONObject(json));
                        ListMarksAdapter listMarksAdapter = new ListMarksAdapter(getActivity(), listMark);
                        listView.setAdapter(listMarksAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
        });
    }
}
