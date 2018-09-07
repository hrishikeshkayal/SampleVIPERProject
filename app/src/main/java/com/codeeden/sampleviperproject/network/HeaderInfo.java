package com.codeeden.sampleviperproject.network;

import android.os.Build.VERSION;

public class HeaderInfo {
    private static final String ANDROID_PHONE = "ANDROIDPHONE";
    public static final String API_LEVEL_TAG = "ITSAPP_SO";
    public static final String APP_VERSION_TAG = "ITSAPP_VER";
    public static final String LANGUAGE_TAG = "ITSAPP_LANG";
    public static final String PHONE_MODEL_TAG = "ITSAPP_DEVICE";
    private static String appVersion="8.0";

    public static String getApiLevel() {
        return String.valueOf(VERSION.SDK_INT);
    }

    public static String getAppVersion() {
        return appVersion;
    }

    public static String getLanguage() {
        return "en-EN";//C1363a.m6904a().equals("pt") ? "pt-PT" : C1363a.m6904a().equals("en") ? "en-EN" : C1363a.m6904a().replaceAll("_", "-");
    }

    public static String getPhoneModel() {
        return ANDROID_PHONE;
    }

    public static void setAppVersion(String str) {
        appVersion = str;
    }
}
