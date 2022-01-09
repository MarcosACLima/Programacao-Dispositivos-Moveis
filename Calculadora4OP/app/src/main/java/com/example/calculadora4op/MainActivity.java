package com.example.calculadora4op;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int resultado = 0;
    TextView txtResultado;
    boolean limpar = false;
    char operador = ' ';
    boolean calculado = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txtResultado);
    }

    public void adicionarNumero(View view) {
        if(limpar) txtResultado.setText("0");

        Button  btn = (Button) view;
        int r = Integer.parseInt(txtResultado.getText().toString() + btn.getText());
        txtResultado.setText(String.valueOf(r));
        limpar = false;
    }

    public void calcularOperacoes(View view) {
        if(!calculado) calcular(view);

        Button btn = (Button) view;
        resultado = Integer.parseInt(txtResultado.getText().toString());
        operador = btn.getText().charAt(0);
        limpar = true;
        calculado = false;
    }

    public void limpar(View view) {
        resultado = 0;
        txtResultado.setText("0");
        operador = ' ';
        limpar = false;
        calculado = true;
    }

    public void calcular(View view) {
        int n = Integer.parseInt(txtResultado.getText().toString());
        switch (operador) {
            case '+':
                resultado += n;
                break;
            case '-':
                resultado -= n;
                break;
            case '*':
                resultado *= n;
                break;
            case '/':
                resultado /= n;
                break;
        }
        txtResultado.setText(String.valueOf(resultado));
        calculado = true;
    }

}