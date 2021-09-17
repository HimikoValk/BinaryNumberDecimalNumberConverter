package com.himiko.converter;

import com.himiko.ui.screen.ConvertScreen;
import com.himiko.utils.ConsoleColor;

import java.awt.*;

/**
 * @Author himiko
 */

public class DualNumber {

    private static int shift; //number shift // DE: Anzahl der Stellen(Verschiebungen) mit dem StartWert 0
    private static int decimalNumber;
    private static int residualValue; //resideValue as between result // DE: Restwert als ZwischenErgebnis

    // Dual = Binary // DE: Dualzahl = Binearzahl
    public static void convertDualNumberInDecimalNumber(int number)
    {
         int dualNumber = number;
         shift = 0;
         decimalNumber = 0;
         residualValue = 0;

        System.out.println("User Dual Number:" + number + ConsoleColor.ANSI_WHITE +"\nStarting to Convert!");
        while(dualNumber !=0)
        {
            residualValue = dualNumber % 10; // Comma shift // DE: Restwert nach Kommaverschiebung aus letzten Durchlauf
            decimalNumber = decimalNumber+(int)(residualValue*(Math.pow(2, shift))); //Summed up intermediate values
            dualNumber = dualNumber / 10;
            shift = shift+1;
        }
        System.out.println(ConsoleColor.ANSI_GREEN +"Convert Finished!\nUser Decimal number:" + decimalNumber + ConsoleColor.ANSI_WHITE);
    }

    public static int getDecimalNumber()
    {
        return decimalNumber;
    }
}
