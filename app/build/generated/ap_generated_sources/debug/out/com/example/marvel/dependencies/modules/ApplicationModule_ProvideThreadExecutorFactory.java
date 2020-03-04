// Generated by Dagger (https://dagger.dev).
package com.example.marvel.dependencies.modules;

import com.example.marvel.rx.ThreadExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApplicationModule_ProvideThreadExecutorFactory implements Factory<ThreadExecutor> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideThreadExecutorFactory(ApplicationModule module) {
    this.module = module;
  }

  @Override
  public ThreadExecutor get() {
    return provideThreadExecutor(module);
  }

  public static ApplicationModule_ProvideThreadExecutorFactory create(ApplicationModule module) {
    return new ApplicationModule_ProvideThreadExecutorFactory(module);
  }

  public static ThreadExecutor provideThreadExecutor(ApplicationModule instance) {
    return Preconditions.checkNotNull(instance.provideThreadExecutor(), "Cannot return null from a non-@Nullable @Provides method");
  }
}