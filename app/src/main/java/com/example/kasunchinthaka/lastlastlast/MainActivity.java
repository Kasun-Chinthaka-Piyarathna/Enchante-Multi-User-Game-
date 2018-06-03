package com.example.kasunchinthaka.lastlastlast;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mySound;
    TextView textblink,producttxt;
    Animation animBlink,animSequential;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySound = MediaPlayer.create(this,R.raw.backmusic1);
        mySound.start();

        textblink=(TextView)findViewById(R.id.canyoutext);
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        textblink.setVisibility(View.VISIBLE);
        textblink.startAnimation(animBlink);

        producttxt=(TextView)findViewById(R.id.producttxt);
        animSequential = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sequential);
        producttxt.setVisibility(View.VISIBLE);
        producttxt.startAnimation(animSequential);

        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }

    }

    protected void onPause() {
        super.onPause();
        mySound.release();
    }

    public void NEXT(View view){

        finish();// add finish to finish current activity
        Intent intent = new Intent(this,LevelComplete.class);
        startActivity(intent);
    }

    public void currentleader(View view){
        finish();// add finish to finish current activity
        Intent intent = new Intent(this,CurrentLeaderBoard.class);
        startActivity(intent);
    }

    public void onBackPressed(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       // super.onBackPressed();
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}

