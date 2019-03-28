package com.project.cernac.mrcernac;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.project.cernac.mrcernac.utils.Prefs;

public class Home extends AppCompatActivity {

    private Prefs prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prefs = new Prefs(this);
        final int actualLevels = prefs.getLevel();

        MediaPlayer player = MediaPlayer.create(this, R.raw.ukulele);
        player.setLooping(true);
        System.out.println(actualLevels);

        player.stop();
        player.start();

        Button start = findViewById(R.id.startButton);
        ImageView option = findViewById(R.id.option);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseLevel(actualLevels);
            }
        });

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SettingsActivity.class);
                startActivity(intent);
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
            case 4:
                Class<AgreeOrAgree> level4 = AgreeOrAgree.class;
                chooseActivity(level4);
                break;
            case 5:
                Class<NarrativeLevel2> level5 = NarrativeLevel2.class;
                chooseActivity(level5);
                break;
            case 6:
                Class<CalculatorAnswer> level6 = CalculatorAnswer.class;
                chooseActivity(level6);
                break;
            case 7:
                Class<HowOldAreYou> level7 = HowOldAreYou.class;
                chooseActivity(level7);
                break;
            case 8:
                Class<HowOldAreYou> level71 = HowOldAreYou.class;
                chooseActivity(level71);
                break;
            case 9:
                Class<LoadingLevel> level9 = LoadingLevel.class;
                chooseActivity(level9);
                break;
            case 10:
                Class<SoundLevel> level10 = SoundLevel.class;
                chooseActivity(level10);
                break;
            case 11:
                Class<VibrateLevel> level11 = VibrateLevel.class;
                chooseActivity(level11);
                break;
            case 12:
                Class<GyroLevel> level12 = GyroLevel.class;
                chooseActivity(level12);
                break;
            case 13:
                Class<BrightnessLevel> level13 = BrightnessLevel.class;
                chooseActivity(level13);
                break;
            case 14:
                Class<End> level14 = End.class;
                chooseActivity(level14);
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