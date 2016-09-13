package com.example.mitchelle.cohort7.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.mitchelle.cohort7.R;
import com.example.mitchelle.cohort7.activities.GalleryDetailActivity;
import com.example.mitchelle.cohort7.adapters.GalleryImageAdapter;
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
public class  GalleryFragment extends Fragment implements AdapterView.OnItemClickListener{
    private GridView myGridview;  /*creating objects to represent adapter and gridview*/
    private GalleryImageAdapter myAdapter;


    public static GalleryFragment getInstance(){   /*to pass new values to fragment*/
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

/*
        return inflater.inflate(R.layout.fragment_gallery_grid,null);
*/
View view=inflater.inflate(R.layout.fragment_gallery_grid,container,false);
        myGridview=(GridView) view.findViewById(R.id.grid);

        myGridview.setOnItemClickListener(this);

        myGridview.setDrawSelectorOnTop(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
myAdapter=new GalleryImageAdapter(getActivity(),0);
        myGridview.setAdapter(myAdapter);
/*
        populate adapter
*/
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/Korirmitchelle/882b88df934bf05767d5ca6edd626f0e/raw/2859e2c137c91e3c39cc1d9d8b14980c38d65290/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GalleryApi galleryApi=retrofit.create(GalleryApi.class);
        galleryApi.getStreams().enqueue(new Callback<List<GalleryImage>>() {
            @Override
            public void onResponse(Call<List<GalleryImage>> call, Response<List<GalleryImage>> response) {
                if (call==null||!response.isSuccessful())
                    return;
                for (GalleryImage calls:response.body()){
                    Log.e("Cohort",calls.getThumbnail());
                myAdapter.add(calls);}

                myAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<GalleryImage>> call, Throwable t) {

            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        GalleryImage image= (GalleryImage) parent.getItemAtPosition(position);
        Intent intent=new Intent(getActivity(), GalleryDetailActivity.class);
        intent.putExtra(GalleryDetailActivity.EXTRA_Image,image.getImage());
        intent.putExtra(GalleryDetailActivity.EXTRA_CAPTON,image.getCaption());
        startActivity(intent);

    }
}
