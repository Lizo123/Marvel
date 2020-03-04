package com.example.marvel.datasource;

import android.content.Context;
import com.example.marvel.models.APIResponse;
import com.example.marvel.models.Item;
import com.example.marvel.network.APIClient;
import com.example.marvel.network.APIInterface;
import com.example.marvel.network.AppConstants;
import java.util.ArrayList;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
* Implementation of Interface DataStore for Network
 */
public class CloudDataStore implements DataStore {


    private APIInterface apiInterface;


    @Inject
    CloudDataStore(Context context) {
        this.apiInterface = APIClient.getClient(context).create(APIInterface.class);

    }


    /**
     *  To get All Characters
     */
    @Override
    public Observable<ArrayList<Item>> getAllItems(String offset) {
        return apiInterface.getAllCharacters(AppConstants.getTs(), AppConstants.getApiKey(), AppConstants.getHash(), offset).map(new Function<APIResponse, ArrayList<Item>>() {
            @Override
            public ArrayList<Item> apply(APIResponse apiResponse) throws Exception {
                return apiResponse.getData().getResults();
            }
        });
    }

    /**
     * To get pictures of comics, series,events
     */
    @Override
    public Observable<ArrayList<Item>> getThumbnails(String url) {
        return apiInterface.getThumbnails(url).map(new Function<APIResponse, ArrayList<Item>>() {
            @Override
            public ArrayList<Item> apply(APIResponse apiResponse) throws Exception {
                return apiResponse.getData().getResults();
            }
        });
    }
}
