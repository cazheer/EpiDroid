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
import com.example.sparkh.epiandroid.Data.ListLesson;
import com.example.sparkh.epiandroid.R;

/**
 *
 */
public class TokenPopUp extends DialogFragment {
    ListLesson.Lesson   lesson;

    public void setLesson(ListLesson.Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.token_popup, null);

        final EditText text = (EditText) view.findViewById(R.id.edit_token);

        builder.setView(view)
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (text.getText().toString().isEmpty()) {
                            Toast.makeText(getActivity(), R.string.empty_token, Toast.LENGTH_LONG).show();
                            return;
                        }

                        Api.postValidateToken(lesson.scolaryear, lesson.codeModule, lesson.codeInstance, lesson.codeActivity, lesson.codeEvent, text.getText().toString(), getActivity(),
                                new Api.ApiListener() {
                                    @Override
                                    public void onResponse(String json) {
                                        Toast.makeText(getActivity(), R.string.success_token, Toast.LENGTH_LONG).show();
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