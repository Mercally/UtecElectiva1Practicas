package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
    }

    public void onClickRetornar(View view){
        Intent intentPrincipal = new Intent(this, IntentMain.class);
        startActivity(intentPrincipal);
    }
}