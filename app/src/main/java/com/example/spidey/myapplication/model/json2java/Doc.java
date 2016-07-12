package com.example.spidey.myapplication.model.json2java;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public final class Doc implements Parcelable {

    @SerializedName("web_url")
    @Expose
    private String webUrl;

    @SerializedName("snippet")
    @Expose
    private String snippet;

    @SerializedName("lead_paragraph")
    @Expose
    private String leadParagraph;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("multimedia")
    @Expose
    private List<Multimedium> multimedia = new ArrayList<>();

    @SerializedName("headline")
    @Expose
    private Headline headline;

    @SerializedName("_id")
    @Expose
    private String id;

    protected Doc(Parcel in) {
        webUrl = in.readString();
        snippet = in.readString();
        leadParagraph = in.readString();
        source = in.readString();
        multimedia = in.createTypedArrayList(Multimedium.CREATOR);
        headline = in.readParcelable(Headline.class.getClassLoader());
        id = in.readString();
    }

    public static final Creator<Doc> CREATOR = new Creator<Doc>() {
        @Override
        public Doc createFromParcel(Parcel in) {
            return new Doc(in);
        }

        @Override
        public Doc[] newArray(int size) {
            return new Doc[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(webUrl);
        dest.writeString(snippet);
        dest.writeString(leadParagraph);
        dest.writeString(source);
        dest.writeTypedList(multimedia);
        dest.writeParcelable(headline, flags);
        dest.writeString(id);
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getLeadParagraph() {
        return leadParagraph;
    }

    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return headline.getPrintHeadline();
    }
}
