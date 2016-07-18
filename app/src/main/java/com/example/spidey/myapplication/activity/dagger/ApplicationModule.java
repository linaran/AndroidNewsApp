package com.example.spidey.myapplication.activity.dagger;

import com.example.spidey.myapplication.NewsApplication;
import com.example.spidey.myapplication.model.NYTimesService;
import com.example.spidey.myapplication.model.NYTimesServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class ApplicationModule {

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

    @Provides
    @Singleton
    NYTimesService provideNYTimesService(Retrofit retrofit) {
        return new NYTimesServiceImpl(retrofit);
    }

    interface Expose {
        Retrofit retrofit();

        NYTimesService nyTimesService();
    }
}
