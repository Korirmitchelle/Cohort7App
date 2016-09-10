package com.example.mitchelle.cohort7.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;


import com.example.mitchelle.cohort7.activities.ExhibitsAbout;
import com.example.mitchelle.cohort7.adapters.ExhibitsAdapter;
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

    private ExhibitsAdapter mAdapter;
    public static ExhibitsListFragment getInstance(){
        ExhibitsListFragment fragment = new ExhibitsListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListShown(false);
        mAdapter=new ExhibitsAdapter(getActivity(),0);

Retrofit retrofit=new Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/Korirmitchelle/6d0f79ae9d689a995fb043745a458114/raw/aed785f9f4beb65150671a913185ea5ee2030a6b/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();



        AnimalApiInterface animalApiInterface=retrofit.create(AnimalApiInterface.class);
        animalApiInterface.getStreams().enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> animals, Response<List<Animal>> response) {
                if (animals==null|| !response.isSuccessful()) {
                    return;
                }

                for (Animal animal:response.body()) {
                    mAdapter.add(animal);
                }

                mAdapter.notifyDataSetChanged();
                setListAdapter(mAdapter);
                setListShown(true);

            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {

            }  });
        




    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent=new Intent(getActivity(), ExhibitsAbout.class);
       /* pass info from list to new activity*/
        intent.putExtra(ExhibitsAbout.EXTRA_MEMBERS,mAdapter.getItem(position));
        startActivity(intent);
    }
}



