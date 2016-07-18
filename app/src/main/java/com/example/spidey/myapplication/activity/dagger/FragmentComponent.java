package com.example.spidey.myapplication.activity.dagger;

import android.support.v4.app.Fragment;

import dagger.Component;

@FragmentScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                FragmentModule.class
        }
)
public interface FragmentComponent extends FragmentComponentInjects {

    final class Initializer {
        private Initializer() {
        }

        static public FragmentComponent init(Fragment fragment, ApplicationComponent applicationComponent) {
            return DaggerFragmentComponent.builder()
                    .applicationComponent(applicationComponent)
                    .fragmentModule(new FragmentModule(fragment))
                    .build();
        }
    }
}
