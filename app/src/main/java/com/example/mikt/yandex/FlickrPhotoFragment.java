package com.example.mikt.yandex;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mikt.yandex.photo.PhotoLab;
import com.example.mikt.yandex.photo.PhotoLabManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Fragment for RecyclerView
 */

public class FlickrPhotoFragment extends Fragment{
    private RecyclerView mPhotoRecyclerView;
    private TextView mDate;

    public static FlickrPhotoFragment newInstance() {
        return new FlickrPhotoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_list,container,false);
        mPhotoRecyclerView = v.findViewById(R.id.photos_recycler_view);
        mPhotoRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(
                        StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS,
                        StaggeredGridLayoutManager.VERTICAL)
        );
        new PhotoFetcher(mPhotoRecyclerView, getActivity());
        mDate = v.findViewById(R.id.date);
        mDate.setText(new SimpleDateFormat("d MMMM Y", Locale.getDefault()).format(new Date()));
        return v;
    }
}
