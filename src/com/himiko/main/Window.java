package com.himiko.main;


import javax.swing.*;


/**
 * @Author himiko
 */

public class Window extends JFrame{

    private com.himiko.main.Panel panel;

    public Window(final int width, final int height, final String Title)
    {
        this.panel = new Panel();
        super.getContentPane().add(this.panel);
        super.pack();
        super.setTitle(Title);
        super.setSize(width + super.getInsets().left + super.getInsets().right - 10, height + super.getInsets().top + super.getInsets().bottom - 10);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.setResizable(false);


    }

    public Panel getPanel() {
        return panel;
    }
}
