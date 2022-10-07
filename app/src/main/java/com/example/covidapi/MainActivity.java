package com.example.covidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private MyApi myapi;
    private String BaseUrl = "https://disease.sh/v3/covid-19/";
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        displayRetrofitData();
    }

    private void displayRetrofitData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myapi = retrofit.create(MyApi.class);
        Call<ArrayList<Post>> ArrayListCall=myapi.callModel();
        ArrayListCall.enqueue(new Callback<ArrayList<Post>>() {

            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
//                modelArrayList = response.body();
                if (!response.isSuccessful()){
                    System.out.println("berhasil");
                    Toast.makeText(MainActivity.this,response.code(),Toast.LENGTH_SHORT);
                    System.out.println("berhasil");
                    return;

                }
                ArrayList<Post> postArrayList = response.body();
                PostAdapter postAdapter = new PostAdapter(postArrayList,MainActivity.this);
                rv.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Gagal untuk mengambil data",Toast.LENGTH_SHORT);
            }
        });
    }

}