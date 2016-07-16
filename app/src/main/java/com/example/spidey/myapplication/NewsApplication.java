package com.example.spidey.myapplication;

import android.app.Application;

import com.example.spidey.myapplication.activity.dagger.ApplicationComponent;
import com.example.spidey.myapplication.activity.dagger.ComponentFactory;
import com.example.spidey.myapplication.model.NYTimesAPI;

public final class NewsApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = ComponentFactory.createApplicationComponent(this, NYTimesAPI.BASE_API_URL);
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
