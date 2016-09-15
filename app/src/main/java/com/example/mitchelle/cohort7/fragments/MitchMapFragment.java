package com.example.mitchelle.cohort7.fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.mitchelle.cohort7.models.Location;
import com.example.mitchelle.cohort7.utils.LocationinterfaceApi;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mitchelle on 9/1/16.
 */
public class MitchMapFragment extends SupportMapFragment {
    public static MitchMapFragment getInstance(){
        MitchMapFragment fragment = new MitchMapFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/Korirmitchelle/25b5f5031899623a387dc0f4fe22943c/raw/54e408494a80996a5dab07c4f481758710094311/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        LocationinterfaceApi locationinterfaceApi=retrofit.create(LocationinterfaceApi.class);
        locationinterfaceApi.getStreams(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                for (Location locations:response.body()){
                    Log.e("Cohort", String.valueOf(locations.getLatitude()));
                }

            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {

            }
        });
    }
}
