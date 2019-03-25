package com.project.cernac.mrcernac;

import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.project.cernac.mrcernac.utils.Level;
import com.project.cernac.mrcernac.utils.Prefs;

public class LoadingLevel extends AppCompatActivity {

    private long SECONDS_FOR_ONE_LIFE = 1L;

    private long timerLengthSecond =0L;

    private long secondsRemaining =SECONDS_FOR_ONE_LIFE;
    private static final int STOP = 17;
    private int actualSecond = STOP;

    Level levelX = new Level(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_level);


        //final boolean winVar = false;

        final ProgressBar progressBar2 = findViewById(R.id.progressBar);
        Button winBt = findViewById(R.id.winBt);
        final TextView textView =findViewById(R.id.timeText);

        winBt.getBackground().setAlpha(45);

        winBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTxtLife(textView,actualSecond,progressBar2);
                actualSecond+=1;

            }
        });

        startTimer(textView,0,progressBar2);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(LoadingLevel.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    //////TIMER//////


    private void onTimerFinished(TextView txt, int nb , ProgressBar progressBar2){


            int nbL = nb + 1;

            setTxtLife(txt, nbL, progressBar2);

            secondsRemaining = timerLengthSecond;
            txt.setText(nb + "%");
            if (nbL < STOP) {
                startTimer(txt, nbL,progressBar2);
            }else {
                //null : stop the timer
            }

        }

    private void startTimer(final TextView txt, final int nb, final ProgressBar progressBar2){
        CountDownTimer timer = new CountDownTimer(1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining=millisUntilFinished/1000;
                actualSecond =nb;
            }

            @Override
            public void onFinish() {
                onTimerFinished(txt, nb,progressBar2);
            }
        }.start();

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private void setTxtLife(TextView txt, int nb, ProgressBar progressBar2){
        txt.setText(nb+"%");
        progressBar2.setProgress(nb*6,true);

        if (nb == 100){
            levelX.finish();
        Intent next = new Intent( LoadingLevel.this, LoadingLevel.class);
        startActivity(next);}

    }

}


