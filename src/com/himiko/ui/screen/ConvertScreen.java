package com.himiko.ui.screen;

import com.himiko.converter.DualNumber;
import com.himiko.main.Main;
import com.himiko.ui.listener.IScreenListener;
import com.himiko.ui.utils.Screen;

import javax.swing.*;
import java.awt.*;

/**
 * @Author himiko
 */

public class ConvertScreen extends Screen {

    //Swing Elements
    private TextField dualNumber;
    private TextField decimalNumber;
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
                DualNumber.convertDualNumberToDecimalNumber(getUserDualNumber());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.convertDecimalNumber = new JButton("Convert Decimal Number");
        this.convertDecimalNumber.setFont(new Font("Arial", Font.BOLD, 26));
        this.convertDecimalNumber.setBounds(300, 660, 500, 60);
        this.convertDecimalNumber.addActionListener(e -> {

            try {
                DualNumber.convertDecimalNumberToDualNumber(getUserDecimalNumber());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        this.setScreenListener(new IScreenListener() {
            @Override
            public void onEnter() {
                dualNumber.setVisible(true);
                decimalNumber.setVisible(true);
                convertDualNumber.setVisible(true);
                convertDecimalNumber.setVisible(true);
                Main.WINDOW.getPanel().add(dualNumber);
                Main.WINDOW.getPanel().add(decimalNumber);
                Main.WINDOW.getPanel().add(convertDualNumber);
                Main.WINDOW.getPanel().add(convertDecimalNumber);
            }

            @Override
            public void onLeft() {
                dualNumber.setVisible(false);
                decimalNumber.setVisible(false);
                convertDualNumber.setVisible(false);
                convertDecimalNumber.setVisible(false);
                Main.WINDOW.getPanel().remove(dualNumber);
                Main.WINDOW.getPanel().remove(decimalNumber);
                Main.WINDOW.getPanel().remove(convertDualNumber);
                Main.WINDOW.getPanel().remove(convertDecimalNumber);
            }
        });
    }

    @Override
    public void render(Graphics g) {
        this.dualNumber.repaint();
        this.decimalNumber.repaint();
        this.convertDualNumber.repaint();
        this.convertDecimalNumber.repaint();

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 26));

        String title = "Converter";
        int textWidth = g.getFontMetrics().stringWidth(title);
        g.drawString(title ,Main.WIDTH / 2 -  textWidth / 2, 30);

        String decimalResult = "Decimal Result:" + DualNumber.getDecimalNumber();
        g.drawString(decimalResult ,Main.WIDTH / 2 -  textWidth / 2 - 50, 140);

        String dualResult = "Dual Result:" + DualNumber.getDualNumber();
        g.drawString(dualResult, Main.WIDTH / 2 -  textWidth / 2 - 50, 180);


        g.drawString("Dual Number:" ,dualNumber.getX() - 180, dualNumber.getY() + 20);
        g.drawString("Decimal Number:" ,decimalNumber.getX() - 230, decimalNumber.getY() + 20);
    }

    private int getUserDualNumber()
    {
       int jml = Integer.parseInt(dualNumber.getText());

        return jml;
    }

    private int getUserDecimalNumber()
    {
        int jml=  Integer.parseInt(decimalNumber.getText());

        return jml;
    }

}
