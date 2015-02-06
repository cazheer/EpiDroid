package com.example.sparkh.epiandroid.Fragment;

import com.example.sparkh.epiandroid.Fragment.ModulePackage.ModulesAllFragment;
import com.example.sparkh.epiandroid.Fragment.ModulePackage.ModulesSubscribedFragment;
import com.example.sparkh.epiandroid.Fragment.ModulePackage.ProjectsAllFragment;
import com.example.sparkh.epiandroid.Fragment.ModulePackage.ProjectsSubscribedFragment;
import com.example.sparkh.epiandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ModuleFragment extends TabsFragment {
    private List<Tab> tabs = null;

    @Override
    protected List<Tab> getTabs() {
        if (tabs == null) {
            tabs = new ArrayList<>();

            tabs.add(new Tab(getResources().getString(R.string.module_menu_all), new ModulesAllFragment()));
            tabs.add(new Tab(getResources().getString(R.string.module_menu_subscribed), new ModulesSubscribedFragment()));
            tabs.add(new Tab(getResources().getString(R.string.project_menu_all), new ProjectsAllFragment()));
            tabs.add(new Tab(getResources().getString(R.string.project_menu_subscribed), new ProjectsSubscribedFragment()));
        }

        return tabs;
    }
}
