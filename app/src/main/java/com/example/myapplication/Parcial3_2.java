package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utilities.Notify;

public class Parcial3_2 extends AppCompatActivity {

    EditText edtNumero1, edtNumero2;
    TextView txtOperacion, txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcial3_2);

        edtNumero1 = (EditText)findViewById(R.id.etNumero1);
        edtNumero2 = (EditText)findViewById(R.id.etNumero2);
        txtOperacion = (TextView) findViewById(R.id.txtOperacion);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
    }

    public void onClickOperaciones(View view){

        String strNumero1 = edtNumero1.getText().toString();
        String strNumero2 = edtNumero2.getText().toString();

        if (TextUtils.isEmpty(strNumero1)){
            Notify.Show(this, "Ingrese el número 1...", Toast.LENGTH_SHORT);
            edtNumero1.setError("Ingrese el número 1");
            edtNumero1.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strNumero2)){
            Notify.Show(this, "Ingrese el número 2...", Toast.LENGTH_SHORT);
            edtNumero2.setError("Ingrese el número 2");
            edtNumero2.requestFocus();
            return;
        }

        int numero1 = Integer.valueOf(strNumero1);
        int numero2 = Integer.valueOf(strNumero2);

        // Validaciones
        if (numero1 <= 0){
            Notify.Show(this, "Ingrese un número mayor a cero en el campo Número 1...", Toast.LENGTH_SHORT);
            edtNumero1.setError("Ingrese un número mayor a cero");
            edtNumero1.requestFocus();
            return;
        }

        if (numero2 <= 0){
            Notify.Show(this, "Ingrese un número mayor a cero en el campo Número 2...", Toast.LENGTH_SHORT);
            edtNumero2.setError("Ingrese un número mayor a cero");
            edtNumero2.requestFocus();
            return;
        }

        Intent segundaPantalla = new Intent(this, Parcial3_3.class);
        segundaPantalla.putExtra("numero1", numero1);
        segundaPantalla.putExtra("numero2", numero2);

        startActivityForResult(segundaPantalla,1);
    }

    @Override
    public void onActivityResult(int codActividad, int codResultado, Intent datos){
        if (codActividad == 1){
            String operacion = datos.getStringExtra("operacion");
            Double resultado = datos.getDoubleExtra("resultado", 0.0);

            txtOperacion.setText("Operación: " + operacion);
            txtResultado.setText("Resultado: " + resultado);
        }
    }
}
