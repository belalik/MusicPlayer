package com.example.musicplayer;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private AudioManager audioManager;
    private int actualVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mp = MediaPlayer.create(getApplicationContext(), R.raw.miles);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        Button playButton = (Button) findViewById(R.id.play_button);

        Button pauseButton = (Button) findViewById(R.id.pause_button);

        Button stopButton = (Button) findViewById(R.id.stop_button);

        Button increaseVolumeButton = (Button) findViewById(R.id.increase_volume);

        Button decreaseVolumeButton = (Button) findViewById(R.id.decrease_volume);

        // play
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                playMusic();

            }
        });

        // pause
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                pauseMusic();

            }
        });

        // stop
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                stopMusic();

            }
        });

        // stop
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                stopMusic();

            }
        });

        // increase volume
        increaseVolumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, actualVolume + 1, AudioManager.FLAG_SHOW_UI);
            }
        });

        // decrease volume
        decreaseVolumeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                actualVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, actualVolume - 1, AudioManager.FLAG_SHOW_UI);
            }
        });
        //float volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC) / 15f;



    }


    private void playMusic(){
        //set up MediaPlayer
        //MediaPlayer mp = new MediaPlayer();

        try {

            if (mp==null) {
                //mp = MediaPlayer.create(getApplicationContext(), R.raw.miles);
                mp = MediaPlayer.create(getApplicationContext(), R.raw.phrase_site);
            }


            mp.start(); // starting mediaplayer

            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Toast.makeText(MainActivity.this, "Song finished", Toast.LENGTH_SHORT).show();
                    //finish(); // finish current activity
                }
            });


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


    private void stopMusic() {

        try {

            if (mp != null) {
                mp.stop();
                mp.release();
                mp = null;


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void setVolume(float leftVolume, float rightVolume) {
        if (mp != null) {
            mp.setVolume(leftVolume, rightVolume);
        }

    }



}
