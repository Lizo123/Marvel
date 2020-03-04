// Generated by Dagger (https://dagger.dev).
package com.example.marvel.usecases;

import com.example.marvel.rx.PostExecutionThread;
import com.example.marvel.rx.ThreadExecutor;
import dagger.MembersInjector;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetAllCharactersUseCase_MembersInjector implements MembersInjector<GetAllCharactersUseCase> {
  private final Provider<ThreadExecutor> threadExecutorProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetAllCharactersUseCase_MembersInjector(Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.threadExecutorProvider = threadExecutorProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  public static MembersInjector<GetAllCharactersUseCase> create(
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetAllCharactersUseCase_MembersInjector(threadExecutorProvider, postExecutionThreadProvider);}

  @Override
  public void injectMembers(GetAllCharactersUseCase instance) {
    UseCase_MembersInjector.injectThreadExecutor(instance, threadExecutorProvider.get());
    UseCase_MembersInjector.injectPostExecutionThread(instance, postExecutionThreadProvider.get());
  }
}
