package com.example.marvel.dependencies.components;


import com.example.marvel.dependencies.PerActivity;
import com.example.marvel.view.marvel_characters.CharactersActivity;
import com.example.marvel.view.marvel_details.CharacterDetailsActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent
public interface CharactersComponent {

    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        CharactersComponent create();
    }

    void inject(CharactersActivity marvelCharactersActivity);

    void inject(CharacterDetailsActivity marvelCharacterDetailsActivity);
}
