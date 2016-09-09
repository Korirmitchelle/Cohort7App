package com.example.mitchelle.cohort7.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;


import com.example.mitchelle.cohort7.models.Animal;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.mitchelle.cohort7.R;
import com.example.mitchelle.cohort7.utils.AnimalApiInterface;




  /*Created by mitchelle on 9/1/16.*/

public class ExhibitsListFragment  extends ListFragment {
    public static ExhibitsListFragment getInstance(){
        ExhibitsListFragment fragment = new ExhibitsListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

Retrofit retrofit=new Retrofit.Builder()
        .baseUrl(String.valueOf(R.string.exhibits_feed)+("/"))
        .build();

        AnimalApiInterface animalApiInterface=retrofit.create(AnimalApiInterface.class);

        animalApiInterface.getStreams(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
                if (call==null|| call.isExecuted())
                return;
                /*for (Animal animal:call){
                    Log.e("Cohort",animal.getName());
                }*/
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {
             Log.e("Cohort","Retrofit error: ");
            }
        });
    }
}



