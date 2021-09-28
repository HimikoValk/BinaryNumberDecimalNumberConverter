package com.himiko.ui.screen;

import com.himiko.converter.Converter;
import com.himiko.main.Main;
import com.himiko.ui.listener.IScreenListener;
import com.himiko.ui.utils.Screen;

import javax.swing.*;
import java.awt.*;

/**
 * @Author himiko
 */

public class ConvertScreen extends Screen {

    private static String[] adicList =  {"1", "2", "3", "4", "5", "6" , "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
    private static int adicNumbers = 2;
    //Swing Elements
    private TextField dualNumber;
    private TextField decimalNumber;
    private JComboBox comboBox;
    private JButton convertDualNumber;
    private JButton convertDecimalNumber;

    public ConvertScreen()
    {
        super("Convert Screen");

        this.dualNumber = new TextField("Enter your DualNumber");
        this.dualNumber.setForeground(Color.BLACK);
        this.dualNumber.setFont(new Font("Arial", Font.BOLD, 19));
        this.dualNumber.setBounds(400, 250,300, 40);

        this.decimalNumber = new TextField("Enter your DecimalNumber");
        this.decimalNumber.setForeground(Color.BLACK);
        this.decimalNumber.setFont(new Font("Arial", Font.BOLD, 19));
        this.decimalNumber.setBounds(400, 450,300, 40);

        this.convertDualNumber = new JButton("Convert Dual Number");
        this.convertDualNumber.setFont(new Font("Arial", Font.BOLD, 26));
        this.convertDualNumber.setBounds(300, 600, 500, 60);
        this.convertDualNumber.addActionListener(e -> {

            try {
                Converter.convertDualNumberToDecimalNumber(getUserDualNumber());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.convertDecimalNumber = new JButton("Convert Decimal Number");
        this.convertDecimalNumber.setFont(new Font("Arial", Font.BOLD, 26));
        this.convertDecimalNumber.setBounds(300, 660, 500, 60);
        this.convertDecimalNumber.addActionListener(e -> {

            try {
                Converter.resetHexOutPut();
                Converter.convertDecimalNumberToDualNumber(getUserDecimalNumber());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        this.comboBox = new JComboBox(adicList);
        this.comboBox.setBounds(900, 630, 100, 50);
        this.comboBox.setSelectedIndex(1);
        this.comboBox.addActionListener(e -> {
            switch(comboBox.getSelectedIndex())
            {
                case 0:
                    setComboBoxValue(1);
                    break;
                case 1:
                    setComboBoxValue(2);
                    break;
                case 2:
                    setComboBoxValue(3);
                    break;
                case 3:
                    setComboBoxValue(4);
                    break;
                case 4:
                    setComboBoxValue(5);
                    break;
                case 5:
                    setComboBoxValue(6);
                    break;
                case 6:
                    setComboBoxValue(7);
                    break;
                case 7:
                    setComboBoxValue(8);
                    break;
                case 8:
                    setComboBoxValue(9);
                    break;
                case 9:
                    setComboBoxValue(10);
                    break;
                case 10:
                    setComboBoxValue(11);
                    break;
                case 11:
                    setComboBoxValue(12);
                    break;
                case 12:
                    setComboBoxValue(13);
                    break;
                case 13:
                    setComboBoxValue(14);
                    break;
                case 14:
                    setComboBoxValue(15);
                    break;
                case 15:
                    setComboBoxValue(16);
                    break;
                default:
                    setComboBoxValue(2);
                    break;
            }
        });

        this.setScreenListener(new IScreenListener() {
            @Override
            public void onEnter() {
                comboBox.setVisible(true);
                dualNumber.setVisible(true);
                decimalNumber.setVisible(true);
                convertDualNumber.setVisible(true);
                convertDecimalNumber.setVisible(true);
                Main.WINDOW.getPanel().add(comboBox);
                Main.WINDOW.getPanel().add(dualNumber);
                Main.WINDOW.getPanel().add(decimalNumber);
                Main.WINDOW.getPanel().add(convertDualNumber);
                Main.WINDOW.getPanel().add(convertDecimalNumber);
            }

            @Override
            public void onLeft() {
                comboBox.setVisible(false);
                dualNumber.setVisible(false);
                decimalNumber.setVisible(false);
                convertDualNumber.setVisible(false);
                convertDecimalNumber.setVisible(false);
                Main.WINDOW.getPanel().remove(comboBox);
                Main.WINDOW.getPanel().remove(dualNumber);
                Main.WINDOW.getPanel().remove(decimalNumber);
                Main.WINDOW.getPanel().remove(convertDualNumber);
                Main.WINDOW.getPanel().remove(convertDecimalNumber);
            }
        });
    }

    @Override
    public void render(Graphics g) {
        this.comboBox.repaint();
        this.dualNumber.repaint();
        this.decimalNumber.repaint();
        this.convertDualNumber.repaint();
        this.convertDecimalNumber.repaint();

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 26));

        String title = "Converter";
        int textWidth = g.getFontMetrics().stringWidth(title);
        g.drawString(title ,Main.WIDTH / 2 -  textWidth / 2, 30);

        String decimalResult = "Decimal Result:" + Converter.getDecimalNumber();
        g.drawString(decimalResult ,Main.WIDTH / 2 -  textWidth / 2 - 50, 140);

        String dualResult = "Dual Result:" + Converter.getDualNumber();
        g.drawString(dualResult, Main.WIDTH / 2 -  textWidth / 2 - 50, 180);

        g.drawString("Dual Number:" ,dualNumber.getX() - 180, dualNumber.getY() + 20);
        g.drawString("Decimal Number:" ,decimalNumber.getX() - 230, decimalNumber.getY() + 20);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Adic System:", comboBox.getX() - 20, comboBox.getY() - 20);
    }

    private String getUserDualNumber()
    {
        return dualNumber.getText();
    }

    private String getUserDecimalNumber()
    {
        return decimalNumber.getText();
    }

    public static void setComboBoxValue(int value)
    {
        adicNumbers = value;
    }

    public static int getComboBoxValue()
    {
        return adicNumbers;
    }

}
