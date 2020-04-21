package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import utilities.Notify;

public class Parcial3 extends AppCompatActivity {

    EditText etUsuario, etContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcial3);

        etUsuario = (EditText)findViewById(R.id.etUsuario2);
        etContrasenia = (EditText)findViewById(R.id.etContrasenia2);
    }

    /**
     * Método para adjuntar a evento de botón para ingresar.
     * @param view Vista actual.
     */
    public void btnIngresarOnClick(View view){

        String usuario = etUsuario.getText().toString();
        String contrasenia = etContrasenia.getText().toString();

        if (TextUtils.isEmpty(usuario)){
            Notify.Show(this, "Ingrese su usuario...", Toast.LENGTH_SHORT);
            etUsuario.setError("Ingrese su usuario");
            etUsuario.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(contrasenia)){
            Notify.Show(this, "Ingrese su contraseña...", Toast.LENGTH_SHORT);
            etContrasenia.setError("Ingrese su contraseña");
            etContrasenia.requestFocus();
            return;
        }

        if (usuario.equals("ELE1") && contrasenia.equals("SECC01")){
            Notify.Show(this, "Bienvenido al sistema!", Toast.LENGTH_SHORT);

            Intent activity2 = new Intent(this, Parcial3_2.class);
            startActivity(activity2);
        }else{
            Notify.Show(this, "Error...", Toast.LENGTH_SHORT);
        }
    }
}
