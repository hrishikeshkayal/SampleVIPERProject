package com.codeeden.sampleviperproject.network;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Network_check {

//			********************************************************************************************
//	 										IF NETWORK IS ACTIVE OR NOT
//			********************************************************************************************

    public static boolean isNetworkAvailable(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        return (networkInfo != null && networkInfo.isConnected()) || (networkInfo2 != null && networkInfo2.isConnected());
    }


 /*   public static boolean isNetworkAvailable(Context context)
    {
        boolean networkavailable=false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

            if (connectivityManager != null && activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                networkavailable = true;
            } else {
                networkavailable = false;
                Toast.makeText((Activity)context,"Connection Failed", Toast.LENGTH_LONG).show();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return networkavailable;
    }*/
}
