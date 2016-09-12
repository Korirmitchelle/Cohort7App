package com.example.mitchelle.cohort7.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mitchelle.cohort7.R;
import com.squareup.picasso.Picasso;

/**
 * Created by mitchelle on 9/12/16.
 */
public class GalleryDetailActivity extends AppCompatActivity{
    public static final String EXTRA_Image="extra image";
    public static final String EXTRA_CAPTON="extra_caption";

    private TextView myCaptionTextView;
    private ImageView myImageView;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_gallery_detail);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myCaptionTextView=(TextView) findViewById(R.id.caption);
        myImageView=(ImageView) findViewById(R.id.imagesss);

        if (getIntent()!=null&&getIntent().getExtras()!=null){
            if (getIntent().getExtras().containsKey(EXTRA_Image)){
                Picasso.with(this).load(getIntent().getExtras().getString(EXTRA_Image)).into(myImageView);
            }

            if (getIntent().getExtras().containsKey(EXTRA_CAPTON)){
                myCaptionTextView.setText(getIntent().getExtras().getString(EXTRA_CAPTON));
            }
        }
    }
}
