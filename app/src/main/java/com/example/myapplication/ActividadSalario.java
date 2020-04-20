package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActividadSalario extends AppCompatActivity {

    EditText edtSalario, edtEdad;
    TextView tvNombre;

    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_salario);

        edtSalario = (EditText)findViewById(R.id.etextSalario);
        edtEdad = (EditText)findViewById(R.id.edEdad);
        tvNombre = (TextView)findViewById(R.id.tvNombreCompleto);

        Bundle datos = getIntent().getExtras();
        nombre = datos.getString("nombrecompleto");
        tvNombre.setText(nombre);
    }

    public void onClickProcesar(View v){
        Double salario = Double.valueOf(edtSalario.getText().toString());
        int edad = Integer.valueOf(edtEdad.getText().toString());

        Intent retornar = new Intent();

        retornar.putExtra("nombreInt2", nombre);
        retornar.putExtra("salarioInt2", salario);
        retornar.putExtra("edadInt2", edad);

        setResult(RESULT_OK, retornar);
        finish();
    }
}
