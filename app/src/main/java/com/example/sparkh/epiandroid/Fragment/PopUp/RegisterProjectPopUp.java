package com.example.sparkh.epiandroid.Fragment.PopUp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.Data.ListProject;
import com.example.sparkh.epiandroid.R;

/**
 *
 */
public class RegisterProjectPopUp extends DialogFragment {
    ListProject.Project info;

    public void setInfo(ListProject.Project info) {
        this.info = info;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.project_popup, null);

        builder.setView(view)
                .setPositiveButton((!info.isRegistered ? R.string.register : R.string.unregister), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (!info.isRegistered) {
                            Api.postSubscribeProject(info.scolaryear, info.codeModule, info.codeInstance, info.codeActivity, getActivity(),
                                    new Api.ApiListener() {
                                        @Override
                                        public void onResponse(String json) {
                                            Toast.makeText(getActivity(), R.string.success_register, Toast.LENGTH_LONG).show();
                                        }
                                    });
                        } else {
                            Api.deleteUnsubscribeProject(info.scolaryear, info.codeModule, info.codeInstance, info.codeActivity, getActivity(),
                                    new Api.ApiListener() {
                                        @Override
                                        public void onResponse(String json) {
                                            Toast.makeText(getActivity(), R.string.success_unregister, Toast.LENGTH_LONG).show();
                                        }
                                    });
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        TextView name = (TextView) view.findViewById(R.id.text_name);

        name.setText(info.nameProject);

        return builder.create();
    }
}