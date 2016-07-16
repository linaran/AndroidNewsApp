package com.example.spidey.myapplication.activity.dagger;

import com.example.spidey.myapplication.NewsApplication;
import com.example.spidey.myapplication.model.NYTimesAPI;
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

        static public ApplicationComponent init(NewsApplication newsApplication) {
            return DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(newsApplication, NYTimesAPI.BASE_API_URL, NYTimesService.DATE_FORMAT))
                    .build();
        }
    }
}
