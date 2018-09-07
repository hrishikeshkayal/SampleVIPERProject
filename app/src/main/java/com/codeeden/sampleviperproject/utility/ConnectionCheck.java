package com.codeeden.sampleviperproject.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Created by imran64 on 4/5/16.
 */
public class ConnectionCheck {


    /**
     * Check for network availability If network is not available return without
     * further executing
     */
    public static boolean isNetworkAvailable(Context context) {
        return isNetworkAvailable(context, true);
    }

    /**
     * Check for network availability If network is not available return without
     * further executing
     */
    public static boolean isNetworkAvailable(Context context, boolean showToast) {
        boolean outcome = false;
        try {
            if (context != null) {
                ConnectivityManager cm = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo[] networkInfos = cm.getAllNetworkInfo();

                for (NetworkInfo tempNetworkInfo : networkInfos) {

                    /**
                     * Can also check if the user is in roaming
                     */
                    if (tempNetworkInfo != null
                            && tempNetworkInfo.isConnected()) {
                        outcome = true;
                        break;
                    }
                }
            }

            if (!outcome && showToast)
                AppData.showNoInterNetToast(context);

            return outcome;
        } catch (Exception e) {
            e.printStackTrace();
            return outcome;

        }
    }
}
