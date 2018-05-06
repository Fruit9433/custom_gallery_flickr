package com.example.mikt.yandex;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mikt.yandex.photo.Photo;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Fragment for full screen image
 */


public class PhotoFullScreenFragment extends Fragment {
    public static final String PHOTO = "photo";

    private ImageView mImageView;
    @Nullable
    private Photo mPhoto;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPhoto = (Photo)getArguments().getParcelable(PHOTO);
    }

    /**
     *
     * @param photo used for transfering Photo instance which should be showed in full screen
     * @return PhotoFullScreenFragment with arguments
     */
    public static PhotoFullScreenFragment newInstance(Photo photo) {
        Bundle args = new Bundle();
        args.putParcelable(PHOTO, photo);
        PhotoFullScreenFragment fragment = new PhotoFullScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.photo_full_screen, container, false);
        mImageView = v.findViewById(R.id.fragment_list_element_fullscreen);
        //Loading images with Picasso
        Picasso.get()
                .load(mPhoto.getUrlO())
                .noPlaceholder()
                .into(mImageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Picasso.get()
                                .load(mPhoto.getUrlO())
                                .into(mImageView);
                    }
                });
        return v;
    }
}
