package com.example.sparkh.epiandroid.Utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Activity start helper
 */
public class ActivityHelper {
    public static <T extends Activity> void startActivity(Activity parent, Class<T> clazz,
                                                          boolean killParent) {
        Intent intent = new Intent(parent, clazz);
        if (killParent) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        parent.startActivity(intent);

        if (killParent) {
            parent.finish();
        }
    }
}
