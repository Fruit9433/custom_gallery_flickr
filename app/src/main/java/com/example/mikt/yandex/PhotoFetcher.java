package com.example.mikt.yandex;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mikt.yandex.photo.PhotoLab;
import com.example.mikt.yandex.photo.PhotoLabManager;
import com.example.mikt.yandex.recyclerview.FlickrPhotoAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mikt.yandex.Credentials.*;

public class PhotoFetcher {
    private PhotoService mPhotoService;
    private PhotoLabManager mPhotoLabManager;

    public PhotoFetcher(final RecyclerView recyclerView, final Context context) {
        mPhotoService = FlickrApiUtils.getPhotoService(context);

        mPhotoService.getAnswers(METHOD,API_KEY,FORMAT,NOJSONCALLBACK,EXTRAS).enqueue(new Callback<PhotoLabManager>() {
            @Override
            public void onResponse(Call<PhotoLabManager> call, Response<PhotoLabManager> response) {

                if(response.isSuccessful()) {
                    mPhotoLabManager = response.body();
                    recyclerView.setAdapter(new FlickrPhotoAdapter(mPhotoLabManager, context));
                    Log.d("FlickrPhotoActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    Log.e("Error while downloading", Integer.toString(statusCode));
                }
            }

            @Override
            public void onFailure(Call<PhotoLabManager> call, Throwable t) {
                Log.d("FlickrPhotoActivity", "error loading from API");
            }
        });
    }

    public PhotoLabManager getPhotoLabManager() {
        return mPhotoLabManager;
    }
}
