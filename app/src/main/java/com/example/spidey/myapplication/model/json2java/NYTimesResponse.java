package com.example.spidey.myapplication.model.json2java;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NYTimesResponse {
    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
