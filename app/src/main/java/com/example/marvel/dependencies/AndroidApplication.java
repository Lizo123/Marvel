package com.example.marvel.dependencies;

import android.app.Application;

import com.example.marvel.dependencies.components.ApplicationComponent;
import com.example.marvel.dependencies.components.DaggerApplicationComponent;
import com.example.marvel.dependencies.modules.ApplicationModule;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();

    }

    private void initializeInjector() {

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
