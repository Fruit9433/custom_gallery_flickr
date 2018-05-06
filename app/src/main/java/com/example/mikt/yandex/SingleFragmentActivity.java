package com.example.mikt.yandex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

/**
 * Abstract class with fragment adding routine
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    private Fragment mFragment;

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
            FragmentManager fm = getSupportFragmentManager();
            if (fm.getFragments() != null) {
                List<Fragment> fragmentList = fm.getFragments();
                Log.d("fdf","fedfd");
            }
            mFragment = fm.findFragmentById(R.id.fragment_container);
            if (mFragment == null) {
                mFragment = createFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container, mFragment)
                        .commit();
            }
    }
}
