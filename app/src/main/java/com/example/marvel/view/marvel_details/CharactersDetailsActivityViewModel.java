package com.example.marvel.view.marvel_details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marvel.network.AppConstants;
import com.example.marvel.rx.DefaultObserver;
import com.example.marvel.models.Item;
import com.example.marvel.usecases.GetThumbnailsUseCase;

import java.util.ArrayList;

import javax.inject.Inject;

class CharactersDetailsActivityViewModel extends ViewModel {

    @Inject
    GetThumbnailsUseCase getThumbnailsUseCase;
    private MutableLiveData<ArrayList<Item>> mutableItems;

    @Inject
    CharactersDetailsActivityViewModel(GetThumbnailsUseCase getComicsThumbnailsUseCase) {
        this.getThumbnailsUseCase = getComicsThumbnailsUseCase;
    }

    void getComics(MutableLiveData<ArrayList<Item>> items, String url)
    {
        mutableItems = items;
        getThumbnailsUseCase.execute(new getComicsThumbnailsbserver(),url);
    }

    void getSeries(MutableLiveData<ArrayList<Item>> items, String url)
    {
        mutableItems = items;
        getThumbnailsUseCase.execute(new getSeriesThumbnailsbserver(),url);
    }

    void getEvents(MutableLiveData<ArrayList<Item>> items, String url)
    {
        mutableItems = items;
        getThumbnailsUseCase.execute(new getEventsThumbnailsbserver(),url);
    }

    /**
     * Setup url for api
     * @param url
     * @return url
     */
    String setURL(String url)
    {
        return url+"?ts="+ AppConstants.getTs()+"&apikey="+AppConstants.getApiKey()+"&&hash="+AppConstants.getHash()+"&offset=0";
    }

    void destroyDispose() {
        getThumbnailsUseCase.dispose();
    }


    private final class getComicsThumbnailsbserver extends DefaultObserver<ArrayList<Item>> {
        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(ArrayList<Item> items) {

            mutableItems.setValue(items);
        }
    }
    private final class getSeriesThumbnailsbserver extends DefaultObserver<ArrayList<Item>> {
        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(ArrayList<Item> items) {

            mutableItems.setValue(items);
        }
    }
    private final class getEventsThumbnailsbserver extends DefaultObserver<ArrayList<Item>> {
        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(ArrayList<Item> items) {

            mutableItems.setValue(items);
        }
    }
}
