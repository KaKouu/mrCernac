package com.project.cernac.mrcernac;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.project.cernac.mrcernac.utils.Level;

import java.net.URI;
import java.util.Set;

public class BrightnessLevel extends AppCompatActivity {

    Level level13 = new Level(this);

    boolean success = false;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness_level);


        TextView text = findViewById(R.id.crabSpeech);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level13.finish();
                Intent intent = new Intent(BrightnessLevel.this, End.class);
                startActivity(intent);
            }
        });

        SeekBar seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(255);
        seekBar.setProgress(getBrightness());

        getPermission();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && success){
                    setBrightness(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!success){
                    Toast.makeText(BrightnessLevel.this, "Permission not granted!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void setBrightness(int brightness){
        if (brightness < 0){
            brightness = 0;
        } else if (brightness > 255){
            brightness = 255;
        }

        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
    }

    private int getBrightness(){
        int brightness = 0;
        try{
            ContentResolver contentResolver = getApplicationContext().getContentResolver();
            brightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e){
            e.printStackTrace();
        }
        return brightness;
    }

    private void getPermission(){
        boolean value;
        value = Settings.System.canWrite(getApplicationContext());
        if (value){
            success = true;
        } else{
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
            startActivityForResult(intent, 1000);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000){
            boolean value = Settings.System.canWrite(getApplicationContext());
            if (value){
                success = true;
            } else {
                Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(BrightnessLevel.this, Home.class);
            startActivity(intent);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
