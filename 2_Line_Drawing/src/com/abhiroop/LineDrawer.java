package com.abhiroop;

import javax.swing.*;
import java.awt.*;

public class LineDrawer extends Canvas {
    //center origin
    private final int xOrigin;
    private final int yOrigin;

    public LineDrawer(JFrame displayWindow) {
        //set Background Color
        setBackground(Color.white);

        //get origin of the displayWindow
        xOrigin = (displayWindow.getX() + displayWindow.getWidth()) / 2;
        yOrigin = (displayWindow.getY() + displayWindow.getHeight() / 2);

    }

    /**
     * Draws a point in plane at position (x,y)
     * @param g  the Graphics Object
     */
    private void drawPoint(Graphics g, int x, int y){
        g.drawLine(xOrigin + x, yOrigin - y, xOrigin + x, yOrigin - y);
    }

    private void drawLineDDA(Graphics g, int  x1, int y1, int x2, int y2){
        int dx = x2 - x1;
        int dy = y2 - y1;

        int numPoints = Math.max(Math.abs(dx), Math.abs(dy));

        float xInc = (float)dx / numPoints;
        float yInc = (float)dy / numPoints;

        float x = x1;
        float y = y1;

        for (int i = 0; i < numPoints; i++) {
            drawPoint(g, Math.round(x), Math.round(y));
            x = x + xInc;
            y = y + yInc;
        }
    }

    private void drawLineBresenham(Graphics g, int  x1, int y1, int x2, int y2){
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = x2 > x1 ? 1 : -1;
        int sy = y2 > y1 ? 1 : -1;

        int bigGradient = Math.max(dx, dy);
        int smallGradient = Math.min(dx, dy);

        int p = 2*smallGradient - bigGradient;

        for(int i= 0; i< bigGradient; i++){
            drawPoint(g, x1, y1);
            if(p < 0)
                p = p + 2*smallGradient;
            else{
                p = p + 2*smallGradient - 2*bigGradient;

                if(smallGradient == dy)
                    y1 = y1 + sy;
                else
                    x1 = x1 + sx;
            }

            if(bigGradient == dx)
                x1 = x1 + sx;
            else
                y1 = y1 + sy;
        }
   }

    private void drawLineMidPoint(Graphics g, int x1, int y1, int x2, int y2){
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        int err = dx-dy;
        int e2;

        while (true) {
            drawPoint(g, x1, y1);

            if (x1 == x2 && y1 == y2)
                break;

            e2 = 2 * err;

            if (e2 > -dy) {
                err = err - dy;
                x1 = x1 + sx;
            }

            if (e2 < dx) {
                err = err + dx;
                y1 = y1 + sy;
            }
        }
    }

    /**
     * Paints this canvas.
     * <p>
     * Most applications that subclass {@code Canvas} should
     * override this method in order to perform some useful operation
     * (typically, custom painting of the canvas).
     * The default operation is simply to clear the canvas.
     * Applications that override this method need not call
     * super.paint(g).
     *
     * @param g the specified Graphics context
     * @see #update(Graphics)
     * @see Component#paint(Graphics)
     */
    @Override
    public void paint(Graphics g) {
        int length = 100;

//        var angle = 60;
        for(int angle = 0; angle <= 360; angle += 30){
            int x2 = (int)Math.round(length * Math.cos(angle * Math.PI /180));
            int y2 = (int)Math.round(length * Math.sin(angle * Math.PI /180));
            drawLineMidPoint(g, 0, 0, x2 , y2);
        }
    }
}
