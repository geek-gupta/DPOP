package com.example.d_pop.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import static  com.example.d_pop.utility.PreferencesUtility.*;

public class SaveSharedPreferences {

    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Set the Login Status
     * @param context
     * @param loggedIn
     */
    public static void setLoggedIn(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.apply();
    }

    public static void setIsStudentStatus(Context context, boolean isStudent) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(IS_STUDENT, isStudent);
        editor.apply();
    }

    /**
     * Get the Login Status
     * @param context
     * @return boolean: login status
     */
    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false);
    }

    public static boolean getIsStudentStatus(Context context) {
        return getPreferences(context).getBoolean(IS_STUDENT, false);
    }

    public static String getRollnumber(Context context) {
        return getPreferences(context).getString(ROLL_NUMBER, "");
    }

    public static void setRollNumber(Context context, String rollnumber) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(ROLL_NUMBER, rollnumber);
        editor.apply();
    }
}
