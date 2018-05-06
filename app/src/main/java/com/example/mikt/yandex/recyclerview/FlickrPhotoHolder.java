package com.example.mikt.yandex.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mikt.yandex.PhotoFullScreenActivity;
import com.example.mikt.yandex.R;
import com.example.mikt.yandex.photo.Photo;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

class FlickrPhotoHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
    private ImageView mPhotoImageView;
    private TextView mTitle;
    private ProgressBar mProgressBar;
    private Photo mPhoto;
    private Context mContext;

    public FlickrPhotoHolder(View itemView, Context context) {
        super(itemView);
        mPhotoImageView = itemView.findViewById(R.id.fragment_list_element_imageview);
        mTitle = itemView.findViewById(R.id.title);
        mProgressBar = itemView.findViewById(R.id.progress_bar);
        itemView.setOnClickListener(this);
        mContext = context;
    }

    public void bindPhoto(final Photo photo) {
        mPhoto = photo;
        Picasso picasso = Picasso.get();
        picasso.setIndicatorsEnabled(true);
        picasso.load(photo.getUrlT())
                .into(mPhotoImageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        Picasso.get()
                                .load(photo.getUrlT())
                                .into(mPhotoImageView, new Callback() {
                                    @Override
                                    public void onSuccess() {
                                        mProgressBar.setVisibility(View.GONE);

                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        Log.e("Error while downloading", e.getMessage());
                                    }
                                });
                    }
                });
        mTitle.setText(mPhoto.getTitle());
    }

    @Override
    public void onClick(View v) {
        Intent i = PhotoFullScreenActivity.newIntent(mContext, mPhoto);
        mContext.startActivity(i);
        Log.e("fdf", "fsdf");
    }

}