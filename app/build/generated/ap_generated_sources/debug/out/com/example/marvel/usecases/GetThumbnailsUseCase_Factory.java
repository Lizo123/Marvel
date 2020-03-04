// Generated by Dagger (https://dagger.dev).
package com.example.marvel.usecases;

import com.example.marvel.repository.Repository;
import com.example.marvel.rx.PostExecutionThread;
import com.example.marvel.rx.ThreadExecutor;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetThumbnailsUseCase_Factory implements Factory<GetThumbnailsUseCase> {
  private final Provider<Repository> repositoryProvider;

  private final Provider<ThreadExecutor> threadExecutorProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  private final Provider<ThreadExecutor> threadExecutorProvider2;

  private final Provider<PostExecutionThread> postExecutionThreadProvider2;

  public GetThumbnailsUseCase_Factory(Provider<Repository> repositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider,
      Provider<ThreadExecutor> threadExecutorProvider2,
      Provider<PostExecutionThread> postExecutionThreadProvider2) {
    this.repositoryProvider = repositoryProvider;
    this.threadExecutorProvider = threadExecutorProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
    this.threadExecutorProvider2 = threadExecutorProvider2;
    this.postExecutionThreadProvider2 = postExecutionThreadProvider2;
  }

  @Override
  public GetThumbnailsUseCase get() {
    GetThumbnailsUseCase instance = newInstance(repositoryProvider.get(), threadExecutorProvider.get(), postExecutionThreadProvider.get());
    UseCase_MembersInjector.injectThreadExecutor(instance, threadExecutorProvider2.get());
    UseCase_MembersInjector.injectPostExecutionThread(instance, postExecutionThreadProvider2.get());
    return instance;
  }

  public static GetThumbnailsUseCase_Factory create(Provider<Repository> repositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider,
      Provider<ThreadExecutor> threadExecutorProvider2,
      Provider<PostExecutionThread> postExecutionThreadProvider2) {
    return new GetThumbnailsUseCase_Factory(repositoryProvider, threadExecutorProvider, postExecutionThreadProvider, threadExecutorProvider2, postExecutionThreadProvider2);
  }

  public static GetThumbnailsUseCase newInstance(Repository repository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new GetThumbnailsUseCase(repository, threadExecutor, postExecutionThread);
  }
}
