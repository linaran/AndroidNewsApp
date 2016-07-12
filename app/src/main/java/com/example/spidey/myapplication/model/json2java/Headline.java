package com.example.spidey.myapplication.model.json2java;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.spidey.myapplication.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Headline implements Parcelable {

    public static final String NO_PRINT_HEADLINE = "No Headline";

    @SerializedName("main")
    @Expose
    private String main;

    @SerializedName("content_kicker")
    @Expose
    private String contentKicker;

    @SerializedName("print_headline")
    @Expose
    private String printHeadline;

    protected Headline(Parcel in) {
        main = in.readString();
        contentKicker = in.readString();
        printHeadline = in.readString();
    }

    public static final Creator<Headline> CREATOR = new Creator<Headline>() {
        @Override
        public Headline createFromParcel(Parcel in) {
            return new Headline(in);
        }

        @Override
        public Headline[] newArray(int size) {
            return new Headline[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(main);
        dest.writeString(contentKicker);
        dest.writeString(printHeadline);
    }

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

    public String getPrintHeadline() {
        return (printHeadline == null || "".equals(printHeadline)) ? NO_PRINT_HEADLINE : printHeadline;
    }

    public void setPrintHeadline(String printHeadline) {
        this.printHeadline = printHeadline;
    }
}
