package com.example.mikt.yandex;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Acticity for full screen image
 */
import com.example.mikt.yandex.photo.Photo;

public class PhotoFullScreenActivity extends SingleFragmentActivity {
    public static final String PHOTO = "photo";


    public static Intent newIntent(Context packageContext, Photo photo) {
        Intent intent = new Intent(packageContext, PhotoFullScreenActivity.class);
        intent.putExtra(PHOTO, photo);
        return intent;
    }

    @Override
    public Fragment createFragment() {
        Photo photo = getIntent().getParcelableExtra(PHOTO);
        return PhotoFullScreenFragment.newInstance(photo);
    }
}
