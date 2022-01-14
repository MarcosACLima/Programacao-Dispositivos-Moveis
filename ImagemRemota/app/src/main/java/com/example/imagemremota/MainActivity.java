package com.example.imagemremota;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void carregar(View view) {
        ImageView img = findViewById(R.id.imgFigura);

        String path = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream is = new URL(path).openStream();
                    Bitmap b = BitmapFactory.decodeStream(is);

                    img.post(new Runnable() {
                        @Override
                        public void run() {
                            img.setImageBitmap(b);
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

    }

}