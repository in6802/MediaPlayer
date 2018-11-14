package com.example.edu.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonPlay, buttonStop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonStop = findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(this);

        //디스크에 있는 음악파일을 메모리에 올리는 작업
        mediaPlayer = MediaPlayer.create(this, R.raw.thunder_rain);
    }

    @Override
    public void onClick(View view) {

        // 방법 1
        /*
        switch(view.getId()){
            case R.id.buttonPlay:
                onClickPlay();
                break;

            case R.id.buttonStop:
                onClickStop();
                break;
        }*/

        // 방법 2
        int playbackPosition = 0;
        switch (view.getId()) {
            case R.id.buttonPlay:
                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    mediaPlayer.seekTo(playbackPosition);
                } else {
                    mediaPlayer.start();
                }
                break;

            case R.id.buttonStop:
                if (mediaPlayer != null) {
                    playbackPosition = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    break;
                }
        }
    }

    public void onClickPlay(){
        mediaPlayer.start();
        buttonStop.setEnabled(true);
        buttonPlay.setEnabled(false);
    }

    public void onClickStop(){
        mediaPlayer.pause();
        buttonStop.setEnabled(false);
        buttonPlay.setEnabled(true);
    }
}
