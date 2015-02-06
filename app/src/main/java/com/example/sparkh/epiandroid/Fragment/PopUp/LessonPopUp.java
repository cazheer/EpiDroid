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
import com.example.sparkh.epiandroid.Data.ListLesson;
import com.example.sparkh.epiandroid.R;

/**
 *
 */
public class LessonPopUp extends DialogFragment {
    ListLesson.Lesson   lesson;

    public void setLesson(ListLesson.Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.lesson_popup, null);

        builder.setView(view)
                .setPositiveButton((!lesson.isRegistered ? R.string.register : R.string.unregister), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (!lesson.isRegistered && lesson.allowRegister) {
                            Api.postSubscribeEvent(lesson.scolaryear, lesson.codeModule, lesson.codeInstance, lesson.codeActivity, lesson.codeEvent, getActivity(),
                                    new Api.ApiListener() {
                                        @Override
                                        public void onResponse(String json) {
                                            Toast.makeText(getActivity(), R.string.success_register, Toast.LENGTH_LONG).show();
                                        }
                                    });
                        } else if (lesson.isRegistered) {
                            Api.deleteUnsubscribeEvent(lesson.scolaryear, lesson.codeModule, lesson.codeInstance, lesson.codeActivity, lesson.codeEvent, getActivity(),
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

        TextView name = (TextView) view.findViewById(R.id.textview_name);
        TextView type = (TextView) view.findViewById(R.id.textview_type);
        TextView module = (TextView) view.findViewById(R.id.textview_module);
        TextView time = (TextView) view.findViewById(R.id.textview_time);

        name.setText(lesson.name);
        type.setText(lesson.type + " ---> register " + (lesson.allowRegister ? "allowed" : "not allowed"));
        module.setText(lesson.nameModule + " (" + lesson.codeModule + ")");
        time.setText(lesson.start + " - " + lesson.end);

        return builder.create();
    }
}