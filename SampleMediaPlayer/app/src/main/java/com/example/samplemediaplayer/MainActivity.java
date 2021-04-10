package com.example.samplemediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int songID;
    MediaPlayer a;
    TextView state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songID=R.raw.song;
        a= MediaPlayer.create(this,songID);
        state = (TextView)findViewById(R.id.state_textview);
    }
    public void playSong(View view)
    {
        a.start();
        state.setText("Playing");

    }
    public void pauseSong(View view)
    {
        a.pause();
        state.setText("paused");}
    public void stopSong(View view)
    {
        a.stop();
        state.setText("idle");
        a= MediaPlayer.create(this,songID);
    }
}