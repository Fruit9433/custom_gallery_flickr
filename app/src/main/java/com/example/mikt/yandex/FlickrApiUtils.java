package com.example.mikt.yandex;

import android.content.Context;

/**
 * API Utils
 */

public class FlickrApiUtils {
    public static PhotoService getPhotoService(Context context) {
        return FlickrApiClient.getRetrofitClient(context).create(PhotoService.class);
    }
}
