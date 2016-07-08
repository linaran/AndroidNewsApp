package com.example.spidey.myapplication.model.json2java;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Headline {
    @SerializedName("main")
    @Expose
    private String main;

    @SerializedName("content_kicker")
    @Expose
    private String contentKicker;

    public String getMain() {
        return main;
    }
    
    public void setMain(String main) {
        this.main = main;
    }
    
    public String getContentKicker() {
        return contentKicker;
    }
    
    public void setContentKicker(String contentKicker) {
        this.contentKicker = contentKicker;
    }
}
