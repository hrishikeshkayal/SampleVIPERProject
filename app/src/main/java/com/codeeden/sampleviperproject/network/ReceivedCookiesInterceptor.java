package com.codeeden.sampleviperproject.network;


import android.util.Log;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String parse : originalResponse.headers("Set-Cookie")) {
                HttpCookie httpCookie = (HttpCookie) HttpCookie.parse(parse).get(0);
                NetworkUtil.getCookieManager().getCookieStore().add(null, httpCookie);
                Log.v( "ReceivedCookies","New Cookie:" + httpCookie);
            }
        }
        return originalResponse;
    }
}