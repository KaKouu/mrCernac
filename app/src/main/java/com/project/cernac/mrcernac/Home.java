package com.project.cernac.mrcernac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.project.cernac.mrcernac.utils.Prefs;

public class Home extends AppCompatActivity {

    private Prefs prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prefs = new Prefs(this);
        final int actualLevels = prefs.getLevel();

        Button start = findViewById(R.id.startButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseLevel(actualLevels);
            }
        });



    }

    private void chooseLevel(int actualLevels) {
        //TODO

    }
}




/* ///////////////PREFS//////////////////
prefs = new Prefs(this);
final int[] actualLevels = {prefs.getLevel()};

/* /////////////// WEBVIEWS//////////////////
        WebView webTest = findViewById(R.id.webTest);
        webTest.setWebViewClient(new WebViewClient());
        webTest.loadUrl("https://www.pokepedia.fr/Salam%C3%A8che");*/