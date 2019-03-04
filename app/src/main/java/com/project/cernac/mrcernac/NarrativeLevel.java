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

public class NarrativeLevel extends AppCompatActivity {

    Level level3 = new Level(this);

    ArrayList<String> text = new ArrayList(Arrays.asList("Non je plaisante, pardon pour cette petite blague. J'aime bine m'amuser avec " +
            "les inconnus.", "Je me présente, je m'appelle Mr.Cernac. Grand roi de la plage.", "test"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narrative_level);


        final TextView crabSpeech = findViewById(R.id.crabSpeech);
        final int[] it = {0};


        crabSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crabSpeech.setText(text.get(it[0]));
                it[0] +=1;

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(NarrativeLevel.this, Home.class);
            startActivity(intent);
            return false;
        } else{
            return super.onKeyDown(keyCode, event);
        }


    }








}
