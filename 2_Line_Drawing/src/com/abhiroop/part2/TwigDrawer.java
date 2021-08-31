package com.abhiroop.part2;

import com.abhiroop.part1.Bresenham;
import com.abhiroop.part1.LineDrawer;

import javax.swing.*;
import java.awt.*;

public class TwigDrawer extends Canvas {
    private final int xOrigin;
    private final int yOrigin;
    private LineDrawer lineDrawer;

    public TwigDrawer(JFrame displayWindow) {
        //set Background Color
        setBackground(Color.white);

        //get origin of the displayWindow
        xOrigin = (displayWindow.getX() + displayWindow.getWidth()) / 2;
        yOrigin = (displayWindow.getY() + displayWindow.getHeight()) / 2;

    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2, LineDrawer lineDrawer){
        lineDrawer.draw(g, x1, y1, x2, y2);
    }

    private void drawTwig(Graphics g, int startX, int startY, int numBranches, double lineLength, double drawDirection){
        if(numBranches > 0){
            int x2 = startX + (int)Math.round(lineLength * Math.cos(drawDirection * Math.PI /180));
            int y2 = startY + (int)Math.round(lineLength * Math.sin(drawDirection * Math.PI /180));
            drawLine(g, startX, startY, x2, y2, lineDrawer);
            drawTwig(g, x2, y2, numBranches -1 , lineLength/2, drawDirection +(45 + (30* Math.random())));
            drawTwig(g, x2, y2, numBranches -1 , lineLength/2, drawDirection - (45 + (30* Math.random())));
        }
    }

    @Override
    public void paint(Graphics g) {
        int length = 100;
        int drawDirection = 90;
        lineDrawer = new Bresenham(xOrigin, yOrigin);

        drawTwig(g, -300, 300, 1, length, drawDirection);
        drawTwig(g, -100, 300, 2, length, drawDirection);
        drawTwig(g, 100, 300, 3, length, drawDirection);
        drawTwig(g, 300, 300, 4, length, drawDirection);

        drawTwig(g, 0, -300, 8, 300, drawDirection);
    }
}
