package com.himiko.main;

import com.himiko.ui.handler.ScreenHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Author himiko
 */

public class Panel extends JPanel {

    public Panel()
    {
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.fillRect(0,0, Main.WIDTH, Main.HEIGHT);

        ScreenHandler.INSTANCE.getCurrentScreen().render(g);

        super.repaint();


    }
}
