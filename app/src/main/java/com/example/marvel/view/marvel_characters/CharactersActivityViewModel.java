package com.example.marvel.view.marvel_characters;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marvel.rx.DefaultObserver;
import com.example.marvel.models.Item;
import com.example.marvel.usecases.GetAllCharactersUseCase;

import java.util.ArrayList;

import javax.inject.Inject;


public class CharactersActivityViewModel extends ViewModel {

    @Inject
    GetAllCharactersUseCase getAllCharactersUseCase;
    MutableLiveData<ArrayList<Item>> mutableItems;

    @Inject
    CharactersActivityViewModel(GetAllCharactersUseCase getAllCharactersUseCase) {
        this.getAllCharactersUseCase = getAllCharactersUseCase;
    }

    public void getCharacters(MutableLiveData<ArrayList<Item>> items, String offset) {
        mutableItems = items;
        getAllCharactersUseCase.execute(new getAllCharactersObserver(), offset);
    }


    private final class getAllCharactersObserver extends DefaultObserver<ArrayList<Item>> {
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

    public ArrayList<String> getCharactersNames(ArrayList<Item> items) {
        ArrayList<String> names = new ArrayList<>();
        for (Item it :
                items) {
            names.add(it.getName());

        }
        return names;
    }

    public void destroyDispose() {
        getAllCharactersUseCase.dispose();


    }
}
