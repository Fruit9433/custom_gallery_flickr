package com.example.mikt.yandex.photo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Pojo for JSON schema from Flickr.com
 */

public class PhotoLabManager implements Parcelable {
    @SerializedName("photos")
    @Expose
    private PhotoLab mPhotoLab;

    public PhotoLabManager() {
    }

    protected PhotoLabManager(Parcel in) {
        mPhotoLab = in.readParcelable(PhotoLab.class.getClassLoader());
    }

    public static final Creator<PhotoLabManager> CREATOR = new Creator<PhotoLabManager>() {
        @Override
        public PhotoLabManager createFromParcel(Parcel in) {
            return new PhotoLabManager(in);
        }

        @Override
        public PhotoLabManager[] newArray(int size) {
            return new PhotoLabManager[size];
        }
    };

    public PhotoLab getPhotoLab() {
        return mPhotoLab;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mPhotoLab, flags);
    }
}
