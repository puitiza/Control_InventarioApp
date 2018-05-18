package com.example.apuitiza.control_inventarioapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.apuitiza.control_inventarioapp.fragments.MovimientosFragment;
import com.example.apuitiza.control_inventarioapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new MovimientosFragment()).commit();
    }
}
