package com.example.mikt.yandex.photo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Pojo for JSON schema from Flickr.com
 */

public class PhotoLab implements Parcelable {
    @SerializedName("photo")
    @Expose
    private List<Photo> photos;

    protected PhotoLab(Parcel in) {
        photos = in.createTypedArrayList(Photo.CREATOR);
    }

    public static final Creator<PhotoLab> CREATOR = new Creator<PhotoLab>() {
        @Override
        public PhotoLab createFromParcel(Parcel in) {
            return new PhotoLab(in);
        }

        @Override
        public PhotoLab[] newArray(int size) {
            return new PhotoLab[size];
        }
    };

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(photos);
    }
}
