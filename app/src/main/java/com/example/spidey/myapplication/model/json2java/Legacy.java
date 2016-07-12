package com.example.spidey.myapplication.model.json2java;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Legacy implements Parcelable {
    @SerializedName("thumbnailheight")
    @Expose
    private String thumbnailheight;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("thumbnailwidth")
    @Expose
    private String thumbnailwidth;

    protected Legacy(Parcel in) {
        thumbnailheight = in.readString();
        thumbnail = in.readString();
        thumbnailwidth = in.readString();
    }

    public static final Creator<Legacy> CREATOR = new Creator<Legacy>() {
        @Override
        public Legacy createFromParcel(Parcel in) {
            return new Legacy(in);
        }

        @Override
        public Legacy[] newArray(int size) {
            return new Legacy[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(thumbnailheight);
        dest.writeString(thumbnail);
        dest.writeString(thumbnailwidth);
    }

    public String getThumbnailheight() {
        return thumbnailheight;
    }

    public void setThumbnailheight(String thumbnailheight) {
        this.thumbnailheight = thumbnailheight;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailwidth() {
        return thumbnailwidth;
    }

    public void setThumbnailwidth(String thumbnailwidth) {
        this.thumbnailwidth = thumbnailwidth;
    }
}
