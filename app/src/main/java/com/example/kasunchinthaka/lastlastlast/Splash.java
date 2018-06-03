package com.example.kasunchinthaka.lastlastlast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Kasun Chinthaka on 11/17/2016.
 */

public class Splash extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final ImageView iv = (ImageView)findViewById(R.id.imageView);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener(){
            public void onAnimationStart(Animation animation){

            }
            public void onAnimationEnd(Animation animation){
                iv.startAnimation(an2 );
                finish();
                Intent intent = new Intent(getBaseContext(),HomeActivity.class);
                startActivity(intent);

            }
            public void onAnimationRepeat(Animation animation){

            }

        });

       // if (getIntent().getBooleanExtra("EXIT", false)) {
       //     finish();
       // }

    }
}
