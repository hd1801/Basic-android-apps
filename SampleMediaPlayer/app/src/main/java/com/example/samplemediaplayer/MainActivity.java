package com.example.samplemediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.function.LongConsumer;

public class MainActivity extends AppCompatActivity {

    int songID;
    MediaPlayer a;
    TextView state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songID=R.raw.song;
        if(a!=null)
            a.release();
        a= MediaPlayer.create(this,songID);
        state = (TextView)findViewById(R.id.state_textview);
    }

    public void playSong(View view)
    {
        if(a!=null)
            a= MediaPlayer.create(this,songID);
        a.start();
        state.setText("Playing");
        a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                state.setText("finished");
            }
        });
    }
    public void pauseSong(View view)
    {
        a.pause();
        state.setText("paused");
    }
    public void stopSong(View view)
    {
        a.stop();
        state.setText("idle");
        if(a!=null)
        a.release();
    }


    @Override
    protected void onStop() {
        super.onStop();
        a.stop();
        if(a!=null)
        a.release();
    }


}