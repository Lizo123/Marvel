package com.example.marvel.dependencies.modules;

import android.content.Context;

import com.example.marvel.rx.PostExecutionThread;
import com.example.marvel.rx.ThreadExecutor;
import com.example.marvel.rx.UIThread;
import com.example.marvel.dependencies.AndroidApplication;
import com.example.marvel.dependencies.JobExecutor;
import com.example.marvel.repository.Repository;
import com.example.marvel.repository.RepositoryImpl;
import com.example.marvel.usecases.GetAllCharactersUseCase;
import com.example.marvel.usecases.GetThumbnailsUseCase;
import com.example.marvel.view.marvel_characters.CharactersViewModelFactory;
import com.example.marvel.view.marvel_details.CharacterDetailsViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor() {
        return new JobExecutor();
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread() {
        return new UIThread();
    }

    @Provides
    @Singleton
    Repository provideRepository(RepositoryImpl repository) {
        return repository;
    }

    private GetAllCharactersUseCase provideAllCharactersUseCase() {
        return new GetAllCharactersUseCase(provideRepository(new RepositoryImpl()), provideThreadExecutor(), providePostExecutionThread());
    }

    private GetThumbnailsUseCase provideComicsThumbnailUseCase() {
        return new GetThumbnailsUseCase(provideRepository(new RepositoryImpl()), provideThreadExecutor(), providePostExecutionThread());
    }

    CharactersViewModelFactory provideCharactersViewModelFactory() {
        return new CharactersViewModelFactory(provideAllCharactersUseCase());
    }

    CharacterDetailsViewModelFactory provideCharacterDetailsViewModelFactory() {
        return new CharacterDetailsViewModelFactory(provideComicsThumbnailUseCase());
    }
}
