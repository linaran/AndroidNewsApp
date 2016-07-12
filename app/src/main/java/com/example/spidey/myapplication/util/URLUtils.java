package com.example.spidey.myapplication.util;

public final class URLUtils {
    private URLUtils() {
    }

    //    Assumed nothing starts or ends with "/".
    public static String makeURL(String baseURL, String relativeURL) {
        return baseURL + "/" + relativeURL;
    }
}
