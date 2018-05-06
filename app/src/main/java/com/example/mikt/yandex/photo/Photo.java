package com.example.mikt.yandex.photo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Pojo for JSON schema from Flickr.com
 */

public class Photo implements Parcelable {
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("id")
    @Expose
    private String mId;
    @SerializedName("url_m")
    @Expose
    private String mUrlT;
    @SerializedName("url_z")
    @Expose
    private String mUrlO;

    protected Photo(Parcel in) {
        mTitle = in.readString();
        mId = in.readString();
        mUrlT = in.readString();
        mUrlO = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    @Override
    public String toString() {
        return mTitle;
    }

    public String getUrlT() {
        return mUrlT;
    }

    public String getUrlO() {
        return mUrlO;
    }

    public String getTitle() {
        return mTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mId);
        dest.writeString(mUrlT);
        dest.writeString(mUrlO);
    }
}
