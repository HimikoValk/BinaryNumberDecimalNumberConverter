package com.himiko.ui.handler;


import com.himiko.ui.screen.ConvertScreen;
import com.himiko.ui.utils.Screen;

/**
 * @Author himiko
 */

public class ScreenHandler {

    public final  static ScreenHandler INSTANCE = new ScreenHandler();

    private Screen currentScreen;

    //Screens
    public static final ConvertScreen CONVERT_SCREEN;

    static {
        CONVERT_SCREEN = new ConvertScreen();
    }

    public void setCurrentScreen(Screen currentScreen)
    {
        if(this.currentScreen != null)
            if(this.currentScreen.getScreenListener() != null)
                this.currentScreen.getScreenListener().onLeft();
        this.currentScreen = currentScreen;
        if(this.currentScreen.getScreenListener() != null)
            this.currentScreen.getScreenListener().onEnter();
        System.out.println("Current Screen: " + this.currentScreen.getScreenName());
    }

    public Screen getCurrentScreen()
    {
        return currentScreen;
    }

}
