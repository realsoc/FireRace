package com.example.realsoc.firerace;

import android.util.Log;

import com.example.realsoc.firerace.model.DriverTable;
import com.example.realsoc.firerace.model.DriverTableDeserializer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by realsoc on 15/06/17.
 */
// Helper for ergast api
public class APIHelper implements Callback<DriverTable> {
    static final String API_URL = "http://ergast.com/api/";
    // GET Call for last race
    public void process(){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").setLenient().registerTypeAdapter(DriverTable.class,new DriverTableDeserializer()).create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ErgastAPI ergastAPI = retrofit.create(ErgastAPI.class);
        Call<DriverTable> call = ergastAPI.getLastRace();
        call.enqueue(this);
    }
    // Receive response, if ok puts in DB
    @Override
    public void onResponse(Call<DriverTable> call, Response<DriverTable> response) {
        if(response.isSuccessful()){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DriverTable lastRace = response.body();
            DatabaseReference myRef = database.getReference("lastRace");
            myRef.setValue(lastRace);
        }
        else{
            try {
                Log.d("API_HELPER",response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<DriverTable> call, Throwable t) {
        t.printStackTrace();
    }
}
