package com.project.cernac.mrcernac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.project.cernac.mrcernac.utils.Level;

public class SoundLevel extends AppCompatActivity {

    Level level10 = new Level(this);
    int rep=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_level);



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(SoundLevel.this, Home.class);
            startActivity(intent);
            return false;
        } else if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            picDown();
            return false;

        } else {
                return super.onKeyDown(keyCode, event);
            }

    }


    public void picDown(){
        ImageView coco = findViewById(R.id.coco);
        coco.setY(coco.getY()+10);

        if (rep>=100){
            level10.finish();
            Intent intent = new Intent(SoundLevel.this, VibrateLevel.class);
            startActivity(intent);
        }
        rep+=1;
        System.out.println(rep);
    }

}
