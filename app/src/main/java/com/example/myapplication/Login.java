package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import utilities.Notify;

public class Login extends AppCompatActivity {

    EditText etUsuario, etContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etContrasenia = (EditText)findViewById(R.id.etContrasenia);
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

        if (usuario.equals("ELE1") && contrasenia.equals("VIRTUAL")){
            Notify.Show(this, "Bienvenido al sistema!", Toast.LENGTH_SHORT);
        }else{
            Notify.Show(this, "Error...", Toast.LENGTH_SHORT);
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

    /**
     * Método para adjuntar a evento de botón para ir al inicio.
     * @param view Vista actual.
     */
    public void btnIrAlInicioOnClick(View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}
