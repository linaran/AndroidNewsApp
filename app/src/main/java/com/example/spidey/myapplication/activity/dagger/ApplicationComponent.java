package com.example.spidey.myapplication.activity.dagger;

import com.example.spidey.myapplication.NewsApplication;
import com.example.spidey.myapplication.model.NYTimesService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentInjects, ApplicationModule.Expose {
    final class Initializer {
        private Initializer() {
        }

        static public ApplicationComponent init(NewsApplication newsApplication, String baseURL) {
            return DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(newsApplication, baseURL, NYTimesService.DATE_FORMAT))
                    .build();
        }
    }
}
