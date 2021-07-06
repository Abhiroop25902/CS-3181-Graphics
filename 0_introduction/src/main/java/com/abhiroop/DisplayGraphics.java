package com.abhiroop;

import java.awt.*;

public final class DisplayGraphics extends Canvas {

    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);

        g.drawString("Hello Abhiroop", 50, 100);
        g.fillRect(150, 50, 100, 100);
        g.drawRect(280, 50, 200, 100);
        g.drawOval(510, 50, 100, 100);
        g.fillOval(640, 50, 80, 100);
        g.drawArc(750, 50, 100, 100, 90, 180);
        g.fillArc(750, 50, 100, 100, 270, 180);
    }
}


