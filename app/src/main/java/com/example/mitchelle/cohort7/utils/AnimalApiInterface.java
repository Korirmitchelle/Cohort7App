

package com.example.mitchelle.cohort7.utils;



import com.example.mitchelle.cohort7.models.Animal;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;


/*
  Created by mitchelle on 9/2/16.
 */

public interface AnimalApiInterface {
    @GET("Exhibits.json")
    Call<List<Animal>> getStreams();


   /*void getStreams(Callback<List<Animal>> callback);

*/
}

