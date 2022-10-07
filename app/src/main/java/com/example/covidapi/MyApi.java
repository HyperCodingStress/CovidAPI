package com.example.covidapi;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("all")
    Call<ArrayList<Post>> callModel();
}
