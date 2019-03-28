package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.project.cernac.mrcernac.utils.Level;

public class GyroLevel extends AppCompatActivity {


    Level levelX = new Level(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyro_level);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(GyroLevel.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        levelX.finish();
        Intent intent = new Intent(GyroLevel.this, Home.class);
        startActivity(intent);

        super.onRestoreInstanceState(savedInstanceState);
    }
}
