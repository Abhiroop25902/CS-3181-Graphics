package com.abhiroop.part1;

import javax.swing.*;
import java.awt.*;

public class LineDisplay extends Canvas {
    //center origin
    private final int xOrigin;
    private final int yOrigin;

    public LineDisplay(JFrame displayWindow) {
        //set Background Color
        setBackground(Color.white);

        //get origin of the displayWindow
        xOrigin = (displayWindow.getX() + displayWindow.getWidth()) / 2;
        yOrigin = (displayWindow.getY() + displayWindow.getHeight() / 2);

    }



    private void drawLineCircle(Graphics g, int length, int xCenter, int yCenter, LineDrawer lineDrawer, String text){
        for(int angle = 0; angle <= 360; angle += 30){
            int x2 = xCenter + (int)Math.round(length * Math.cos(angle * Math.PI /180));
            int y2 = yCenter + (int)Math.round(length * Math.sin(angle * Math.PI /180));
            lineDrawer.draw(g, xCenter, yCenter, x2 , y2);
        }

        g.drawString(text, xOrigin + xCenter - text.length()/2*10, yOrigin - yCenter + length + 30);
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
        drawLineCircle(g, 100, -200, 200, new DDA(xOrigin, yOrigin), "DDA");
        drawLineCircle(g, 100, 200, 200, new Bresenham(xOrigin, yOrigin), "Bresenham");
        drawLineCircle(g, 100, 0, -200, new MidPoint(xOrigin, yOrigin), "Mid Point");
    }
}
