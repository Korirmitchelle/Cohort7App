package com.example.mitchelle.cohort7.utils;

import com.example.mitchelle.cohort7.models.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by mitchelle on 9/15/16.
 */
public interface LocationinterfaceApi {

    @GET("Location.json")
    Call<List<Location>> getStreams(Callback<List<Location>> callback);

}
