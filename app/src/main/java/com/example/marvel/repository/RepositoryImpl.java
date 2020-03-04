package com.example.marvel.repository;

import com.example.marvel.datasource.DataStoreFactory;
import com.example.marvel.models.Item;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RepositoryImpl implements Repository {

    @Inject
    DataStoreFactory dataStoreFactory;


    @Inject
    public RepositoryImpl() {
    }

    @Override
    public Observable<ArrayList<Item>> getAllCharacters(String offset) {
        return dataStoreFactory.getAllCharacters(offset);
    }

    @Override
    public Observable<ArrayList<Item>> getThumbnails(String url) {
        return dataStoreFactory.getThumbnails(url);
    }
}
