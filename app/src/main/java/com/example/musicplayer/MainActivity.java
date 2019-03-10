package com.example.musicplayer;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button playButton = (Button) findViewById(R.id.play_button);

        Button pauseButton = (Button) findViewById(R.id.pause_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                playMusic();

            }
        });


        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                pauseMusic();

            }
        });


    }


    private void playMusic(){
        //set up MediaPlayer
        //MediaPlayer mp = new MediaPlayer();

        try {

            if (mp==null) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.miles);
            }


            mp.start(); // starting mediaplayer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pauseMusic(){
        //set up MediaPlayer
        //MediaPlayer mp = new MediaPlayer();

        try {
            if (mp==null) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.miles);
            }

            mp.pause(); // pausing mediaplayer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
