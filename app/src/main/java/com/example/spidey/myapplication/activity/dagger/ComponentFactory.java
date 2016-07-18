package com.example.spidey.myapplication.activity.dagger;

import android.support.v4.app.Fragment;

import com.example.spidey.myapplication.NewsApplication;

public final class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(NewsApplication newsApplication) {
        return ApplicationComponent.Initializer.init(newsApplication);
    }

    public static FragmentComponent createFragmentComponent(Fragment fragment,
                                                            NewsApplication newsApplication) {
        return FragmentComponent.Initializer.init(fragment, newsApplication.getApplicationComponent());
    }
}
