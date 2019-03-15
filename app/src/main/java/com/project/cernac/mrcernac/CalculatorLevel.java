package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.project.cernac.mrcernac.utils.Level;

public class CalculatorLevel extends AppCompatActivity {

    Level level5 = new Level(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_level);

        Button rightAnswer = findViewById(R.id.choice1);
        Button wrongAnswer = findViewById(R.id.choice2);

        rightAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level5.finish();
                Intent intent = new Intent(CalculatorLevel.this, CalculatorAnswer.class);

                intent.putExtra("choice", 1);
                startActivity(intent);
            }
        });

        wrongAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level5.finish();
                Intent intent = new Intent(CalculatorLevel.this, CalculatorAnswer.class);

                intent.putExtra("choice", 2);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(CalculatorLevel.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
