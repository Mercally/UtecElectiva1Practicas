package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Actividad principal de menú de prácticas.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método para adjuntar a evento de botón para ir a ejercicio de radio buttons y checkbox.
     * @param view Vista actual.
     */
    public void btnRadioCheckOnclick(View view){
        Intent botonesRadioCheck = new Intent(this, BotonesRadioCheck.class);
        startActivity(botonesRadioCheck);
    }

    /**
     * Método para adjuntar a evento de botón para ir a parcial dos.
     * @param view Vista actual.
     */
    public void btnParcialDosOnClick(View view){
        Intent parcialDos = new Intent(this, ParcialDos.class);
        startActivity(parcialDos);
    }

    /**
     * Método para adjuntar a evento de botón para ir a parcial dos.
     * @param view Vista actual.
     */
    public void btnLoginOnClick(View view){
        Intent login = new Intent(this, Login.class);
        startActivity(login);
    }

    public void btnEjercicioIntents(View view){
        Intent intents = new Intent(this, IntentMain.class);
        startActivity(intents);
    }

    public void btnEjercicioIntents2(View view){
        Intent datos = new Intent(this, ActivityDatos.class);
        startActivity(datos);
    }

    public void btnEjercicioIntents3(View view){
        Intent datos = new Intent(this, ActividadNombre.class);
        startActivity(datos);
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
}
