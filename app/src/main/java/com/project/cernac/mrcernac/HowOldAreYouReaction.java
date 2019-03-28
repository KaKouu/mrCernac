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

public class HowOldAreYouReaction extends AppCompatActivity {

    Level level8 = new Level(this);

    ArrayList<String> text = new ArrayList(Arrays.asList("Bref, maintenant je vais te faire une devinette",
            "Attention seules les personnes dont l'intelligence dépasse celle des huîtres sont arrivées à trouver la solution"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_old_are_you_reaction);

        Intent intent = getIntent();
        final TextView crabSpeech = findViewById(R.id.crabSpeech);

        int age = intent.getIntExtra("age", 1);
        final int[] it = {0};

        switch (age) {
            case 1: //impossible
                crabSpeech.setText("Impossible !!");
                crabSpeech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        crabSpeech.setText(text.get(it[0]));
                        it[0] += 1;
                        System.out.println(it[0]);
                        if (it[0] >= 2) {
                            level8.finish();
                            Intent intent = new Intent(HowOldAreYouReaction.this, LoadingLevel.class);
                            startActivity(intent);
                        }
                    }
                });
                break;
            case 2: //go play fortnite young kid
                crabSpeech.setText("T'es trop jeune, tu veux pas aller jouer à Adiboo plutôt ?");
                crabSpeech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        crabSpeech.setText(text.get(it[0]));
                        it[0] += 1;
                        System.out.println(it[0]);
                        if (it[0] >= 2) {
                            level8.finish();
                            Intent intent = new Intent(HowOldAreYouReaction.this, LoadingLevel.class);
                            startActivity(intent);
                        }
                    }
                });
                break;
            case 3: //good age
                crabSpeech.setText("T'as le meilleur âge, en toute objectivité !");
                crabSpeech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        crabSpeech.setText(text.get(it[0]));
                        it[0] += 1;
                        System.out.println(it[0]);
                        if (it[0] >= 2) {
                            level8.finish();
                            Intent intent = new Intent(HowOldAreYouReaction.this, LoadingLevel.class);
                            startActivity(intent);
                        }
                    }
                });
                break;
            case 4: // you're too old
                crabSpeech.setText("T'es beaucoup trop vieux !! ");
                crabSpeech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        crabSpeech.setText(text.get(it[0]));
                        it[0] += 1;
                        System.out.println(it[0]);
                        if (it[0] >= 2) {
                            level8.finish();
                            Intent intent = new Intent(HowOldAreYouReaction.this, LoadingLevel.class);
                            startActivity(intent);
                        }
                    }
                });
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(HowOldAreYouReaction.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
