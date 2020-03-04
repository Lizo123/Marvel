// Generated by Dagger (https://dagger.dev).
package com.example.marvel.view.marvel_details;

import com.example.marvel.usecases.GetThumbnailsUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CharactersDetailsActivityViewModel_Factory implements Factory<CharactersDetailsActivityViewModel> {
  private final Provider<GetThumbnailsUseCase> getComicsThumbnailsUseCaseProvider;

  private final Provider<GetThumbnailsUseCase> getThumbnailsUseCaseProvider;

  public CharactersDetailsActivityViewModel_Factory(
      Provider<GetThumbnailsUseCase> getComicsThumbnailsUseCaseProvider,
      Provider<GetThumbnailsUseCase> getThumbnailsUseCaseProvider) {
    this.getComicsThumbnailsUseCaseProvider = getComicsThumbnailsUseCaseProvider;
    this.getThumbnailsUseCaseProvider = getThumbnailsUseCaseProvider;
  }

  @Override
  public CharactersDetailsActivityViewModel get() {
    CharactersDetailsActivityViewModel instance = newInstance(getComicsThumbnailsUseCaseProvider.get());
    CharactersDetailsActivityViewModel_MembersInjector.injectGetThumbnailsUseCase(instance, getThumbnailsUseCaseProvider.get());
    return instance;
  }

  public static CharactersDetailsActivityViewModel_Factory create(
      Provider<GetThumbnailsUseCase> getComicsThumbnailsUseCaseProvider,
      Provider<GetThumbnailsUseCase> getThumbnailsUseCaseProvider) {
    return new CharactersDetailsActivityViewModel_Factory(getComicsThumbnailsUseCaseProvider, getThumbnailsUseCaseProvider);
  }

  public static CharactersDetailsActivityViewModel newInstance(
      GetThumbnailsUseCase getComicsThumbnailsUseCase) {
    return new CharactersDetailsActivityViewModel(getComicsThumbnailsUseCase);
  }
}
