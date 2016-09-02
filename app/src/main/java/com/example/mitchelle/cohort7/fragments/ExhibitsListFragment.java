package com.example.mitchelle.cohort7.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;

import com.example.mitchelle.cohort7.models.Animal;
import com.example.mitchelle.cohort7.utils.AnimalApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.example.mitchelle.cohort7.R;



/**
 * Created by mitchelle on 9/1/16.
 */
public class ExhibitsListFragment  extends ListFragment {
    public static ExhibitsListFragment getInstance(){
        ExhibitsListFragment fragment = new ExhibitsListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String exhibits_feedwithbslash = getResources().getString(R.string.exhibits_feed)+"/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(exhibits_feedwithbslash)
/*
                .addConverterFactory(GsonConverterFactory.create())
*/
                .build();
        AnimalApiInterface animalApiInterface = retrofit.create(AnimalApiInterface.class);
        animalApiInterface.getStreams(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {

            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {

              /*   Log.e("Cohort error")*/
            }
        });

    }
}
