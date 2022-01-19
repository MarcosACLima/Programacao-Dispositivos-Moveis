package com.example.primeiroacessoarquivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void salvar(View view) {
        Context context =getBaseContext();
        TextView txtNome = findViewById(R.id.txtNome);
        TextView txtConteudo = findViewById(R.id.txtConteudo);

        String filename = "nome.txt";
        String fileContents = "Olá " + txtNome.getText().toString();

        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(fileContents.getBytes());
            txtConteudo.setText("O conteudo do arquivo foi modificado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ler(View view) {
        Context context =getBaseContext();
        FileInputStream fis = null;
        try {
            fis = context.openFileInput("nome.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            String contents = stringBuilder.toString();
            TextView txtConteudo = findViewById(R.id.txtConteudo);
            txtConteudo.setText(contents);
        }
    }
}