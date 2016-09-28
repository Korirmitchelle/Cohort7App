package com.example.mitchelle.cohort7.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.mitchelle.cohort7.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by mitchelle on 9/1/16.
 */
public class MitchMapFragment extends SupportMapFragment  {

    /*private GoogleMap mymap;*/

    public static MitchMapFragment getInstance(){
        MitchMapFragment fragment = new MitchMapFragment();
        return fragment;

    }

    /*@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment supportMapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

        CameraPosition cameraPosition=CameraPosition.builder()
                .zoom(16f)
                .target(new LatLng(-1.300412,36.784596))
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

       *//* LatLng moringa=new LatLng(-1.300412,36.784596);*//*
        mymap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mymap.setTrafficEnabled(true);
        mymap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mymap.getUiSettings().setZoomControlsEnabled(true);
        MarkerOptions options=new MarkerOptions().position(new LatLng(-1.300412,36.784596));




    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mymap=googleMap;

    }*/
}
