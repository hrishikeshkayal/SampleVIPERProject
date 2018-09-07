package com.codeeden.sampleviperproject.network;


import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        if (NetworkUtil.getCookieManager().getCookieStore().getCookies().size() > 0) {
            builder.addHeader("Cookie", TextUtils.join(";", NetworkUtil.getCookieManager().getCookieStore().getCookies()));
            Log.v("AddCookiesInterceptor", "Cookie: " + TextUtils.join(";", NetworkUtil.getCookieManager().getCookieStore().getCookies()));
        }
        return chain.proceed(builder.build());
    }
}