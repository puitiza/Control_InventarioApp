package com.example.apuitiza.control_inventarioapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.apuitiza.control_inventarioapp.R;
import com.example.apuitiza.control_inventarioapp.models.Producto;
import com.rengwuxian.materialedittext.MaterialEditText;

import co.ceryle.radiorealbutton.RadioRealButton;
import co.ceryle.radiorealbutton.RadioRealButtonGroup;

public class NuevoMovimientoActivity extends AppCompatActivity {

    RadioRealButton btnEntrada, btnSalida;
    RadioRealButtonGroup groupButton;
    MaterialEditText edtProduct;
    Button btn_GuardarMov ;
    Producto prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_movimiento);

        showToolbar("Nuevo movimiento",true);

        groupButton = findViewById(R.id.group_button);
        btnEntrada =  findViewById(R.id.rbtn_entrada);
        btnSalida = findViewById(R.id.rbtn_salida);
        edtProduct = findViewById(R.id.edtproducto);
        btn_GuardarMov = findViewById(R.id.btn_GuardarMov);
        groupButton.setPosition(0);

        disableKeyBoardEditText(edtProduct);
       edtProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), productoActivity.class);
                startActivityForResult(intent, 1);
            }
        });
       btn_GuardarMov.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(NuevoMovimientoActivity.this);
               if(groupButton.getPosition()==0){
                   builder.setTitle("Confirmación");
                   builder.setMessage("¿Esta seguro que desea agregar: "+prod.getStock()+" unidades al stock");
               }if(groupButton.getPosition()==1){
                   builder.setTitle("Confirmación");
                   builder.setMessage("¿Esta seguro que desea retirar: "+prod.getStock()+" unidades al stock");
               }
               builder.show();
           }
       });

    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }



    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                prod = (Producto) data.getSerializableExtra("producto");

                edtProduct.setText(prod.getNombre());
            }
        }
    }

    private void disableKeyBoardEditText(MaterialEditText editText) {
            editText.setFocusable(false);
            //editText.setEnabled(false);
            //editText.setCursorVisible(false);
            editText.setKeyListener(null);
            editText.setBackgroundColor(Color.TRANSPARENT);
    }
}
