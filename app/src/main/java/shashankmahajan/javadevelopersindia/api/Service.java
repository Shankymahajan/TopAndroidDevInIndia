package shashankmahajan.javadevelopersindia.api;

import retrofit2.Call;
import retrofit2.http.GET;
import shashankmahajan.javadevelopersindia.model.ItemResponse;

/**
 * Created by shashankmahajan on 27/03/17.
 */

public interface Service {

    @GET("/search/users?q=language:android+location:india")
    Call<ItemResponse> getItem();



}

