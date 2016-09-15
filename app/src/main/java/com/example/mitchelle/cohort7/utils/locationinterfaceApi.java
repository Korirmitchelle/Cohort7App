package com.example.mitchelle.cohort7.utils;

import com.example.mitchelle.cohort7.models.location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mitchelle on 9/15/16.
 */
public interface locationinterfaceApi {

    @GET("location.json")
    Call<List<location>> getStreams();

}
