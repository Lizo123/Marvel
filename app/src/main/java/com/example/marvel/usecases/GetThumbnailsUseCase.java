package com.example.marvel.usecases;

import com.example.marvel.rx.PostExecutionThread;
import com.example.marvel.rx.ThreadExecutor;
import com.example.marvel.models.Item;
import com.example.marvel.repository.Repository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
/*
get thumbnails for comics,series,events
 */
public class GetThumbnailsUseCase extends UseCase<ArrayList<Item>,String> {

    private Repository repository;

    @Inject
    public GetThumbnailsUseCase(Repository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<ArrayList<Item>> buildUseCaseObservable(String s) {
        return repository.getThumbnails(s);
    }
}
