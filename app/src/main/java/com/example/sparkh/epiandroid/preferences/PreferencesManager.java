package com.example.sparkh.epiandroid.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sparkh.epiandroid.Data.User;

import java.util.Set;

/**
 *
 */
public class PreferencesManager {
    private final SharedPreferences prefs;

    public PreferencesManager(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public PreferencesManager(Context context) {
        this(context.getSharedPreferences("EpiDroidPreferences", Context.MODE_PRIVATE));
    }

    public boolean put(String key, Object value) {
        SharedPreferences.Editor editor = this.prefs.edit();

        if (value instanceof String) {
            editor.putString(key, (String) value);
        }
        else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        }
        else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }
        else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        }

        return editor.commit();
    }

    public <T> T get(String key, Class<T> clazz) {
        if (clazz == String.class) {
            return clazz.cast(getString(key, null));
        }
        else if (clazz == Integer.class) {
            return clazz.cast(getInt(key, -1));
        }
        else if (clazz == Boolean.class) {
            return clazz.cast(getBoolean(key, false));
        }

        return null;
    }

    public String getString(String key, String defValue) {
        return prefs.getString(key, defValue);
    }

    public Set<String> getStringSet(String key, Set<String> defValues) {
        return prefs.getStringSet(key, defValues);
    }

    public int getInt(String key, int defValue) {
        return prefs.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return prefs.getLong(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return prefs.getFloat(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return prefs.getBoolean(key, defValue);
    }

    public boolean contains(String key) {
        return this.prefs.contains(key);
    }

    public void remove(String key) {
        this.prefs.edit().remove(key).commit();
    }

    public SharedPreferences getPrefs() {
        return this.prefs;
    }

    public void saveLoginData(String login, String mdp) {
        this.put("EpiDroidLogin", login);
        this.put("EpiDroidMdp", mdp);
    }

    public void saveLoginData() {
        this.saveLoginData(User.login, User.mdp);
    }
}
