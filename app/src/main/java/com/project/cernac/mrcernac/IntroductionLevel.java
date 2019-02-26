package com.project.cernac.mrcernac;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.cernac.mrcernac.utils.Level;

public class IntroductionLevel extends AppCompatActivity{
    Level level0 = new Level(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_level);


        ImageView crab = findViewById(R.id.crab1);


        crab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                level0.finish();

                if(level0.isComplete()){
                    Intent intent = new Intent(IntroductionLevel.this, LanguageLevel.class);
                    startActivity(intent);
                }


            }
        });



    }
}
