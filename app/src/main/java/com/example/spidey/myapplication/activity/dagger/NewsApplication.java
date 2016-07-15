package com.example.spidey.myapplication.activity.dagger;

import android.app.Application;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class NewsApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Inject
    Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = ComponentFactory.createApplicationComponent(this);
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
