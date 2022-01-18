package com.example.tocaraudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.musica);
    }

    public void play(View view) {
        mp.start();
    }

    public void pause(View view) {
        mp.pause();
    }

    public void stop(View view) {
        mp.stop();
    }
}