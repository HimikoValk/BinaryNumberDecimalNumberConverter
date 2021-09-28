package com.himiko.converter;

import com.himiko.ui.screen.ConvertScreen;
import com.himiko.utils.ConsoleColor;

import java.awt.*;
import java.sql.Array;
import java.util.Arrays;

/**
 * @Author himiko
 */

public class Converter {

    private static int shift; //number shift // DE: Anzahl der Stellen(Verschiebungen) mit dem Start Wert 0
    private static int decimalNumber;
    private static int residualValue; //resideValue as between result // DE: Restwert als ZwischenErgebnis
    private static int result[];

    // Dual = Binary // DE: Dualzahl = Binearzahl
    public static void convertDualNumberToDecimalNumber(int number){
         shift = 0;
         decimalNumber = 0;
         residualValue = 0;

        System.out.println("User Dual Number:" + number + ConsoleColor.ANSI_WHITE +"\nStarting to Convert!");
        while(number !=0)
        {
            residualValue = number % 10; // Comma shift // DE: Restwert nach Kommaverschiebung aus letzten Durchlauf
            decimalNumber = decimalNumber+(int)(residualValue*(Math.pow(ConvertScreen.getComboBoxValue(), shift))); //Summed up intermediate values
            number = number / 10;
            shift = shift+1;
        }
        System.out.println(ConsoleColor.ANSI_GREEN +"Convert Finished!\nUser Decimal number:" + decimalNumber + ConsoleColor.ANSI_WHITE);
    }

    public static void convertDecimalNumberToDualNumber(int userNumber){

        shift = 0;
        int copyDecimalNumber = userNumber; // added Variable for shift // DE: Die Dezimalzahl wird am Ende der While-Schleife Null sein deswegen wurde eine Kopie der Value erstellt

        System.out.println("User Decimal Number:" + userNumber + ConsoleColor.ANSI_WHITE +"\nStarting to Convert!");

        // Gets Shift Value
        while(copyDecimalNumber != 0)
        {
            copyDecimalNumber = copyDecimalNumber / 2 ;
            shift++;
        }

        int number[] = new int[shift]; // Array length by shift-value
        result = number;

        for(int i = 0; i < shift; i++)
        {
            number[i] = userNumber % ConvertScreen.getComboBoxValue(); //Saves residual value
            userNumber = userNumber /ConvertScreen.getComboBoxValue();
        }

        for(int i = shift - 1; i>= 0; i--)
        {
           result[i] = number[i];
        }

        System.out.println(ConsoleColor.ANSI_GREEN +"Convert Finished!\nUser Dual number:" + getDualNumber() + ConsoleColor.ANSI_WHITE);
    }

    public static int getDecimalNumber()
    {
        return decimalNumber;
    }

    public static int getDualNumber()
    {
        StringBuilder s = new StringBuilder();

        for(int i : result)
        {
            s.append(i);
        }
        String number = s.reverse().toString();

        return  Integer.parseInt(number);
    }

}
