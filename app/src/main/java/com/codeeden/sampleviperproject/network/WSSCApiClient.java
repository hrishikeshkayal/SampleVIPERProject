package com.codeeden.sampleviperproject.network;



import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WSSCApiClient {

     public static <S> S createService(Class<S> serviceClass) {
         HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
         interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
         OkHttpClient client = new OkHttpClient.Builder().
                 addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(NetworkUtil.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createServiceWithHeaders(Class<S> serviceClass) {
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                final Request request = chain.request().newBuilder()
                        .addHeader("ITSAPP_DEVICE", HeaderInfo.getPhoneModel())
                        .addHeader("ITSAPP_LANG", HeaderInfo.getLanguage())
                        .addHeader("ITSAPP_SO", HeaderInfo.getAppVersion())
                        .addHeader("Connection", "Close")
                        .build();

                return chain.proceed(request);
            }
        };
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);
        httpClient.addInterceptor(new ReceivedCookiesInterceptor());
        httpClient.addInterceptor(new AddCookiesInterceptor());
        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(NetworkUtil.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
