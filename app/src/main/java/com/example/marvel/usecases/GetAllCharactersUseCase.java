package com.example.marvel.usecases;

import com.example.marvel.rx.PostExecutionThread;
import com.example.marvel.rx.ThreadExecutor;
import com.example.marvel.models.Item;
import com.example.marvel.repository.Repository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
/*
A useCase for getting all characters
 */
public class GetAllCharactersUseCase extends UseCase<ArrayList<Item>,String> {

    private Repository repository;

    

    @Inject
    public GetAllCharactersUseCase(Repository repository,ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<ArrayList<Item>> buildUseCaseObservable(String s) {
        return repository.getAllCharacters(s);
    }
}
