// Generated by Dagger (https://dagger.dev).
package com.example.marvel.dependencies;

import dagger.internal.Factory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class JobExecutor_Factory implements Factory<JobExecutor> {
  @Override
  public JobExecutor get() {
    return newInstance();
  }

  public static JobExecutor_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static JobExecutor newInstance() {
    return new JobExecutor();
  }

  private static final class InstanceHolder {
    private static final JobExecutor_Factory INSTANCE = new JobExecutor_Factory();
  }
}
