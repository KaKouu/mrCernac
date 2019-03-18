package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class NarrativeLevel3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narrative_level3);

        Intent intent = getIntent();

        int age = intent.getIntExtra("age", 1);

        switch (age) {
            case 1: //impossible
                break;
            case 2: //go play fortnite young kid
                break;
            case 3: //good age
                break;
            case 4: // you're too old
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(NarrativeLevel3.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
