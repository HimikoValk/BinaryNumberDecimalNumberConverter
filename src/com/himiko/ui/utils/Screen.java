package com.himiko.ui.utils;

/**
 * @Author himiko
 */

import com.himiko.ui.listener.IScreenListener;

import java.awt.*;


public abstract class Screen {

    private String screenName;
    private IScreenListener screenListener;

    public Screen(String screenName){
        this.screenName = screenName;
    }

    public abstract void render(final Graphics g);

    public void setScreenName(String screenName)
    {
        this.screenName = screenName;
    }

    public String getScreenName()
    {
        return  this.screenName;
    }

    public void setScreenListener(IScreenListener screenListener){
        this.screenListener = screenListener;
    }

    public IScreenListener getScreenListener(){
        return  screenListener;
    }

}