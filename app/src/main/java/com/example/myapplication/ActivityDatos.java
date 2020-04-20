package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityDatos extends AppCompatActivity {

    EditText nombreCompleto, salario, edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        nombreCompleto = (EditText) findViewById(R.id.nombreCompleto);
        salario = (EditText) findViewById(R.id.salario);
        edad = (EditText) findViewById(R.id.edad);
    }

    public void onClickConfirmar(View view){
        String _nombreCompleto = nombreCompleto.getText().toString();
        Double _salario = Double.valueOf(salario.getText().toString());
        int _edad = Integer.valueOf(edad.getText().toString());

        Intent segundaPantalla = new Intent(this, ActivityDatosConfirmar.class);
        segundaPantalla.putExtra("nombreCompleto", _nombreCompleto);
        segundaPantalla.putExtra("salario", _salario);
        segundaPantalla.putExtra("edad", _edad);

        startActivity(segundaPantalla);
    }
}
