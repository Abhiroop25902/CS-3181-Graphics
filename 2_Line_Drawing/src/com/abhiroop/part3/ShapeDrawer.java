package com.abhiroop.part3;

import javax.swing.*;
import java.awt.*;

public class ShapeDrawer extends Canvas {
    private final int xOrigin;
    private final int yOrigin;

    public ShapeDrawer(JFrame displayWindow) {
        //set Background Color
        setBackground(Color.white);

        //get origin of the displayWindow
        xOrigin = (displayWindow.getX() + displayWindow.getWidth()) / 2;
        yOrigin = (displayWindow.getY() + displayWindow.getHeight()) / 2;

    }

    void drawShape(Graphics g, Shape shape, int startX, int startY){
        shape.draw(g, startX, startY);
    }

    @Override
    public void paint(Graphics g) {
        drawShape(g, new TopRightTriangleWithHair(xOrigin, yOrigin,
                        450,200, 50),
                -400, 200);
        drawShape(g, new BottomRightTriangleWithHair(xOrigin, yOrigin,
                        450,200, 50),
                -400, 50);
    }
}
