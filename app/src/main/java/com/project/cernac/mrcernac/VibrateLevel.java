package com.project.cernac.mrcernac;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cernac.mrcernac.utils.Level;

public class VibrateLevel extends AppCompatActivity {

    Level level11 = new Level(this);


    private long SECONDS_FOR_ONE_LIFE = 1L;

    private long timerLengthSecond =0L;

    private long secondsRemaining =SECONDS_FOR_ONE_LIFE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate_level);


        final Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        Button vibBt = findViewById(R.id.vibBt);

        vibBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer(0);
            }
        });


        final EditText anwserVib = findViewById(R.id.anwserVib);
        Button submit = findViewById(R.id.submit2);
        final TextView crabSpeech = findViewById(R.id.crabSpeech3);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (anwserVib.getText().toString().matches("")){                                               ///ICI
                    crabSpeech.setText("Attention, tu as oublié de mettre une réponse..enfin j'espère pour toi.");
                }else{

                    Integer nbVib = Integer.parseInt(anwserVib.getText().toString());

                    if (nbVib <= 0 || nbVib >6  ) {
                        crabSpeech.setText("Attention il doit y avoir une erreur dans ce que tu viens de rentrer !");
                    } else if (nbVib != 1){
                        crabSpeech.setText("C'est FAUX ... Reessaye avant que je te mange....  ☺");
                    } else {
                        level11.finish();
                        Intent intent = new Intent(VibrateLevel.this,GyroLevel.class);
                        startActivity(intent);
                    }
                }
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(VibrateLevel.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void startTimer( final int nb){
        CountDownTimer timer = new CountDownTimer(1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining=millisUntilFinished/1000;

            }

            @Override
            public void onFinish() {
                onTimerFinished(nb);
            }
        }.start();

    }

    private void onTimerFinished(int nb){

        final Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        int nbL = nb + 1;

        secondsRemaining = timerLengthSecond;

        switch (nbL) {
            case 1:
                vib.vibrate(3000);
            break;
            case 5:
                vib.vibrate(200);
                break;
            case 7:
                vib.vibrate(2500);
                break;
            case 11:
                vib.vibrate(1000);
                break;
            case 13:
                vib.vibrate(100);
                break;
            case 14:
                vib.vibrate(2500);
                break;



        }

        if (nbL < 14) {
            startTimer(nbL);
        }


    }
}
