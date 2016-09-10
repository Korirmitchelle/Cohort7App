package com.example.mitchelle.cohort7.utils;

import com.example.mitchelle.cohort7.models.GalleryImage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mitchelle on 9/10/16.
 */
public interface GalleryApi {
    @GET("GalleryImages.json")
    Call<List<GalleryImage>> getStreams();

}
