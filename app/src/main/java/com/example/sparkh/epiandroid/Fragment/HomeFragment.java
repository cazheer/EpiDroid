package com.example.sparkh.epiandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.API.DownloadImage;
import com.example.sparkh.epiandroid.Data.ListMessage;
import com.example.sparkh.epiandroid.Data.StudentInfo;
import com.example.sparkh.epiandroid.Data.User;
import com.example.sparkh.epiandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * HomeFragment
 */
public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        /* Image */
        final ImageView image = (ImageView) view.findViewById(R.id.user_picture);

        Api.getPicture(User.login, getActivity(),
                new Api.ApiListener() {
                    @Override
                    public void onResponse(String json) {
                        try {
                            JSONObject obj = new JSONObject(json);
                            new DownloadImage(image, obj.getString("url")).execute();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

        /* User infos */
        final TextView login = (TextView) view.findViewById(R.id.textWrite_login);
        final TextView name = (TextView) view.findViewById(R.id.textWrite_name);
        final TextView promo = (TextView) view.findViewById(R.id.textWrite_promo);
        final TextView logTime = (TextView) view.findViewById(R.id.textWrite_log);
        final TextView cred = (TextView) view.findViewById(R.id.textWrite_credit);
        final TextView gpa = (TextView) view.findViewById(R.id.textWrite_gpa);
        final TextView cycle = (TextView) view.findViewById(R.id.textWrite_cycle);
        final TextView semester = (TextView) view.findViewById(R.id.textWrite_semester);
        final TextView spices = (TextView) view.findViewById(R.id.textWrite_spices);
        final TextView lastMessage = (TextView) view.findViewById(R.id.textWrite_last_message);

        Api.getUser(User.login, getActivity(),
                new Api.ApiListener() {
                    @Override
                    public void onResponse(String json) {
                        try {
                            StudentInfo user = new StudentInfo(new JSONObject(json));

                            login.setText(user.login);
                            name.setText(user.fullName);
                            promo.setText(String.valueOf(user.promo));
                            logTime.setText(String.valueOf(user.activeLogIn));
                            cred.setText(String.valueOf(user.credit));
                            gpa.setText(user.gpa);
                            cycle.setText(user.cycle);
                            semester.setText(String.valueOf(user.semester));
                            spices.setText(String.valueOf(user.spice));

                            Api.getMessages(getActivity(),
                                    new Api.ApiListener() {
                                        @Override
                                    public void onResponse (String json) {
                                            try {
                                                ListMessage message = new ListMessage(new JSONArray(json));
                                                if (message.listMessage.size() > 0)
                                                    lastMessage.setText(Html.fromHtml(message.listMessage.get(message.listMessage.size() - 1).message));
                                                else
                                                    lastMessage.setText("None");
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
