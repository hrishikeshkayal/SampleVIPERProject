package com.codeeden.sampleviperproject.network;

import java.net.CookieManager;

public class NetworkUtil {

    //public static String f4795a = "https://unicomobile.bancounico.co.mz/wsscibapi";
    public static final String BASE_URL = "http://162.243.110.92:2020/api/";
    public static final String WSSC_API_ID = "cpcAfrica";
    public static final String WSSC_API_PWS = "02020320932dsklslsdhhsdoxl2";
    private static final CookieManager cookieManager = new CookieManager();

    public static CookieManager getCookieManager() {
        return cookieManager;
    }

}
