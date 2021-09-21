package com.himiko.converter;

import com.himiko.ui.screen.ConvertScreen;
import com.himiko.utils.ConsoleColor;

import java.awt.*;
import java.sql.Array;
import java.util.Arrays;

/**
 * @Author himiko
 */

public class DualNumber {

    private static int shift; //number shift // DE: Anzahl der Stellen(Verschiebungen) mit dem StartWert 0
    private static int decimalNumber;
    private static int residualValue; //resideValue as between result // DE: Restwert als ZwischenErgebnis
    private static int result[];

    // Dual = Binary // DE: Dualzahl = Binearzahl
    public static void convertDualNumberToDecimalNumber(int number){
         int dualNumber = number;
         shift = 0;
         decimalNumber = 0;
         residualValue = 0;

        System.out.println("User Dual Number:" + number + ConsoleColor.ANSI_WHITE +"\nStarting to Convert!");
        while(dualNumber !=0)
        {
            residualValue = dualNumber % 10; // Comma shift // DE: Restwert nach Kommaverschiebung aus letzten Durchlauf
            decimalNumber = decimalNumber+(int)(residualValue*(Math.pow(ConvertScreen.getComboBoxValue(), shift))); //Summed up intermediate values
            dualNumber = dualNumber / 10;
            shift = shift+1;
        }
        System.out.println(ConsoleColor.ANSI_GREEN +"Convert Finished!\nUser Decimal number:" + decimalNumber + ConsoleColor.ANSI_WHITE);
    }

    public static void convertDecimalNumberToDualNumber(int userNumber){

        int decimal = userNumber;
        int shift = 0;
        int copyDecimalNumber = decimal;

        System.out.println("User Decimal Number:" + decimal + ConsoleColor.ANSI_WHITE +"\nStarting to Convert!");

        while(copyDecimalNumber != 0)
        {
            copyDecimalNumber = copyDecimalNumber / 2 ;
            shift++;
        }

        int numbers[] = new int[shift];
        result = new int[shift];

        for(int i = 0; i < shift; i++)
        {
            numbers[i] = decimal % ConvertScreen.getComboBoxValue(); //Default Value = 2
            decimal = decimal /ConvertScreen.getComboBoxValue();
        }

        for(int i = shift - 1; i>= 0; i--)
        {
           result[i] = numbers[i];
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
