package com.example.mitchelle.cohort7.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;

import com.example.mitchelle.cohort7.R;
import com.example.mitchelle.cohort7.models.Animal;
import com.example.mitchelle.cohort7.models.GalleryImage;
import com.example.mitchelle.cohort7.utils.GalleryApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mitchelle on 9/1/16.
 */
public class  GalleryFragment extends ListFragment {
    public static GalleryFragment getInstance(){   /*to pass new values to fragment*/
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(String.valueOf(R.string.gallery_feed))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GalleryApi galleryApi=retrofit.create(GalleryApi.class);
        galleryApi.getStreams().enqueue(new Callback<List<GalleryImage>>() {
            @Override
            public void onResponse(Call<List<GalleryImage>> call, Response<List<GalleryImage>> response) {
                if (call==null||!response.isSuccessful())
                    return;
                for (GalleryImage calls:response.body())
                    Log.e("Cohort",calls.getThumbnail());
            }

            @Override
            public void onFailure(Call<List<GalleryImage>> call, Throwable t) {

            }
        });
        /*galleryApi.getStreams().enqueue(new Callback<List<GalleryImage>>() {
            @Override
            public void onResponse(Call<List<GalleryImage>> img, Response<List<GalleryImage>> response) {
                if (img==null||!response.isSuccessful()){

                    return;
                }
                for (GalleryImage im:response.body()){
            }

            @Override
            public void onFailure(Call<List<GalleryImage>> img, Throwable t) {

            }
        };
*/


    }
}
