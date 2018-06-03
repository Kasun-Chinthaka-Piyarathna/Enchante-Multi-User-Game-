package com.example.kasunchinthaka.lastlastlast;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Level01 extends AppCompatActivity {

    MediaPlayer mySound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level01);

        mySound = MediaPlayer.create(this,R.raw.backmusic1);
        mySound.start();



    }

    protected void onPause() {
        super.onPause();
        mySound.release();
    }
    public void ready001(View view){
        finish(); // add finish to finish current activity
        Intent intent = new Intent(this,ReaderActivity.class);
        startActivity(intent);
    }
   public void leader(View view) {
       finish(); // add finish to finish current activity
       Intent intent = new Intent(this, LeaderboardSample.class);
       startActivity(intent);
   }

    public void home(View view){
        finish(); // add finish to finish current activity
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void exit(View view) {

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
    public void onBackPressed(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Upswing: Caffeine\n" +
                "\n" +
                "Your blood sugar can rise after you have coffee -- even black coffee with no calories -- thanks to the caffeine. The same goes for black tea, green tea, and energy drinks. Each person with diabetes reacts to foods and drinks differently, so it's best to keep track of your own responses. Ironically, other compounds in coffee may help prevent type 2 diabetes in healthy people.")
                .setCancelable(false)
                .setPositiveButton("Got it", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // super.onBackPressed();
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
