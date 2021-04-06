package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA=0 ,scoreB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA();
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreA));
    }
    public void displayForTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreB));
    }
    public void A_3pointer(View view)
    {
        scoreA=scoreA +3;
        displayForTeamA();
    }
    public void A_2pointer(View view)
    {
        scoreA=scoreA +2;
        displayForTeamA();
    }
    public void A_free_throw(View view)
    {
        scoreA=scoreA + 1;
        displayForTeamA();
    }
    public void B_3pointer(View view)
    {
        scoreB=scoreB +3;
        displayForTeamB();
    }
    public void B_2pointer(View view)
    {
        scoreB=scoreB +2;
        displayForTeamB();
    }
    public void B_free_throw(View view)
    {
        scoreB=scoreB + 1;
        displayForTeamB();
    }
    public void reset(View view)
    {
        scoreA=scoreB=0;
        displayForTeamA();
        displayForTeamB();
    }
}