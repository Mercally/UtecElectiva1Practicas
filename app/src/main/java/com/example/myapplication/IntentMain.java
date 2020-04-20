package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import utilities.Notify;

public class IntentMain extends AppCompatActivity {

    RadioButton radioPantalla1, radioPantalla2, radioPantalla3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        radioPantalla1 = (RadioButton) findViewById(R.id.iniciarPantalla1);
        radioPantalla2 = (RadioButton) findViewById(R.id.iniciarPantalla2);
        radioPantalla3 = (RadioButton) findViewById(R.id.iniciarPantalla3);
    }

    public void onClickIniciarPantalla(View view){
        Intent pantalla = null;

        if (radioPantalla1.isChecked()){
            pantalla = new Intent(this, Pantalla1.class);
        }else if(radioPantalla2.isChecked()){
            pantalla = new Intent(this, Pantalla2.class);
        }else if(radioPantalla3.isChecked()){
            pantalla = new Intent(this, Pantalla3.class);
        }else{
            Notify.Show(this, "Por favor seleccione una opción.", Toast.LENGTH_SHORT);
        }
        if (pantalla != null){
            startActivity(pantalla);
        }
    }
}
