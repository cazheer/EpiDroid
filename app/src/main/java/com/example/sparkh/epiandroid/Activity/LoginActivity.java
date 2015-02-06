package com.example.sparkh.epiandroid.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.Data.User;
import com.example.sparkh.epiandroid.R;
import com.example.sparkh.epiandroid.Utils.ActivityHelper;
import com.example.sparkh.epiandroid.preferences.PreferencesManager;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends ActionBarActivity {
    private static LoginActivity context = null;

    public static void start(Activity activity, boolean kill) {
        ActivityHelper.startActivity(activity, LoginActivity.class, kill);
    }

    public static Activity getContext() {
        return context;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_login);
        context = this;

        final Button connect = (Button) this.findViewById(R.id.button_login);
        final EditText text_login = (EditText) this.findViewById(R.id.text_login);
        final EditText text_password = (EditText) this.findViewById(R.id.text_password);

        final PreferencesManager prefs = new PreferencesManager(this);
        final String savedLogin = prefs.getPrefs().getString("EpiDroidLogin", null);
        final String savedPassword = prefs.getPrefs().getString("EpiDroidMdp", null);

        if (savedLogin != null) {
            text_login.setText(savedLogin);
        }
        if (savedPassword != null) {
            text_password.setText(savedPassword);
        }

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String login = text_login.getText().toString();
                final String password = text_password.getText().toString();

                if (login.isEmpty() == true) {
                    Toast.makeText(getContext(), R.string.empty_login, Toast.LENGTH_LONG).show();
                    return;
                } else if (password.isEmpty() == true) {
                    Toast.makeText(getContext(), R.string.empty_password, Toast.LENGTH_LONG).show();
                    return;
                }

                Api.postConnectToApi(login, password, getContext(),
                        new Api.ApiListener() {
                            @Override
                            public void onResponse(String json) {
                                if (json != null) {
                                    try {
                                        JSONObject obj = new JSONObject(json);
                                        User.token = (String) obj.get("token");
                                        User.login = login;
                                        User.mdp = password;
                                        prefs.saveLoginData();
                                    } catch (JSONException error) {
                                        error.printStackTrace();
                                        return;
                                    }
                                    MenuActivity.start(getContext(), true);
                                }
                            }
                        });
            }
        });
    }
}
