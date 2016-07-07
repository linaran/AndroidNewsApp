package com.example.spidey.myapplication.model.json2java;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Legacy {
    @SerializedName("thumbnailheight")
    @Expose
    private String thumbnailheight;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("thumbnailwidth")
    @Expose
    private String thumbnailwidth;
    
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
