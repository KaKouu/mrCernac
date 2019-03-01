package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.cernac.mrcernac.utils.Level;

public class LanguageLevel extends AppCompatActivity {

    Level level1 = new Level(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_level);


        Button choiceFr = findViewById(R.id.choice1);     //1
        Button choiceSmiley = findViewById(R.id.choice2); //2
        Button choiceJap = findViewById(R.id.choice3);    //3
        Button choiceRus = findViewById(R.id.choice4);    //4



        choiceFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                level1.finish();

                Intent intent = new Intent(LanguageLevel.this, LanguageLevel2.class);
                intent.putExtra("choice" ,1);
                startActivity(intent);
            }
        });

        choiceSmiley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                level1.finish();

                Intent intent = new Intent(LanguageLevel.this, LanguageLevel2.class);
                intent.putExtra("choice" ,2);
                startActivity(intent);
            }
        });

        choiceJap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                level1.finish();

                Intent intent = new Intent(LanguageLevel.this, LanguageLevel2.class);
                intent.putExtra("choice" ,3);
                startActivity(intent);
            }
        });

        choiceRus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                level1.finish();

                Intent intent = new Intent(LanguageLevel.this, LanguageLevel2.class);
                intent.putExtra("choice" ,4);
                startActivity(intent);
            }
        });



    }
}
