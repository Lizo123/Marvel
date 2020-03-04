// Generated by Dagger (https://dagger.dev).
package com.example.marvel.view.marvel_characters;

import com.example.marvel.usecases.GetAllCharactersUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CharactersViewModelFactory_Factory implements Factory<CharactersViewModelFactory> {
  private final Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider;

  private final Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider2;

  public CharactersViewModelFactory_Factory(
      Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider,
      Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider2) {
    this.getAllCharactersUseCaseProvider = getAllCharactersUseCaseProvider;
    this.getAllCharactersUseCaseProvider2 = getAllCharactersUseCaseProvider2;
  }

  @Override
  public CharactersViewModelFactory get() {
    CharactersViewModelFactory instance = newInstance(getAllCharactersUseCaseProvider.get());
    CharactersViewModelFactory_MembersInjector.injectGetAllCharactersUseCase(instance, getAllCharactersUseCaseProvider2.get());
    return instance;
  }

  public static CharactersViewModelFactory_Factory create(
      Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider,
      Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider2) {
    return new CharactersViewModelFactory_Factory(getAllCharactersUseCaseProvider, getAllCharactersUseCaseProvider2);
  }

  public static CharactersViewModelFactory newInstance(
      GetAllCharactersUseCase getAllCharactersUseCase) {
    return new CharactersViewModelFactory(getAllCharactersUseCase);
  }
}