// Generated by Dagger (https://dagger.dev).
package com.example.marvel.datasource;

import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataStoreFactory_Factory implements Factory<DataStoreFactory> {
  private final Provider<CloudDataStore> cloudDataStoreProvider;

  public DataStoreFactory_Factory(Provider<CloudDataStore> cloudDataStoreProvider) {
    this.cloudDataStoreProvider = cloudDataStoreProvider;
  }

  @Override
  public DataStoreFactory get() {
    DataStoreFactory instance = newInstance();
    DataStoreFactory_MembersInjector.injectCloudDataStore(instance, cloudDataStoreProvider.get());
    return instance;
  }

  public static DataStoreFactory_Factory create(Provider<CloudDataStore> cloudDataStoreProvider) {
    return new DataStoreFactory_Factory(cloudDataStoreProvider);
  }

  public static DataStoreFactory newInstance() {
    return new DataStoreFactory();
  }
}
