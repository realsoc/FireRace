package com.example.realsoc.firerace;

import com.example.realsoc.firerace.model.DriverTable;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by realsoc on 15/06/17.
 */
// Interface for Retrofit
public interface ErgastAPI {
    @GET("f1/current/last/drivers.json")
    Call<DriverTable> getLastRace();
}
