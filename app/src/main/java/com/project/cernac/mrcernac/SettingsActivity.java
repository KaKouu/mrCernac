package com.project.cernac.mrcernac;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.project.cernac.mrcernac.utils.Prefs;

public class SettingsActivity extends AppCompatActivity {

    private Prefs prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        prefs = new Prefs(this);


        ImageView back = findViewById(R.id.back);
        Button reinit = findViewById(R.id.reinit);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, Home.class);
                startActivity(intent);
            }
        });

        reinit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.setLevel(0);
            }
        });

    }
}
