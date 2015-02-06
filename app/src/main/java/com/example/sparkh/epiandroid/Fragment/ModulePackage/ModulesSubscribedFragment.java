package com.example.sparkh.epiandroid.Fragment.ModulePackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.Adapter.ListModulesAdapter;
import com.example.sparkh.epiandroid.Data.ListUserModuleInfo;
import com.example.sparkh.epiandroid.R;

import org.json.JSONArray;
import org.json.JSONException;


/**
 *
 */
public class ModulesSubscribedFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,  @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final ListView listView = (ListView) view.findViewById(R.id.list_view);

        Api.getUserModules(getActivity(),
                new Api.ApiListener() {
                    @Override
                    public void onResponse(String json) {
                        try {
                            ListUserModuleInfo modules = new ListUserModuleInfo(new JSONArray(json));
                            ListModulesAdapter listModulesAdapter = new ListModulesAdapter(getActivity(), modules);
                            listView.setAdapter(listModulesAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}