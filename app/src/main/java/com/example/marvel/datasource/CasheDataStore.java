package com.example.marvel.datasource;

import com.example.marvel.models.Item;
import java.util.ArrayList;
import io.reactivex.Observable;


/*
 * Used for getting data from cashe
 */
public class CasheDataStore implements DataStore {


    @Override
    public Observable<ArrayList<Item>> getAllItems(String offset) {
        return null;
    }

    @Override
    public Observable<ArrayList<Item>> getThumbnails(String url) {
        return null;
    }
}
