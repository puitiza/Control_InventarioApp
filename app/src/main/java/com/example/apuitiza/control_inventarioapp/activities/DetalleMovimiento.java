package com.example.apuitiza.control_inventarioapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.apuitiza.control_inventarioapp.R;

public class DetalleMovimiento extends AppCompatActivity {

    public static final String MOVIMIENTO ="MOVIMIENTO" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_movimiento);
    }
}
