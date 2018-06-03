package com.example.kasunchinthaka.lastlastlast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_complete);
    }

    public void startlevel(View view){
        finish(); // add finish to finish current activity
        Intent intent = new Intent(this,Level01.class);
        startActivity(intent);
    }
}
