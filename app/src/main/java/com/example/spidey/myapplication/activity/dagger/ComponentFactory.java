package com.example.spidey.myapplication.activity.dagger;

public class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(NewsApplication newsApplication) {
        return ApplicationComponent.Initializer.init(newsApplication);
    }
}
