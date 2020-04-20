package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityDatosConfirmar extends AppCompatActivity {

    TextView nombreCompleto, salario, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_confirmar);

        nombreCompleto = (TextView) findViewById(R.id.txtNombreCompleto);
        salario = (TextView) findViewById(R.id.txtSalario);
        edad = (TextView) findViewById(R.id.txtEdad);

        Bundle datos = getIntent().getExtras();

        String _nombreCompleto = datos.getString("nombreCompleto", "");
        Double _salario = datos.getDouble("salario", 0.0);
        int _edad = datos.getInt("edad", 0);

        nombreCompleto.setText(_nombreCompleto);
        salario.setText(String.valueOf(_salario));
        edad.setText(String.valueOf(_edad));
    }

    public void onClickSalir(){

    }
}
