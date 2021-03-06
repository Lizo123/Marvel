// Generated by Dagger (https://dagger.dev).
package com.example.marvel.dependencies.components;

import android.content.Context;
import com.example.marvel.datasource.CloudDataStore;
import com.example.marvel.datasource.CloudDataStore_Factory;
import com.example.marvel.datasource.DataStoreFactory;
import com.example.marvel.datasource.DataStoreFactory_Factory;
import com.example.marvel.dependencies.modules.ApplicationModule;
import com.example.marvel.dependencies.modules.ApplicationModule_ProvideApplicationContextFactory;
import com.example.marvel.dependencies.modules.ApplicationModule_ProvidePostExecutionThreadFactory;
import com.example.marvel.dependencies.modules.ApplicationModule_ProvideRepositoryFactory;
import com.example.marvel.dependencies.modules.ApplicationModule_ProvideThreadExecutorFactory;
import com.example.marvel.dependencies.modules.CharacterModule;
import com.example.marvel.repository.Repository;
import com.example.marvel.repository.RepositoryImpl;
import com.example.marvel.repository.RepositoryImpl_Factory;
import com.example.marvel.rx.PostExecutionThread;
import com.example.marvel.rx.ThreadExecutor;
import com.example.marvel.usecases.GetAllCharactersUseCase;
import com.example.marvel.usecases.GetAllCharactersUseCase_Factory;
import com.example.marvel.usecases.GetThumbnailsUseCase;
import com.example.marvel.usecases.GetThumbnailsUseCase_Factory;
import com.example.marvel.usecases.UseCase_MembersInjector;
import com.example.marvel.view.BaseActivity;
import com.example.marvel.view.marvel_characters.CharactersActivity;
import com.example.marvel.view.marvel_characters.CharactersViewModelFactory;
import com.example.marvel.view.marvel_characters.CharactersViewModelFactory_Factory;
import com.example.marvel.view.marvel_characters.CharactersViewModelFactory_MembersInjector;
import com.example.marvel.view.marvel_details.CharacterDetailsActivity;
import com.example.marvel.view.marvel_details.CharacterDetailsViewModelFactory;
import com.example.marvel.view.marvel_details.CharacterDetailsViewModelFactory_Factory;
import com.example.marvel.view.marvel_details.CharacterDetailsViewModelFactory_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideApplicationContextProvider;

  private Provider<ThreadExecutor> provideThreadExecutorProvider;

  private Provider<PostExecutionThread> providePostExecutionThreadProvider;

  private Provider<CloudDataStore> cloudDataStoreProvider;

  private Provider<DataStoreFactory> dataStoreFactoryProvider;

  private Provider<RepositoryImpl> repositoryImplProvider;

  private Provider<Repository> provideRepositoryProvider;

  private DaggerApplicationComponent(ApplicationModule applicationModuleParam) {

    initialize(applicationModuleParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private GetAllCharactersUseCase getGetAllCharactersUseCase() {
    return injectGetAllCharactersUseCase(GetAllCharactersUseCase_Factory.newInstance(provideRepositoryProvider.get(), provideThreadExecutorProvider.get(), providePostExecutionThreadProvider.get()));}

  private GetThumbnailsUseCase getGetThumbnailsUseCase() {
    return injectGetThumbnailsUseCase(GetThumbnailsUseCase_Factory.newInstance(provideRepositoryProvider.get(), provideThreadExecutorProvider.get(), providePostExecutionThreadProvider.get()));}

  @SuppressWarnings("unchecked")
  private void initialize(final ApplicationModule applicationModuleParam) {
    this.provideApplicationContextProvider = DoubleCheck.provider(ApplicationModule_ProvideApplicationContextFactory.create(applicationModuleParam));
    this.provideThreadExecutorProvider = DoubleCheck.provider(ApplicationModule_ProvideThreadExecutorFactory.create(applicationModuleParam));
    this.providePostExecutionThreadProvider = DoubleCheck.provider(ApplicationModule_ProvidePostExecutionThreadFactory.create(applicationModuleParam));
    this.cloudDataStoreProvider = CloudDataStore_Factory.create(provideApplicationContextProvider);
    this.dataStoreFactoryProvider = DataStoreFactory_Factory.create(cloudDataStoreProvider);
    this.repositoryImplProvider = RepositoryImpl_Factory.create(dataStoreFactoryProvider);
    this.provideRepositoryProvider = DoubleCheck.provider(ApplicationModule_ProvideRepositoryFactory.create(applicationModuleParam, repositoryImplProvider));
  }

  @Override
  public CharactersComponent.Factory charactersComponent() {
    return new CharactersComponentFactory();}

  @Override
  public Context context() {
    return provideApplicationContextProvider.get();}

  @Override
  public ThreadExecutor threadExecutor() {
    return provideThreadExecutorProvider.get();}

  @Override
  public PostExecutionThread postExecutionThread() {
    return providePostExecutionThreadProvider.get();}

  @Override
  public CharactersViewModelFactory charactersViewModelFactory() {
    return injectCharactersViewModelFactory(CharactersViewModelFactory_Factory.newInstance(getGetAllCharactersUseCase()));}

  @Override
  public CharacterDetailsViewModelFactory charactersDetailsViewModelFactory() {
    return injectCharacterDetailsViewModelFactory(CharacterDetailsViewModelFactory_Factory.newInstance(getGetThumbnailsUseCase()));}

  @Override
  public void inject(BaseActivity baseActivity) {
  }

  private GetAllCharactersUseCase injectGetAllCharactersUseCase(GetAllCharactersUseCase instance) {
    UseCase_MembersInjector.injectThreadExecutor(instance, provideThreadExecutorProvider.get());
    UseCase_MembersInjector.injectPostExecutionThread(instance, providePostExecutionThreadProvider.get());
    return instance;
  }

  private CharactersViewModelFactory injectCharactersViewModelFactory(
      CharactersViewModelFactory instance) {
    CharactersViewModelFactory_MembersInjector.injectGetAllCharactersUseCase(instance, getGetAllCharactersUseCase());
    return instance;
  }

  private GetThumbnailsUseCase injectGetThumbnailsUseCase(GetThumbnailsUseCase instance) {
    UseCase_MembersInjector.injectThreadExecutor(instance, provideThreadExecutorProvider.get());
    UseCase_MembersInjector.injectPostExecutionThread(instance, providePostExecutionThreadProvider.get());
    return instance;
  }

  private CharacterDetailsViewModelFactory injectCharacterDetailsViewModelFactory(
      CharacterDetailsViewModelFactory instance) {
    CharacterDetailsViewModelFactory_MembersInjector.injectGetComicsThumbnailsUseCase(instance, getGetThumbnailsUseCase());
    return instance;
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder characterModule(CharacterModule characterModule) {
      Preconditions.checkNotNull(characterModule);
      return this;
    }

    public ApplicationComponent build() {
      Preconditions.checkBuilderRequirement(applicationModule, ApplicationModule.class);
      return new DaggerApplicationComponent(applicationModule);
    }
  }

  private final class CharactersComponentFactory implements CharactersComponent.Factory {
    @Override
    public CharactersComponent create() {
      return new CharactersComponentImpl();
    }
  }

  private final class CharactersComponentImpl implements CharactersComponent {
    private CharactersComponentImpl() {

    }

    @Override
    public void inject(CharactersActivity marvelCharactersActivity) {
    }

    @Override
    public void inject(CharacterDetailsActivity marvelCharacterDetailsActivity) {
    }
  }
}
