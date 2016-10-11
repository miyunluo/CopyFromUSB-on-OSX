package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * Created by miyunluo on 16/10/11.
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.GUI();

        new CheckUSB().start();
        System.out.println("Searching for USB");
    }

    private void GUI()
    {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(580, 250);
        JButton hide = new JButton("Click to hide this windows");
        hide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        frame.add(hide);
        frame.pack();
        frame.setVisible(true);
    }

}
