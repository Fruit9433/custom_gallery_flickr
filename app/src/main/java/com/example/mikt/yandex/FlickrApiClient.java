package com.example.mikt.yandex;

import android.content.Context;

import java.io.File;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class FlickrApiClient {
    private static final String SERVER_URL = "https://api.flickr.com/";

    private static Retrofit sRetrofit = null;

    /**
     * @param context context
     * @return
     */
    //
    static Retrofit getClient(Context context) {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;
        //Creating Cache instance for caching purposes
        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        //Logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //Creating OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder().cache(cache).addInterceptor(interceptor).build();

        //Creating Retrofity client
        sRetrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return sRetrofit;
    }
    public static Retrofit getRetrofitClient(Context context) {
        if (sRetrofit == null) {
            getClient(context);
        }
        return sRetrofit;
    }
}
