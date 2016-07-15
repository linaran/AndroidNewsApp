package com.example.spidey.myapplication.model;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {
    void inject(NYTimesServiceImpl nyTimesService);
}
