package com.example.spidey.myapplication.util;

public class URLUtils {
    private URLUtils() {
    }

    //    Assumed nothing starts or ends with "/".
    public static String makeURL(String baseURL, String relativeURL) {
        return baseURL + "/" + relativeURL;
    }
}
