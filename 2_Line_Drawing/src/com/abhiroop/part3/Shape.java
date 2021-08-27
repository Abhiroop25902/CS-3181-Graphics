package com.abhiroop.part3;

import java.awt.*;

public abstract class Shape {
    private final int xOrigin;
    private final int yOrigin;

    public Shape(int xOrigin, int yOrigin) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
    }

    void drawLine(Graphics g, int x1, int y1, int x2, int y2){
        g.drawLine(x1 + xOrigin, yOrigin - y1, xOrigin + x2, yOrigin - y2);
    }
    abstract void draw(Graphics g, int startX, int startY);
}
