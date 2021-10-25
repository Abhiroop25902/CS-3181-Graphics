package com.abhiroop;

import com.abhiroop.utils.MatrixForm;

import javax.swing.*;

public class Main {

    private static JFrame getDisplayWindow(){
        var displayWindow = new JFrame();
        displayWindow.setVisible(true); //generates a window where Canvas can be shown
        displayWindow.setSize(1000,1000); //set default size of the window
        displayWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes sure the process is terminated after window closed
        return displayWindow;
    }
    public static void main(String[] args) {
        var displayWindow1 = getDisplayWindow();
        displayWindow1.add(new DisplayWindow(displayWindow1));

//        double[][] A = { { 1, 1, 1 },
//                { 2, 2, 2 },
//                { 3, 3, 3 },
//                { 4, 4, 4 } };
//        var m1 = new MatrixForm(A);
//
//        double[][] B = { { 1, 1, 1, 1 },
//                { 2, 2, 2, 2 },
//                { 3, 3, 3, 3 } };
//        var m2 = new MatrixForm(B);
//
//        var res = m2.multiply(m1).getMatrix();
//
//        for (double[] re : res) {
//            for (int j = 0; j < re.length; j++)
//                System.out.print(re[j] + " ");
//
//            System.out.println();
//        }
    }
}
