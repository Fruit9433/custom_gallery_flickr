package com.example.mikt.yandex;

import com.example.mikt.yandex.photo.Photo;
import com.example.mikt.yandex.photo.PhotoLab;
import com.example.mikt.yandex.photo.PhotoLabManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * API Interface for Flickr.com
 */

public interface PhotoService {
    /**
     *
     * @param method define what you want to do
     * @param apiKey personal api key
     * @param format response format
     * @param noJsonCallback excludes method name and parenthesis from response if 1
     * @param extras additional parameters
     * @return
     */
    @GET("services/rest")
    Call<PhotoLabManager> getAnswers(
            @Query("method")String method,
            @Query("api_key")String apiKey,
            @Query("format")String format,
            @Query("nojsoncallback")String noJsonCallback,
            @Query("extras")String extras
    );
}
