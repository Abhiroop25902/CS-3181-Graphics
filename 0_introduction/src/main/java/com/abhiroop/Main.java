package com.abhiroop;

import javax.swing.JFrame; //used for making a window for displaying draws

public class Main {

    private static JFrame getDisplayWindow() {
        JFrame displayWindow = new JFrame();
        displayWindow.setVisible(true); // generates a window on operating system
        displayWindow.setSize(1000, 1000); // set the window's default size
        displayWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes sure to close program execution when
                                                                      // window closed
        return displayWindow;
    }

    public static void main(String[] args) {
        JFrame displayWindow = getDisplayWindow();
        displayWindow.add(new DisplayGraphics()); // displays the graphic drawing
    }

}
