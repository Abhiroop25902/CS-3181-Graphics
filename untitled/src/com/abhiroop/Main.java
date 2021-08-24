package com.abhiroop;

import javax.swing.*;

public class Main {

    private static JFrame getDisplayWindow(){
        var displayWindow = new JFrame();
        displayWindow.setVisible(true); //generates a window where Canvas can be shown
        displayWindow.setSize(600,600); //set default size of the window
        displayWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes sure the process is terminated after window closed
        return displayWindow;
    }

    public static void main(String[] args) {
        var displayWindow = getDisplayWindow();
        displayWindow.add(new LineDrawer(displayWindow));
    }
}
