package com.codeeden.sampleviperproject.utility;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.audiocaption.R;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static android.content.Context.ACTIVITY_SERVICE;


/**
 * Created by imran64 on 16/3/17.
 */

public class AppData {

    public static String TAG = "MC ::::";
    public static final String BASE_URL = "http://162.243.110.92:4001/api/";
    public static String apptype = "ANDROID";
    public static String fromApp = "1";
    public static String appVersion = "1.0";
    /***response codes***/
    public static final int RESPONSE_SUCESS = 2000;

    public static final int RESPONSE_AUTHENTICATION_FAILED = 4001;
    public static final int RESPONSE_USER_ALREADY_EXIST = 5000;
    public static final int RESPONSE_USER_DOES_NOT_EXIST = 4000;
    public static final int RESPONSE_NO_RECORD_FOUND = 5002;
    public static final int REPONE_SUCCESSFULLY_SYNC = 5005;
    public static final int REPONE_PASSWORD_DOES_NOT_MATCH = 4002;
    public static final int REPONE_OLDPASSWORD_DOES_NOT_MATCH = 4010;

    /**********end of respponse code******/

    /********** page type **********/

    public static final String PAGE_SIGNUP = "USER-SIGN-UP";
    public static final String PAGE_SIGNIN = "USER-LOGIN";
    public static final String PAGE_CHANGE_PASSWORD = "CHANGE-PASSWORD";
    public static final String PAGE_PROFILE_UPDATE = "EDIT-PROFILE";
    public static final String PAGE_LOGOUT = "USER-LOGOUT";
    public static final String PAGE_FORGOTPASSWORD = "USER-FORGOT-PASSWORD";


    public static void showNoInterNetToast(Context context) {
        Toast.makeText(context, context.getResources().getString(R.string.err_msg_internet), Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public static void showException(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void startNewActivity(Activity activity, Class className, boolean clearStack) {
        Intent intent = new Intent(activity, className);
        if (clearStack)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public static void startNewActivitySingleInstance(Activity activity, Class className) {
        if (activity.getClass().toString().contains(String.valueOf(className)))
            return;
        Intent intent = new Intent(activity, className);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public static void startNewActivity(Activity activity, Class className, Bundle bundle, boolean clearStack) {
        Intent intent = new Intent(activity, className);
        intent.putExtras(bundle);
        if (clearStack)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);

    }

    public static int getContentLength(String path, Context context){
        try{
            Uri uri = Uri.parse(path);
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(context,uri);
            String durationStr = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int millSecond = Integer.parseInt(durationStr);
            return (int)(millSecond/1000);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public static String contentLengthConverter(String sec){

        int seconds = 0;
        try{
            double tmp = Double.parseDouble(sec);
            seconds = (int)tmp;
        }catch (Exception e){
            e.printStackTrace();
        }

        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(seconds*1000),
                TimeUnit.MILLISECONDS.toMinutes(seconds*1000) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(seconds*1000)),
                TimeUnit.MILLISECONDS.toSeconds(seconds*1000) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(seconds*1000)));
    }

    public static void openSoftKeyboard(Context context, EditText edtTxt) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edtTxt, InputMethodManager.SHOW_FORCED);
    }

    public static void hideKeyboard(final Activity activity) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                View view = activity.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        }, 1000);
    }

    public static boolean isMale(Context context){
        PrefUtils.init(context);
        PrefUtils prefUtils = PrefUtils.getInstance();
        return prefUtils.getUserGender().equalsIgnoreCase("male");
    }

    public static void hideKeyboardA(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static String loadJSON(String filePath){
        String result = "";
        try{
            File tmpFile = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(tmpFile);
            int size = fileInputStream.available();
            byte[] buffer = new byte[size];
            fileInputStream.read(buffer);
            fileInputStream.close();
            result = new String(buffer, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    //remove all the saved data of the SharedPreferences
    public static void clearSharedPrefs(Context context) {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.clear();
        editor.apply();
    }

    public static String userid() {
        return PrefUtils.getInstance().getUser_ID();
    }

    public static String authToken() {
        return PrefUtils.getInstance().getAuth_Token();
    }

    public static void closeProgressDialog(ProgressDialog progressDialog) {
        if (progressDialog != null) {
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            progressDialog = null;
        }
    }

    // UTC to Local Time zone
    public static String cnvertEpocToDateTimeMode(String miliiseconf) {
        try {
            Date date = new Date(Long.parseLong(miliiseconf));
            return "" + (new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss.SSSZ", Locale.getDefault())).format(date).toString().replaceAll("Z$", " ");
        } catch (Exception e) {
        }
        return "";
    }


    //formating date and time for trip history
    public static String cnvertEpocToDateTimeMoodeOne(String miliiseconf) {
        try {
            Date date = new Date(Long.parseLong(miliiseconf));
            return "" + (new SimpleDateFormat("dd,MMM HH:mm a", Locale.getDefault())).format(date).toString().replaceAll("Z$", " ");
        } catch (Exception e) {
        }
        return "";
    }

    public static String cnvertEpocToDob(String miliiseconf) {
        try {
            Date date = new Date(Long.parseLong(miliiseconf));
            return "" + (new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())).format(date).toString().replaceAll("Z$", " ");
        } catch (Exception e) {
        }
        return "";
    }

    //check if dates is same or not
    public static boolean issame(Calendar date1, Calendar date2) {
        if (date1 == null || date2 == null) {
            return false;
        } else {
            int year1 = date1.get(Calendar.YEAR);
            int month1 = date1.get(Calendar.MONTH);
            int day1 = date1.get(Calendar.DAY_OF_MONTH);
            int year2 = date2.get(Calendar.YEAR);
            int month2 = date2.get(Calendar.MONTH);
            int day2 = date2.get(Calendar.DAY_OF_MONTH);

            if (year1 == year2) {
                if (month1 == month2) {
                    if (day1 == day2)
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean isafter(Calendar date1, Calendar date2) {
        if (date1 == null || date2 == null) {
            return false;
        }


        int year1 = date1.get(Calendar.YEAR);
        int month1 = date1.get(Calendar.MONTH);
        int day1 = date1.get(Calendar.DAY_OF_MONTH);

        int year2 = date2.get(Calendar.YEAR);
        int month2 = date2.get(Calendar.MONTH);
        int day2 = date2.get(Calendar.DAY_OF_MONTH);


        if (year1 > year2) {
            return true;
        }

        if (year1 < year2) {
            return false;
        }


        if (year1 == year2) {

            if (month1 > month2)
                return true;

            if (month1 < month2)
                return false;


            if (month1 == month2) {

                if (day1 > day2)
                    return true;

                if (day1 < day2)
                    return false;

                if (day1 == day2)
                    return true;
            }
        }
        return false;
    }


    //change date time to UTC time format as per locale
    public static String convertDateTimeToUtc(String dateTimeString) {
        try {
            SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date = dateParser.parse(dateTimeString);
            SimpleDateFormat dateFormatter = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            return dateFormatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertUtcToDateTime(String dateTimeString) {
        try {
            if(dateTimeString!=null){
                SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
                dateParser.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = dateParser.parse(dateTimeString);
                SimpleDateFormat dateFormatter = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                dateFormatter.setTimeZone(TimeZone.getDefault());
                return dateFormatter.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px)
    {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    /****** check the activity *******/
    public static boolean isForeground(String myPackage, Context applicationContext) {
        ActivityManager manager = (ActivityManager) applicationContext.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfo = manager.getRunningTasks(1);
        ComponentName componentInfo = runningTaskInfo.get(0).topActivity;
        return componentInfo.getPackageName().equals(myPackage);
    }

    public static String currentForegroundedActivity(String myPackage, Context applicationContext) {
        ActivityManager manager = (ActivityManager) applicationContext.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfo = manager.getRunningTasks(1);
        ComponentName componentInfo = runningTaskInfo.get(0).topActivity;
        System.out.println(AppData.TAG+" Current activity ===>"+ String.valueOf(componentInfo.getPackageName().equals(myPackage)?componentInfo.getClassName():"none"));
        return componentInfo.getPackageName().equals(myPackage)?componentInfo.getClassName():"none";
    }
}
