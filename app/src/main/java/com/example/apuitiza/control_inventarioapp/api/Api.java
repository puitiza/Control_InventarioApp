package com.example.apuitiza.control_inventarioapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wfloresv on 17/05/2018.
 */

public class Api {

    private static Retrofit retrofit;

    public static Retrofit getApi(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
