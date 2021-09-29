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
    private static int decimalNumber; //saves decimalNumber
    private static int residualValue; //residualValue as between result // DE: Restwert als ZwischenErgebnis
    private static int result[]; // saves result
    private static String hexDecimal; //Saves hexDecimal result

    // Dual = Binary // DE: Dualzahl = Binearzahl
    public static void convertDualNumberToDecimalNumber(String number){
         if(ConvertScreen.getComboBoxValue() > 10)
         {
             decimalNumber = Integer.parseInt(number, ConvertScreen.getComboBoxValue());
         }else {
             int userNumber = Integer.parseInt(number);
             shift = 0;
             decimalNumber = 0;
             residualValue = 0;

             System.out.println("User Dual Number:" + number + ConsoleColor.ANSI_WHITE + "\nStarting to Convert!");
             while (userNumber != 0) {
                 residualValue = userNumber % 10; // Comma shift // DE: Restwert nach Kommaverschiebung aus letzten Durchlauf
                 decimalNumber = decimalNumber + (int) (residualValue * (Math.pow(ConvertScreen.getComboBoxValue(), shift))); //Summed up intermediate values // Ansteigende Zwischen werte
                 userNumber = userNumber / 10; //New Comma shift
                 shift++;
             }

         }
        System.out.println(ConsoleColor.ANSI_GREEN + "Convert Finished!\nUser Decimal number:" + decimalNumber + ConsoleColor.ANSI_WHITE);
    }

    public static void convertDecimalNumberToDualNumber(String userString){

        shift = 0;
        int userNumber = Integer.parseInt(userString);

        if(ConvertScreen.getComboBoxValue() > 10)
        {
            residualValue = 0;
            char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            while (userNumber != 0)
            {
                residualValue = userNumber  %  ConvertScreen.getComboBoxValue(); //Saves Residual Value in hexadecimal Array // DE: Speichert den Rest im hexadezimal Array
                hexDecimal = hexchars[residualValue] + hexDecimal; //Saves the result
                userNumber = userNumber / ConvertScreen.getComboBoxValue();
            }

        }
        else
        {
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

            //reverse the number
            for(int i = shift - 1; i>= 0; i--)
            {
                result[i] = number[i];
            }
        }

        System.out.println(ConsoleColor.ANSI_GREEN +"Convert Finished!\nUser Dual number:" + getDualNumber() + ConsoleColor.ANSI_WHITE);
    }

    public static int getDecimalNumber()
    {
        return decimalNumber;
    }

    public static String getDualNumber()
    {
        if(ConvertScreen.getComboBoxValue() > 10)
        {
            return  hexDecimal;
        }
        else
        {
            StringBuilder s = new StringBuilder();

            for(int i : result)
            {
                s.append(i);
            }
            String number = s.reverse().toString();

            return number;
        }
    }

    public static void resetHexOutPut()
    {
        hexDecimal = "";
    }

}
