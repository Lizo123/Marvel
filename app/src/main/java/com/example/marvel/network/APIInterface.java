package com.example.marvel.network;

import com.example.marvel.models.APIResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIInterface {

    @GET("characters")
    Observable<APIResponse> getAllCharacters( @Query("ts") String ts,@Query("apikey") String apiKey,@Query("hash") String hash,@Query("offset") String offset);

    @GET
    Observable<APIResponse> getThumbnails(@Url String url);
}
