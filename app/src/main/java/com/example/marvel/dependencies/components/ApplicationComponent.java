package com.example.marvel.dependencies.components;


import android.content.Context;
import com.example.marvel.view.BaseActivity;
import com.example.marvel.rx.PostExecutionThread;
import com.example.marvel.rx.ThreadExecutor;
import com.example.marvel.dependencies.modules.ApplicationModule;
import com.example.marvel.dependencies.modules.CharacterModule;
import com.example.marvel.view.marvel_characters.CharactersViewModelFactory;
import com.example.marvel.view.marvel_details.CharacterDetailsViewModelFactory;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, CharacterModule.class})
public interface ApplicationComponent {

    CharactersComponent.Factory charactersComponent();
    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

    CharactersViewModelFactory charactersViewModelFactory();
    CharacterDetailsViewModelFactory charactersDetailsViewModelFactory();

    void inject (BaseActivity baseActivity);
}
