package com.example.mitchelle.cohort7.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by mitchelle on 9/1/16.
 */
public class  GalleryFragment extends Fragment {
    public static GalleryFragment getInstance(){   /*to pass new values to fragment*/
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }
}
