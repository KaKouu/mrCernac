package com.project.cernac.mrcernac;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.project.cernac.mrcernac.utils.Prefs;

import static java.lang.String.valueOf;

public class Home extends AppCompatActivity {

    private Prefs prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prefs = new Prefs(this);
        final int[] actualLevels = {prefs.getLevel()};

        TextView testPrefs = findViewById(R.id.prefTest);
        Button addBt = findViewById(R.id.addBt);

        System.out.println("Actual level is " + actualLevels[0]);

        testPrefs.setText(valueOf(actualLevels[0]));

        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualLevels[0] +=1;
                prefs.setLevel(actualLevels[0]);
                System.out.println("Actual level is " + actualLevels[0]);
                System.out.println("Actual level from prefs is " + prefs.getLevel());
            }
        });



    }
}


/* /////////////// WEBVIEWS//////////////////
        WebView webTest = findViewById(R.id.webTest);
        webTest.setWebViewClient(new WebViewClient());
        webTest.loadUrl("https://www.pokepedia.fr/Salam%C3%A8che");*/