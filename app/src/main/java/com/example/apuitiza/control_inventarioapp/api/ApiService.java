package com.example.apuitiza.control_inventarioapp.api;

import com.example.apuitiza.control_inventarioapp.models.Movimiento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wfloresv on 17/05/2018.
 */

public interface ApiService {

        @GET("users/repos")
        Call<List<Movimiento>> getMovimientos();

}
