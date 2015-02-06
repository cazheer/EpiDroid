package com.example.sparkh.epiandroid.Activity;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.API.DownloadImage;
import com.example.sparkh.epiandroid.Adapter.DrawerListAdapter;
import com.example.sparkh.epiandroid.Data.User;
import com.example.sparkh.epiandroid.Fragment.HomeFragment;
import com.example.sparkh.epiandroid.Fragment.InformationFragment;
import com.example.sparkh.epiandroid.Fragment.ModuleFragment;
import com.example.sparkh.epiandroid.Fragment.PlanningFragment;
import com.example.sparkh.epiandroid.Fragment.StudentFragment;
import com.example.sparkh.epiandroid.R;
import com.example.sparkh.epiandroid.Utils.ActivityHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MenuActivity extends ActionBarActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;

    private String[] menuList;

    public static void start(Activity activity, boolean kill) {
        ActivityHelper.startActivity(activity, MenuActivity.class, kill);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuList = getResources().getStringArray(R.array.menu_list_array);
        mDrawerLayout = (DrawerLayout) this.findViewById(R.id.menu_layout);
        mDrawerList = (ListView) this.findViewById(R.id.menu_drawer);

        DrawerListAdapter myAdapter = new DrawerListAdapter(this);
        myAdapter.addHeaderItem(User.login);
        for (String s : menuList) {
            myAdapter.addContentItem(s);
        }
        mDrawerList.setAdapter(myAdapter);
        mDrawerList.setOnItemClickListener(new ClickListener());

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setHomeButtonEnabled(true);
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(int position) {
        switch (position) {
            case 0: // Home
                setContentFrame(new HomeFragment());
                break;
            case 1: // Planning
                setContentFrame(new PlanningFragment());
                break;
            case 2: // Modules
                setContentFrame(new ModuleFragment());
                break;
            case 3: // Information
                setContentFrame(new InformationFragment());
                break;
            case 4: // Student
                setContentFrame(new StudentFragment());
                break;
            case 5: // Disconnect
                LoginActivity.start(this, true);
                return;
        }

        // Update drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(menuList[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    private void setContentFrame(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }

    private class ClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position > 0)
                selectItem(position - 1);
        }
    }
}
