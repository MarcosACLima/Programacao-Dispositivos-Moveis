package com.example.passandoargumentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RecuperarSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        EditText txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText( getIntent().getStringExtra("email"));
    }

    public void voltar(View view) {
        finish();
    }
}