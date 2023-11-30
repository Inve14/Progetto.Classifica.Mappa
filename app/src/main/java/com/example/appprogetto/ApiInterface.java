package com.example.appprogetto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("ranking")
    Call<List<User>> getUserInformation(@Query("sid") String sid);
}

