package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.project.cernac.mrcernac.utils.Level;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorAnswer extends AppCompatActivity {

    Level level6 = new Level(this);

    String wrongAnswerText = "Cela doit être dû à ton âge ...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_answer);

        Intent intent = getIntent();
        final TextView crabSpeech = findViewById(R.id.crabSpeech);
        final int[] it = {0};

        int choice = intent.getIntExtra("choice", 1);


        switch (choice) {
            case 1:
                crabSpeech.setText("Ça ne compte pas, la question était trop simple !!");
                crabSpeech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        level6.finish();
                        Intent intent = new Intent(CalculatorAnswer.this, HowOldAreYou.class); // NIVEAU NORMAL
                        startActivity(intent);
                    }

                });
                break;

            case 2:
                crabSpeech.setText("Wow !! T'es archi nul !!");
                crabSpeech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        crabSpeech.setText(wrongAnswerText);
                        it[0] += 1;
                        System.out.println(it[0]);
                        if (it[0] >= 2) {
                            level6.finish();
                            Intent intent = new Intent(CalculatorAnswer.this, HowOldAreYou.class);
                            startActivity(intent);
                        }
                    }
                });

            default:
                System.out.println("ERROR");
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(CalculatorAnswer.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
