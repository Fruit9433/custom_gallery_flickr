package com.example.mikt.yandex.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mikt.yandex.R;
import com.example.mikt.yandex.photo.Photo;
import com.example.mikt.yandex.photo.PhotoLabManager;

public class FlickrPhotoAdapter extends RecyclerView.Adapter<FlickrPhotoHolder> {
    private PhotoLabManager mPhotoLabManager;
    Context mContext;

    public FlickrPhotoAdapter(PhotoLabManager photoLabManager, Context context) {
        mPhotoLabManager = photoLabManager;
        mContext = context;
    }

    @NonNull
    @Override
    public FlickrPhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_photo_list_element, parent, false);
        return new FlickrPhotoHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull FlickrPhotoHolder holder, int position) {
        Photo photo = mPhotoLabManager
                .getPhotoLab()
                .getPhotos()
                .get(holder.getAdapterPosition());
        holder.bindPhoto(photo);
    }

    @Override
    public int getItemCount() {
        return mPhotoLabManager
                .getPhotoLab()
                .getPhotos()
                .size();
    }


}
