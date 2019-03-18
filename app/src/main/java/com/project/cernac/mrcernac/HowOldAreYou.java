package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.project.cernac.mrcernac.utils.Level;

public class HowOldAreYou extends AppCompatActivity {

    Level level7 = new Level(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_old_are_you);
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
