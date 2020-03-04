package com.example.marvel.datasource;

import com.example.marvel.models.Item;
import java.util.ArrayList;
import io.reactivex.Observable;

/*
 * Interface for DataStore Classes (Disk , Network)
 */
public interface DataStore {

    Observable<ArrayList<Item>> getAllItems(String offset);

    Observable<ArrayList<Item>> getThumbnails(String url);
}
