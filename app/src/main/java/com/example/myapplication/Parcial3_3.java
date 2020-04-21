package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import utilities.Notify;

public class Parcial3_3 extends AppCompatActivity {

    TextView txtNumero1, txtNumero2;
    RadioButton rbtnSumar, rbtnRestar, rbtnMultiplicar, rbtnDividir;
    int numero1, numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcial3_3);

        txtNumero1 = (TextView) findViewById(R.id.textNumero1);
        txtNumero2 = (TextView) findViewById(R.id.textNumero2);
        rbtnSumar = (RadioButton) findViewById(R.id.tbtnSumar);
        rbtnRestar = (RadioButton) findViewById(R.id.rbtnRestar);
        rbtnMultiplicar = (RadioButton) findViewById(R.id.rbtnMultiplicar);
        rbtnDividir = (RadioButton) findViewById(R.id.rbtnDividir);

        Bundle datos = getIntent().getExtras();
        numero1 = datos.getInt("numero1", 0);
        numero2 = datos.getInt("numero2", 0);

        txtNumero1.setText("Número 1: " + numero1);
        txtNumero2.setText("Número 2: " + numero2);
    }

    public void onClickProcesar(View view){
        Boolean ejecutado = true;
        Double resultado = 0.0;
        String operacion = "";

        if (rbtnSumar.isChecked()){
            resultado = Double.valueOf(numero1 + numero2);
            operacion = "SUMAR";
        } else if (rbtnRestar.isChecked()){
            resultado = Double.valueOf(numero1 - numero2);
            operacion = "RESTAR";
        } else if (rbtnMultiplicar.isChecked()){
            resultado = Double.valueOf(numero1 * numero2);
            operacion = "MULTIPLICAR";
        } else if (rbtnDividir.isChecked()){
            operacion = "DIVIDIR";
            if (numero2 == 0){
                Notify.Show(this,"No es permitido dividir entre cero...", Toast.LENGTH_LONG);
            }else{
                resultado = Double.valueOf(numero1 / numero2);
            }
        } else {
            ejecutado = false;
            Notify.Show(this,"Debe seleccionar una operación...", Toast.LENGTH_SHORT);
        }

        if (ejecutado == true){
            Intent retornar = new Intent();

            retornar.putExtra("resultado", resultado);
            retornar.putExtra("operacion", operacion);

            setResult(RESULT_OK, retornar);
            finish();
        }
    }
}
