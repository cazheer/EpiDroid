package com.example.sparkh.epiandroid;

import android.app.Activity;
import android.os.Bundle;

import com.example.sparkh.epiandroid.Activity.LoginActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginActivity.start(this, true);
    }
}
