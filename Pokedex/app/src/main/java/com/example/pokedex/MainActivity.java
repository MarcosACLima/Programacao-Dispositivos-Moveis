package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    int posicao = 891;
    int qtde = 10;
    LinearLayout lnlPokedex;
    Button btnProximo;
    Button btnAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lnlPokedex = findViewById(R.id.lnlPokedex);

        btnProximo = new Button(getBaseContext());
        btnProximo.setText("Carregar mais");
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicao += qtde;
                carregar();
           }
        });

        btnAnterior = new Button(getBaseContext());
        btnAnterior.setText("Voltar");
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicao -= qtde;
                carregar();
            }
        });

        carregar();
    }

    private void carregar() {
        lnlPokedex.removeAllViews();

        if (posicao > 1) {
            lnlPokedex.addView(btnAnterior);
        }

        for (int i = posicao; i < posicao + qtde; i++){
            carregarImagem(i);
        }

        if (posicao < 891) {
            lnlPokedex.addView(btnProximo);
        }
    }

    private  void carregarImagem(int indice) {
        ImageView img = new ImageView(getBaseContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String path = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/full/%03d.png", indice);
                    InputStream is = new URL(path).openStream();
                    Bitmap b = BitmapFactory.decodeStream(is);

                    img.post(new Runnable() {
                        @Override
                        public void run() {
                            img.setImageBitmap(b);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        lnlPokedex.addView(img);
    }

}