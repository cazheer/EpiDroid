package com.example.sparkh.epiandroid.Fragment.PopUp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sparkh.epiandroid.API.Api;
import com.example.sparkh.epiandroid.Data.ListUserModuleInfo;
import com.example.sparkh.epiandroid.R;

/**
 *
 */
public class UnregisterModulePopUp extends DialogFragment {
    ListUserModuleInfo.UserModuleInfo info;

    public void setInfo(ListUserModuleInfo.UserModuleInfo info) {
        this.info = info;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.token_popup, null);

        final EditText text = (EditText) view.findViewById(R.id.edit_token);

        builder.setView(view)
                .setPositiveButton(R.string.unregister, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Api.deleteUnsubscribeModule(info.scolaryear, info.codeModule, info.codeInstance, getActivity(),
                                new Api.ApiListener() {
                                    @Override
                                    public void onResponse(String json) {
                                        Toast.makeText(getActivity(), R.string.success_unregister, Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        return builder.create();
    }
}