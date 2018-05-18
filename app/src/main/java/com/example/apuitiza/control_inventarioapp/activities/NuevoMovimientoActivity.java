package com.example.apuitiza.control_inventarioapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.apuitiza.control_inventarioapp.R;
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

        groupButton = findViewById(R.id.group_button);
        btnEntrada =  findViewById(R.id.rbtn_entrada);
        btnSalida = findViewById(R.id.rbtn_salida);
        edtProduct = findViewById(R.id.edtproducto);
        groupButton.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(RadioRealButton button, int position) {
                Toast.makeText(getApplicationContext(),"clic"+button.getText(),Toast.LENGTH_SHORT).show();
            }
        });
       /* groupButton.setOnPositionChangedListener(new RadioRealButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(RadioRealButton button, int currentPosition, int lastPosition) {
                Toast.makeText(getApplicationContext(),"Position change"+button.getText(),Toast.LENGTH_SHORT).show();
            }
        });*/
        groupButton.setPosition(0);

        disableKeyBoardEditText(edtProduct);
       edtProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), productoActivity.class);
                startActivity(intent);
            }
        });

    }
    private void disableKeyBoardEditText(MaterialEditText editText) {
        editText.setFocusable(false);
        //editText.setEnabled(false);
        //editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setBackgroundColor(Color.TRANSPARENT);
    }
}
