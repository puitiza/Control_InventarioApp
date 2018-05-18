package com.example.apuitiza.control_inventarioapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.apuitiza.control_inventarioapp.R;

public class DetalleProducto extends AppCompatActivity {
    public static final String MOVIMIENTO = "MOVIMIENTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_movimiento);

        showToolbar(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showToolbar(boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return super.onSupportNavigateUp();
    }
}
