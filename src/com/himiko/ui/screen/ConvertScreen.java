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
    private JButton startConverter;

    public ConvertScreen()
    {
        super("Convert Screen");

        this.dualNumber = new TextField("Enter your DualNumber");
        this.dualNumber.setForeground(Color.BLACK);
        this.dualNumber.setFont(new Font("Arial", Font.BOLD, 19));
        this.dualNumber.setBounds(400, 250,300, 40);

        this.startConverter = new JButton("Convert");
        this.startConverter.setFont(new Font("Arial", Font.BOLD, 26));
        this.startConverter.setBounds(300, 600, 500, 60);
        this.startConverter.addActionListener(e -> {
            DualNumber.convertDualNumberInDecimalNumber(getUserDualNumber());
        });

        this.setScreenListener(new IScreenListener() {
            @Override
            public void onEnter() {
                dualNumber.setVisible(true);
                startConverter.setVisible(true);
                Main.WINDOW.getPanel().add(dualNumber);
                Main.WINDOW.getPanel().add(startConverter);
            }

            @Override
            public void onLeft() {
                dualNumber.setVisible(false);
                startConverter.setVisible(false);
                Main.WINDOW.getPanel().remove(dualNumber);
                Main.WINDOW.getPanel().remove(startConverter);
            }
        });
    }

    @Override
    public void render(Graphics g) {
        this.dualNumber.repaint();
        this.startConverter.repaint();
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 26));
        String title = "Converter";
        int textWidth = g.getFontMetrics().stringWidth(title);
        g.drawString(title ,Main.WIDTH / 2 -  textWidth / 2, 30);
        String result = "Result:" + DualNumber.getDecimalNumber();
        g.drawString(result ,Main.WIDTH / 2 -  textWidth / 2, 140);
        g.drawString("Dual Number:" ,dualNumber.getX() - 180, dualNumber.getY() + 20);
    }

    private int getUserDualNumber()
    {
        int jml = Integer.parseInt(dualNumber.getText());
        return jml;
    }
}
