package com.example.passandoargumentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void recuperar(View view) {
        EditText txtEmail = findViewById(R.id.txtEmailLoginmarc+);

        Intent m = new Intent(this, RecuperarSenha.class);
        m.putExtra("email", txtEmail.getText().toString());
        startActivity(m);
    }

}