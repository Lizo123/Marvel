package com.example.marvel.view.marvel_details;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.marvel.usecases.GetThumbnailsUseCase;

import javax.inject.Inject;

public class CharacterDetailsViewModelFactory implements ViewModelProvider.Factory  {

    @Inject
    GetThumbnailsUseCase getComicsThumbnailsUseCase;



    @Inject
    public CharacterDetailsViewModelFactory( GetThumbnailsUseCase getComicsThumbnailsUseCase) {
        this.getComicsThumbnailsUseCase = getComicsThumbnailsUseCase;

    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CharactersDetailsActivityViewModel(getComicsThumbnailsUseCase);
    }
}
