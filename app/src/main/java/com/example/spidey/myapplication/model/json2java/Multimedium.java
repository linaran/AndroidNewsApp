package com.example.spidey.myapplication.model.json2java;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Multimedium implements Parcelable {
    @SerializedName("width")
    @Expose
    private Integer width;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("height")
    @Expose
    private Integer height;

    @SerializedName("subtype")
    @Expose
    private String subtype;

    @SerializedName("legacy")
    @Expose
    private Legacy legacy;

    @SerializedName("type")
    @Expose
    private String type;

    protected Multimedium(Parcel in) {
        url = in.readString();
        subtype = in.readString();
        type = in.readString();
    }

    public static final Creator<Multimedium> CREATOR = new Creator<Multimedium>() {
        @Override
        public Multimedium createFromParcel(Parcel in) {
            return new Multimedium(in);
        }

        @Override
        public Multimedium[] newArray(int size) {
            return new Multimedium[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(subtype);
        dest.writeString(type);
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getSubtype() {
        return subtype;
    }
    
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Legacy getLegacy() {
        return legacy;
    }
    
    public void setLegacy(Legacy legacy) {
        this.legacy = legacy;
    }

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
