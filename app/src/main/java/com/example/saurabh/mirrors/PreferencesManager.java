package com.example.saurabh.mirrors;

/**
 * Created by saurabh on 27/07/16.
 */

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {


    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "mirrors-welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private static final String USER_NAME = "UserName";
    private static final String EMAIL_ID = "EmailId";
    private static final String PHONE_NUMBER = "PhoneNumber";
    private static final String IS_LOGGED_IN = "IsLoggedIn";
    private static final String GENDER_SELECTED = "genderSelected";

    public PreferencesManager(Context context) {
        this._context = context;
        preferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }
    public boolean isFirstTimeLaunch() {
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setUserName(String firstName){
        editor.putString(USER_NAME,firstName);
        editor.commit();
    }
    public String getUserName() {
        return preferences.getString(USER_NAME, "");
    }

    public void setEmailId(String emailId){
        editor.putString(EMAIL_ID,emailId);
        editor.commit();
    }
    public String getEmailId() {
        return preferences.getString(EMAIL_ID, "");
    }

    public void setPhoneNumber(String phoneNumber){
        editor.putString(PHONE_NUMBER,phoneNumber);
        editor.commit();
    }
    public String getPhoneNumber() {
        return preferences.getString(PHONE_NUMBER, "");
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        editor.putBoolean(IS_LOGGED_IN, isLoggedIn);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(IS_LOGGED_IN, false);
    }

    public void setGender(String gender) {
        editor.putString(GENDER_SELECTED, gender);
        editor.commit();
    }

    public String getGender(){
        return preferences.getString(GENDER_SELECTED, "M");
    }
}
