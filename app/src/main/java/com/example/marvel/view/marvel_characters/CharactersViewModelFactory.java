package com.example.marvel.view.marvel_characters;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.marvel.usecases.GetAllCharactersUseCase;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class CharactersViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    GetAllCharactersUseCase getAllCharactersUseCase;



    @Inject
    public CharactersViewModelFactory( GetAllCharactersUseCase getAllCharactersUseCase) {
        this.getAllCharactersUseCase= getAllCharactersUseCase;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CharactersActivityViewModel(getAllCharactersUseCase);
    }
}
