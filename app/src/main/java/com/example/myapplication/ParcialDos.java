package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import utilities.ParcialDos_Data;
import utilities.ParcialDos_Model;

public class ParcialDos extends AppCompatActivity {

    private int numeroPregunta = 0;
    private int puntosObtenidos = 0;
    private ParcialDos_Model[] arrPreguntas;
    private ParcialDos_Model preguntaActual;

    TextView tvTitulo, tvSubtitulo;
    Button btnSiguiente, btnSalir;
    RadioButton rbOpcion1, rbOpcion2, rbOpcion3;
    RadioGroup rGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcial_dos);

        // Obtebiendo la data:
        arrPreguntas = new ParcialDos_Data().preguntas;

        // Enlanzando elementos:
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        tvSubtitulo = (TextView)findViewById(R.id.tvSubtitulo);
        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        btnSalir = (Button)findViewById(R.id.btnSalir);
        rbOpcion1 = (RadioButton)findViewById(R.id.rbOpcion1);
        rbOpcion2 = (RadioButton)findViewById(R.id.rbOpcion2);
        rbOpcion3 = (RadioButton)findViewById(R.id.rbOpcion3);
        rGroup = (RadioGroup)findViewById(R.id.radioGroup);

        // Ejecutando operación de vista inicial:
        numeroPregunta = 1;
        puntosObtenidos = 0;
        cambiarPregunta();
    }

    /**
     * Establece la vista para una pregunta nueva.
     */
    private void cambiarPregunta(){
        tvTitulo.setText("Pregunta " + numeroPregunta);

        // Obteniendo pregunta:
        preguntaActual = arrPreguntas[numeroPregunta - 1];

        // Estableciendo datos de las preguntas:
        tvSubtitulo.setText(preguntaActual.Pregunta);

        rbOpcion1.setText(preguntaActual.Opciones.get(1));
        rbOpcion2.setText(preguntaActual.Opciones.get(2));
        rbOpcion3.setText(preguntaActual.Opciones.get(3));
        rGroup.clearCheck();
    }

    /**
     * Muestra la vista como resultado.
     */
    private void mostrarResultado(){
        tvTitulo.setText("Nota obtenida: " + puntosObtenidos);

        // Se aprueba con nota mayor o igual a 6:
        if (puntosObtenidos >= 6){
            tvSubtitulo.setText("Estado: Aprobado");
        }else{
            tvSubtitulo.setText("Estado: Reprobado");
        }

        // Ocultando elementos:
        btnSiguiente.setVisibility(View.INVISIBLE);
        rGroup.setVisibility(View.INVISIBLE);
    }

    /**
     * Califica la respuesta según la pregunta actual.
     */
    private void calificar(){
        RadioButton rbChecked = (RadioButton)findViewById(rGroup.getCheckedRadioButtonId());
        int respuesta = Integer.parseInt(rbChecked.getTag().toString());

        // Si es correcta, incrementa los puntos:
        if (preguntaActual.RespuestaCorrecta == respuesta){
            puntosObtenidos += 2;
        }
    }

    /**
     * Método para adjuntar a evento de botón para salir de la aplicación.
     * @param view Vista actual.
     */
    public void btnSiguienteOnClick(View view){
        // Calificando pregunta actual:
        calificar();

        // Mostrando siguiente pregunta o resultado:
        numeroPregunta++;

        if (numeroPregunta > 5) {
            mostrarResultado();
        }else{
            cambiarPregunta();
        }
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
