package com.abhiroop.part1;

import java.awt.*;

public class CircleDrawer {
    private final int xOrigin;
    private final int yOrigin;

    public CircleDrawer(int xOrigin, int yOrigin) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
    }
    void drawPoint(Graphics g, int x, int y){
        g.drawLine(xOrigin + x, yOrigin - y, xOrigin + x, yOrigin - y);
    }

    public void draw(Graphics g, int xCenter, int yCenter, int radius){
        int x = radius;
        int  y= 0;

        drawPoint(g, x+xCenter, y+yCenter);

        if(radius > 0){
            drawPoint(g, x+xCenter, -y + yCenter);
            drawPoint(g, y+xCenter, x+yCenter);
            drawPoint(g, -y + xCenter, x+yCenter);
        }

        int P = 1-radius;

        while(x > y){
            y++;
            if(P<= 0)
                P = P + 2*y + 1;
            else{
                x--;
                P = P + 2*y - 2*x +1;
            }

            if(x<y)
                break;

            drawPoint(g, x+xCenter, y+yCenter);
            drawPoint(g, -x + xCenter, y + yCenter);
            drawPoint(g, x+xCenter, -y+yCenter);
            drawPoint(g, -x+xCenter, -y + yCenter);

            if(x!= y){
                drawPoint(g, y+xCenter, x+yCenter);
                drawPoint(g, -y + xCenter, x + yCenter);
                drawPoint(g, y+xCenter, -x+yCenter);
                drawPoint(g, -y+xCenter, -x + yCenter);
            }

        }
    }
}
