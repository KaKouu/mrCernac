package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.cernac.mrcernac.utils.Level;

public class LanguageLevel2 extends AppCompatActivity {

    String question ;
    Level level2 = new Level(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_level2);

        Button choice1 = findViewById(R.id.choice1);
        Button choice2 = findViewById(R.id.choice2);
        TextView crabSpeech = findViewById(R.id.crabSpeech);

        Intent intent = getIntent();

        int questionId = intent.getIntExtra("choice",1);


        switch (questionId){
            case 1: question= "Bonjour, pourquoi m'as-tu reveillez ? ";
                    crabSpeech.setText(question);
                    choice1.setText("Pardon...");
                    choice2.setText("J'ai pas fait exprès ...");
            break;
            case 2: question= "♥☻♣◘•♦3, ♠♣☻T♣♥☺5 ♦◘♦ ♣6♠☺ ♀♦p•◘○♠8 ? ";
                crabSpeech.setText(question);
                choice1.setText("◘○◘○...");
                choice2.setText("♥☻♣☻♣☻...");
            break;
            case 3: question= "こんにちは、なぜあなたは起きましたか ？ ";
                crabSpeech.setText(question);
                choice1.setText("恩赦...");
                choice2.setText("それは私のせいです...");
            break;
            case 4: question= "Привет, почему ты проснулся ? ";
                crabSpeech.setText(question);
                choice1.setText("помилование...");
                choice2.setText("Это моя вина...");
            break;
            default:
                System.out.println("ERROR");break;
        }


        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                level2.finish();

                Intent intent = new Intent(LanguageLevel2.this, NarrativeLevel.class);

                startActivity(intent);
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                level2.finish();

                Intent intent = new Intent(LanguageLevel2.this, NarrativeLevel.class);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(LanguageLevel2.this, Home.class);
            startActivity(intent);
            return false;
        } else{
            return super.onKeyDown(keyCode, event);
        }


    }
}
