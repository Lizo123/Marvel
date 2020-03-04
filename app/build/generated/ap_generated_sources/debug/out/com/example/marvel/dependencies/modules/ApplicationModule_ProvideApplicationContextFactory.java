// Generated by Dagger (https://dagger.dev).
package com.example.marvel.dependencies.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApplicationModule_ProvideApplicationContextFactory implements Factory<Context> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideApplicationContextFactory(ApplicationModule module) {
    this.module = module;
  }

  @Override
  public Context get() {
    return provideApplicationContext(module);
  }

  public static ApplicationModule_ProvideApplicationContextFactory create(
      ApplicationModule module) {
    return new ApplicationModule_ProvideApplicationContextFactory(module);
  }

  public static Context provideApplicationContext(ApplicationModule instance) {
    return Preconditions.checkNotNull(instance.provideApplicationContext(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
