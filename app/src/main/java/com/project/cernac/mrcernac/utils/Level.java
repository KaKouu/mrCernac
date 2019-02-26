package com.project.cernac.mrcernac.utils;

import android.content.Context;


public class Level {

    private boolean isComplete;
    private Context context;
    private Prefs prefs = null;


    public Level(Context context) {
        this.isComplete = false;
        this.context = context;
    }


    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public void finish(){
        prefs = new Prefs(this.context);
        prefs.setLevel(prefs.getLevel()+1);
        setComplete(true);
    }


}
