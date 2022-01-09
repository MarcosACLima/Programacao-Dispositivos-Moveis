package com.example.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view) {
        EditText txtNumero1 = findViewById(R.id.txtNumero1);
        EditText txtNumero2 = findViewById(R.id.txtNumero2);
        TextView txtResultado = findViewById(R.id.txtResultado);

        int n1 = Integer.parseInt(txtNumero1.getText().toString());
        int n2 = Integer.parseInt(txtNumero2.getText().toString());

        int r = n1 + n2;

        txtResultado.setText(String.valueOf(r));
    }

}