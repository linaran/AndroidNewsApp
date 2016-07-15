package com.example.spidey.myapplication.activity.dagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private final NewsApplication newsApplication;
    private final String baseURL;
    private final String dateFormat;

    public ApplicationModule(NewsApplication newsApplication, String baseURL, String dateFormat) {
        this.newsApplication = newsApplication;
        this.baseURL = baseURL;
        this.dateFormat = dateFormat;
    }

    @Singleton
    @Provides
    NewsApplication provideNewsApplication() {
        return this.newsApplication;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(dateFormat)
                .create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
