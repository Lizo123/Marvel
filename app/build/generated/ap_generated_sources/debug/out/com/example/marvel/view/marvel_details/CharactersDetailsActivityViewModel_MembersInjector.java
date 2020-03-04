// Generated by Dagger (https://dagger.dev).
package com.example.marvel.view.marvel_details;

import com.example.marvel.usecases.GetThumbnailsUseCase;
import dagger.MembersInjector;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CharactersDetailsActivityViewModel_MembersInjector implements MembersInjector<CharactersDetailsActivityViewModel> {
  private final Provider<GetThumbnailsUseCase> getThumbnailsUseCaseProvider;

  public CharactersDetailsActivityViewModel_MembersInjector(
      Provider<GetThumbnailsUseCase> getThumbnailsUseCaseProvider) {
    this.getThumbnailsUseCaseProvider = getThumbnailsUseCaseProvider;
  }

  public static MembersInjector<CharactersDetailsActivityViewModel> create(
      Provider<GetThumbnailsUseCase> getThumbnailsUseCaseProvider) {
    return new CharactersDetailsActivityViewModel_MembersInjector(getThumbnailsUseCaseProvider);}

  @Override
  public void injectMembers(CharactersDetailsActivityViewModel instance) {
    injectGetThumbnailsUseCase(instance, getThumbnailsUseCaseProvider.get());
  }

  public static void injectGetThumbnailsUseCase(Object instance,
      GetThumbnailsUseCase getThumbnailsUseCase) {
    ((CharactersDetailsActivityViewModel) instance).getThumbnailsUseCase = getThumbnailsUseCase;
  }
}
