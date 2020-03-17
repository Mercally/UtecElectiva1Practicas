package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BotonesRadioCheck extends AppCompatActivity {

    RadioButton radioButtonRojo, radioButtonAzul, radioButtonBlanco, radioButtonNegro;
    CheckBox checkBoxZapatos, checkBoxCamisas, checkBoxPantalones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_radio_check);

        // Enlazando elementos UI XML con Java:
        radioButtonRojo = (RadioButton) findViewById(R.id.radioButtonRojo);
        radioButtonAzul = (RadioButton) findViewById(R.id.radioButtonAzul);
        radioButtonBlanco = (RadioButton) findViewById(R.id.radioButtonBlanco);
        radioButtonNegro = (RadioButton) findViewById(R.id.radioButtonNegro);

        checkBoxZapatos = (CheckBox) findViewById(R.id.checkBoxZapatos);
        checkBoxCamisas = (CheckBox) findViewById(R.id.checkBoxCamisas);
        checkBoxPantalones = (CheckBox) findViewById(R.id.checkBoxPantalones);
    }

    /**
     * Método para adjuntar a evento de botón para revisar.
     * @param view Vista actual.
     */
    public void btnRevisarOnclick(View view){
        String colorSeleccionado = "";

        if (radioButtonRojo.isChecked()){
            colorSeleccionado = "Rojo";
        }
        if (radioButtonAzul.isChecked()){
            colorSeleccionado = "Azul";
        }
        if (radioButtonBlanco.isChecked()){
            colorSeleccionado = "Blanco";
        }
        if (radioButtonNegro.isChecked()){
            colorSeleccionado = "Negro";
        }

        Toast.makeText(this, "El color seleccionado es: " + colorSeleccionado, Toast.LENGTH_SHORT).show();

        int intCantidadSeleccionados = 0;
        String strCategoriasSeleccionadas = "";

        if (checkBoxZapatos.isChecked()){
            strCategoriasSeleccionadas += "Zapatos, ";
            intCantidadSeleccionados++;
        }
        if (checkBoxCamisas.isChecked()){
            strCategoriasSeleccionadas += "Camisas, ";
            intCantidadSeleccionados++;
        }
        if (checkBoxPantalones.isChecked()){
            strCategoriasSeleccionadas += "Pantalones, ";
            intCantidadSeleccionados++;
        }

        Toast.makeText(this, "Categorías seleccionadas: " + strCategoriasSeleccionadas + ". (" + intCantidadSeleccionados + ") seleccionados.", Toast.LENGTH_SHORT).show();
    }

    /**
     * Método para adjuntar a evento de botón para salir de la aplicación.
     * @param view Vista actual.
     */
    public void btnSalirOnClick(View view){
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * Método para adjuntar a evento de botón para ir al inicio.
     * @param view Vista actual.
     */
    public void btnIrAlInicioOnClick(View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}
