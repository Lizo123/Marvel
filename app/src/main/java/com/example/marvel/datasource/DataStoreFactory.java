package com.example.marvel.datasource;

import com.example.marvel.models.Item;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataStoreFactory {


    @Inject
    CloudDataStore cloudDataStore;

    @Inject
    DataStoreFactory() {
    }

    public Observable<ArrayList<Item>> getAllCharacters(String s)
    {
        return cloudDataStore.getAllItems(s);
    }

    public Observable<ArrayList<Item>> getThumbnails(String url)
    {
        return cloudDataStore.getThumbnails(url);
    }
}
