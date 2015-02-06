package com.example.sparkh.epiandroid.Fragment;

import com.example.sparkh.epiandroid.Fragment.InformationPackage.AlertsFragment;
import com.example.sparkh.epiandroid.Fragment.InformationPackage.MarksFragment;
import com.example.sparkh.epiandroid.Fragment.InformationPackage.MessagesFragment;
import com.example.sparkh.epiandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InformationFragment extends TabsFragment {
    private List<Tab> tabs = null;

    @Override
    protected List<Tab> getTabs() {
        if (tabs == null) {
            tabs = new ArrayList<>();

            tabs.add(new Tab(getResources().getString(R.string.info_menu_messages), new MessagesFragment()));
            tabs.add(new Tab(getResources().getString(R.string.info_menu_alerts), new AlertsFragment()));
            tabs.add(new Tab(getResources().getString(R.string.info_menu_marks), new MarksFragment()));
        }

        return tabs;
    }
}
