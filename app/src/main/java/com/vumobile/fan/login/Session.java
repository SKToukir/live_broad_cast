package com.vumobile.fan.login;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by toukirul on 12/4/2017.
 */

public class Session {

    public static String MY_PREFS_NAME = "login_session";
    public static String USER_NAME = "name";
    public static String USER_PHONE = "phone_number";
    public static String CHECK_LOGIN = "false";

    public void saveData(String uName, String phoneNumber, boolean checkLogin, Context cntx){

        SharedPreferences.Editor editor = cntx.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(USER_NAME, uName);
        editor.putString(USER_PHONE, phoneNumber);
        editor.putBoolean(CHECK_LOGIN, checkLogin);
        editor.commit();

    }

    public static String retreiveName(Context cntx,String nameKey){
        String prefs = cntx.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).getString(nameKey,"no data saved");
        return prefs;
    }


    public static String retreivePhone(Context cntx,String phoneKey){
        String prefs = cntx.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).getString(phoneKey,"no data saved");
        return prefs;
    }

    public static boolean isLogin(Context cntx,String loginKey){
        boolean prefs = cntx.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).getBoolean(loginKey,false);
        return prefs;
    }
}
