package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActividadNombre extends AppCompatActivity {

    EditText edtNombre;
    TextView tvResulado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_nombre);

        edtNombre = (EditText) findViewById(R.id.edtNombreCompleto);
        tvResulado = (TextView) findViewById(R.id.textViewResultado);
    }

    @Override
    public void onActivityResult(int codActividad, int codResultado, Intent datos){

        String nombre;
        Double salario;
        int edad;

        if (codActividad == 1){

            nombre = datos.getStringExtra("nombreInt2");
            salario = datos.getDoubleExtra("salarioInt2", 0.0);
            edad = datos.getIntExtra("edadInt2", 0);

            Double aumento = 0.0;
            if (edad <= 20){
                aumento = salario * 1.0;
            }
            if (edad <= 30){
                aumento = salario * 1.20;
            }else{
                aumento = salario * 1.30;
            }

            tvResulado.setText("Su nombre es: " + nombre + ", nuevo salario es: " + String.valueOf(aumento) + " y su edad: " + String.valueOf(edad));
        }
    }

    public void invocarNuevaActivity(View v){
        String nombreCompleto = edtNombre.getText().toString();
        Intent segundaActivity = new Intent(this, ActividadSalario.class);

        segundaActivity.putExtra("nombrecompleto", nombreCompleto);
        startActivityForResult(segundaActivity, 1);
    }
}
