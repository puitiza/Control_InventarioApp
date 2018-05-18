package com.example.apuitiza.control_inventarioapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_movimiento);

        showToolbar("Nuevo movimiento",true);

        groupButton = findViewById(R.id.group_button);
        btnEntrada =  findViewById(R.id.rbtn_entrada);
        btnSalida = findViewById(R.id.rbtn_salida);
        edtProduct = findViewById(R.id.edtproducto);
        /*groupButton.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(RadioRealButton button, int position) {

            }
        });*/
        groupButton.setPosition(0);

        disableKeyBoardEditText(edtProduct);
       edtProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), productoActivity.class);
                startActivityForResult(intent, 1);
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
                Producto p = (Producto) data.getSerializableExtra("producto");
                edtProduct.setTag(p);
                edtProduct.setText(p.getNombre());
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
