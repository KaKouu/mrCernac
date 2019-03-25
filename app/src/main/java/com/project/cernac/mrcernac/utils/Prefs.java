package com.project.cernac.mrcernac.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {


    private Context context;

    private String PREFS_NAME;

    private SharedPreferences settings;
    private SharedPreferences.Editor editor ;

    private String ACTUAL_LEVEL;

    private int level;

    public Prefs(Context context) {
        this.context = context;
        this.PREFS_NAME = "com.project.cernac.mrcernac";
        this.ACTUAL_LEVEL = "actual_level";
        this.settings = context.getSharedPreferences(PREFS_NAME, 0);
        this.editor = settings.edit();
    }


    public void setLevel(int level){
        this.editor.putInt(ACTUAL_LEVEL, level);
        editor.commit();
    }

    public int getLevel(){
        return this.settings.getInt(ACTUAL_LEVEL,0);
    }



}
