package com.example.sparkh.epiandroid.Fragment.InformationPackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.Adapter.ListMessagesAdapter;
import com.example.sparkh.epiandroid.Data.ListMessage;
import com.example.sparkh.epiandroid.R;

import org.json.JSONArray;
import org.json.JSONException;


/**
 * Created by root on 03/02/15.
 */
public class MessagesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final ListView listView = (ListView) view.findViewById(R.id.list_view);

        Api.getMessages(getActivity(), new Api.ApiListener() {
            @Override
            public void onResponse(String json) {
                ListMessage listMessage;
                try {
                    listMessage = new ListMessage(new JSONArray(json));
                    ListMessagesAdapter listMessagesAdapter = new ListMessagesAdapter(getActivity(), listMessage);
                    listView.setAdapter(listMessagesAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
