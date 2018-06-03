package com.example.kasunchinthaka.lastlastlast;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import com.shephertz.app42.paas.sdk.android.App42Exception;
import com.shephertz.app42.paas.sdk.android.game.Game;

import java.math.BigDecimal;

public  class ReaderActivity extends AppCompatActivity{
    DescriptionDB db = new DescriptionDB();
    Person p = db.getRandomPerson();




   // private AsyncApp42ServiceApi asyncService;
   // private ProgressDialog progressDialog;

    private Button scan_btn;
    String QRresult;
    MediaPlayer mySound;

    TextView Readertxt,Findme;
    Animation animBlink,animZoomOut;

    protected void onCreate(Bundle savedInstanceState) {



    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reader);
    mySound = MediaPlayer.create(this,R.raw.index2);
    mySound.start();


        Findme=(TextView)findViewById(R.id.canyoufindme);
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        Findme.setVisibility(View.VISIBLE);
        Findme.startAnimation(animBlink);

        Readertxt=(TextView)findViewById(R.id.Readertext1);
        Readertxt.setText(p.getDescription());
        animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        Readertxt.setVisibility(View.VISIBLE);
        Readertxt.startAnimation(animZoomOut);


    scan_btn = (Button) findViewById(R.id.scan_btn);
    final Activity activity = this;

    scan_btn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {



            IntentIntegrator integrator = new IntentIntegrator(activity);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
            integrator.setPrompt("Scan");
            integrator.setCameraId(0);
            integrator.setBeepEnabled(false);
            integrator.setBarcodeImageEnabled(false);
            integrator.initiateScan();


        }
    });
}
    protected void onPause() {
        super.onPause();
        mySound.release();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null){
            if(result.getContents()==null){
                Toast.makeText(this,"You cancelled the scanning",Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(this,result.getContents(),Toast.LENGTH_LONG).show();
                QRresult = result.getContents();
                if(QRresult.equals(p.getName())){
                        db.removePerson(p);
                        USER.parameter=10000;
                        finish(); // add finish to finish current activity
                        Intent intent = new Intent(this,LeaderboardSample.class);
                        startActivity(intent);



                    //Intent intent = new Intent(this,Level02.class);
                    //startActivity(intent);
                }
                else {
                    Toast.makeText(this,"Sorry!,Level is not completed",Toast.LENGTH_LONG).show();
                }

            }
        }
        else {

            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
