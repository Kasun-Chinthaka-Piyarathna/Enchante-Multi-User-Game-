package com.example.kasunchinthaka.lastlastlast;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class complete extends AppCompatActivity {
    MediaPlayer mySound;
    Button btnBlink;
    Animation animBlink;
    TextView txtBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        mySound = MediaPlayer.create(this,R.raw.completemusic);
        mySound.start();

        txtBlink=(TextView)findViewById(R.id.txt_blink);


        animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

                txtBlink.setVisibility(View.VISIBLE);
                txtBlink.startAnimation(animBlink);

    }

    protected void onPause() {
        super.onPause();
        mySound.release();
    }
    public void onBackPressed(){
        return;
    }
}
