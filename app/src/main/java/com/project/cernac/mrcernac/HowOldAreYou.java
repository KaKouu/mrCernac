package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.cernac.mrcernac.utils.Level;

public class HowOldAreYou extends AppCompatActivity {

    Level level7 = new Level(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_old_are_you);

        final EditText userAge = findViewById(R.id.age);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level7.finish();
                Intent intent = new Intent(HowOldAreYou.this, HowOldAreYouReaction.class);

                int age = Integer.parseInt(userAge.getText().toString());
                if (age <= 5 || age >= 100) {
                    intent.putExtra("age", 1);
                    startActivity(intent);
                } else if (age < 19){
                    intent.putExtra("age", 2);
                    startActivity(intent);
                } else if (age >= 19 && age < 50){
                    intent.putExtra("age" , 3);
                    startActivity(intent);
                } else {
                    intent.putExtra("age", 4);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(HowOldAreYou.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
