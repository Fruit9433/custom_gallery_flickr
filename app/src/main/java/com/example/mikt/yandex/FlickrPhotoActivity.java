package com.example.mikt.yandex;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

/**
 * Activity for the RecyclerView
 */

public class FlickrPhotoActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return FlickrPhotoFragment.newInstance();
    }
}
