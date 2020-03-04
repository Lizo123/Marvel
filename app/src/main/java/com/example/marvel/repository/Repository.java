package com.example.marvel.repository;

import com.example.marvel.models.Item;

import java.util.ArrayList;

import io.reactivex.Observable;

/*
Connects Between UseCases(Domain) to DataStoreFactory(Domain)
 */
public interface Repository {

    Observable<ArrayList<Item>> getAllCharacters(String offset);

    Observable<ArrayList<Item>> getThumbnails(String url);
}
