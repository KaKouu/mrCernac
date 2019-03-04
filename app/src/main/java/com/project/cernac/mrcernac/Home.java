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

        switch (actualLevels){
            case 0 :
                Class<IntroductionLevel> level0 = IntroductionLevel.class;
                chooseActivity(level0);
                break;
            case 1:
                Class<LanguageLevel> level1 = LanguageLevel.class;
                chooseActivity(level1);
                break;
            case 2:
                Class<LanguageLevel2> level2 = LanguageLevel2.class;
                chooseActivity(level2);
                break;
            case 3:
                Class<NarrativeLevel> level3 = NarrativeLevel.class;
                chooseActivity(level3);
                break;

            default: System.out.println("ERROR");
                break;
        }



        }

    private void chooseActivity(Class level) {
        Intent intent = new Intent(Home.this, level);
        startActivity(intent);

    }
}




/* ///////////////PREFS//////////////////
prefs = new Prefs(this);
final int[] actualLevels = {prefs.getLevel()};

/* /////////////// WEBVIEWS//////////////////
        WebView webTest = findViewById(R.id.webTest);
        webTest.setWebViewClient(new WebViewClient());
        webTest.loadUrl("https://www.pokepedia.fr/Salam%C3%A8che");*/