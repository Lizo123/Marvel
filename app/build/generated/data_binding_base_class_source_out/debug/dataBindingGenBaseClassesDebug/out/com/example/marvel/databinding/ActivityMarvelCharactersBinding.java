// Generated by data binding compiler. Do not edit!
package com.example.marvel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.marvel.R;
import com.example.marvel.view.marvel_characters.CharactersActivity;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMarvelCharactersBinding extends ViewDataBinding {
  @NonNull
  public final ImageView cart;

  @NonNull
  public final ListView listView;

  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected CharactersActivity mActivity;

  protected ActivityMarvelCharactersBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView cart, ListView listView, RecyclerView recycler,
      Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cart = cart;
    this.listView = listView;
    this.recycler = recycler;
    this.toolbar = toolbar;
  }

  public abstract void setActivity(@Nullable CharactersActivity activity);

  @Nullable
  public CharactersActivity getActivity() {
    return mActivity;
  }

  @NonNull
  public static ActivityMarvelCharactersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_marvel_characters, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMarvelCharactersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMarvelCharactersBinding>inflateInternal(inflater, R.layout.activity_marvel_characters, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMarvelCharactersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_marvel_characters, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMarvelCharactersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMarvelCharactersBinding>inflateInternal(inflater, R.layout.activity_marvel_characters, null, false, component);
  }

  public static ActivityMarvelCharactersBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityMarvelCharactersBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityMarvelCharactersBinding)bind(component, view, R.layout.activity_marvel_characters);
  }
}
