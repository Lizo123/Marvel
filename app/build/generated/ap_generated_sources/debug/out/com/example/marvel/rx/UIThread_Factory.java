// Generated by Dagger (https://dagger.dev).
package com.example.marvel.rx;

import dagger.internal.Factory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UIThread_Factory implements Factory<UIThread> {
  @Override
  public UIThread get() {
    return newInstance();
  }

  public static UIThread_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static UIThread newInstance() {
    return new UIThread();
  }

  private static final class InstanceHolder {
    private static final UIThread_Factory INSTANCE = new UIThread_Factory();
  }
}
