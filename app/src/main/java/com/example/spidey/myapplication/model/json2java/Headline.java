package com.example.spidey.myapplication.model.json2java;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headline {
    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("content_kicker")
    @Expose
    private String contentKicker;

    /**
     * @return The main
     */
    public String getMain() {
        return main;
    }

    /**
     * @param main The main
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * @return The contentKicker
     */
    public String getContentKicker() {
        return contentKicker;
    }

    /**
     * @param contentKicker The content_kicker
     */
    public void setContentKicker(String contentKicker) {
        this.contentKicker = contentKicker;
    }
}
