package com.example.sparkh.epiandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sparkh.epiandroid.R;
import com.example.sparkh.epiandroid.Utils.Sliding.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class TabsFragment extends Fragment {
    protected List<Tab> getTabs() {
        return new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tabs, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.fragment_tabs_pager);
        viewPager.setAdapter(new TabsFragmentPagerAdapter(getChildFragmentManager()));

        SlidingTabLayout tabLayout = (SlidingTabLayout) view.findViewById(R.id.fragment_tabs_tabs);
        tabLayout.setViewPager(viewPager);
    }

    public static class Tab {
        public final String title;
        public final Fragment fragment;

        public Tab(String title, Fragment fragment) {
            this.title = title;
            this.fragment = fragment;
        }
    }

    class TabsFragmentPagerAdapter extends FragmentPagerAdapter {
        public TabsFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return getTabs().get(position).fragment;
        }

        @Override
        public int getCount() {
            return getTabs().size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getTabs().get(position).title;
        }
    }
}
