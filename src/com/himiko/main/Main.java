package com.himiko.main;



import com.himiko.converter.DualNumber;
import com.himiko.ui.handler.ScreenHandler;

import javax.swing.*;
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
                        try {
                            DualNumber.convertDecimalNumberToDualNumber(10);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        WINDOW = new Window(WIDTH, HEIGHT, "Binear/Decimal number Converter");
                        ScreenHandler.INSTANCE.setCurrentScreen(ScreenHandler.CONVERT_SCREEN);
                    }
                });
    }

}
