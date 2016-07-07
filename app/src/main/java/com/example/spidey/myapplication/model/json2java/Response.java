package com.example.spidey.myapplication.model.json2java;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public final class Response {
    @SerializedName("docs")
    @Expose
    private List<Doc> docs = new ArrayList<>();

    /**
     * @return The docs
     */
    public List<Doc> getDocs() {
        return docs;
    }

    /**
     * @param docs The docs
     */
    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }
}
