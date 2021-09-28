package com.himiko.main;

import com.himiko.converter.Converter;
import com.himiko.ui.handler.ScreenHandler;

import java.awt.*;

/**
 * @Author himiko
 */

public class Main {

    public static int WIDTH =  1100;
    public static int HEIGHT = 800;
    
    public static com.himiko.main.Window WINDOW = null;

    public static void main(String[] args) {

                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //Fix the NullPointerException
                        Converter.convertDecimalNumberToDualNumber("1");
                        WINDOW = new Window(WIDTH, HEIGHT, "Binary/Decimal number Converter | Developer himiko");
                        ScreenHandler.INSTANCE.setCurrentScreen(ScreenHandler.CONVERT_SCREEN);
                    }
                });
    }

}
