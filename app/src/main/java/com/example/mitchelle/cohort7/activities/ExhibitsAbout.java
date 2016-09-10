package com.example.mitchelle.cohort7.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mitchelle.cohort7.R;
import com.example.mitchelle.cohort7.models.Animal;
import com.squareup.picasso.Picasso;

/**
 * Created by mitchelle on 9/10/16.
 */
public class ExhibitsAbout extends AppCompatActivity {
   public static final String EXTRA_MEMBERS="Extra_members";
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_deatail);


        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Animal animal=getIntent().getExtras().getParcelable(EXTRA_MEMBERS);
        TextView email=(TextView) findViewById(R.id.email);
        TextView about=(TextView) findViewById(R.id.about);
        ImageView images=(ImageView) findViewById(R.id.images);

        email.setText(animal.getemail());
        about.setText(animal.getAbout());
        Picasso.with(this).load(animal.getpicture()).into(images);
    }
}
