package com.abhiroop.part3;

import com.abhiroop.part1.CircleDrawer;
import com.abhiroop.part2.EllipseDrawer;

import java.awt.*;
import java.util.Random;

public class Shape_One implements Shape{
    private final EllipseDrawer ellipseDrawer;
    private final CircleDrawer circleDrawer;
    private final Random rand;
    private final int radX;
    private final int radY;
    private final int numCircles;
    private final int radCircle;

    /**
     * Draws an ellipse and then multiple circles inside it
     * @param ellipseDrawer the EllipseDrawer Object
     * @param circleDrawer the CircleDrawer Object
     * @param radX the x-axis radius length of the ellipse
     * @param radY the y-axis radius length of the ellipse
     * @param numCircles number of circles to be made inside the ellipse
     * @param maxRadCircle maximum possible radius of the circles
     */
    public Shape_One( EllipseDrawer ellipseDrawer, CircleDrawer circleDrawer, int radX, int radY, int numCircles, int maxRadCircle) {
        this.ellipseDrawer = ellipseDrawer;
        this.circleDrawer = circleDrawer;
        this.radX = radX;
        this.radY = radY;
        this.numCircles = numCircles;
        this.radCircle = maxRadCircle;
        this.rand = new Random(System.currentTimeMillis());
    }

    private int rand(int min, int max){
        return rand.nextInt(max - min) + min;
    }

    /**
     *
     * @param g     the Graphics Object
     * @param startX    start x-position of the Shape (x-center of the oval)
     * @param startY    start y-position of the Shape (y-center of the oval)
     */
    @Override
    public void drawShape(Graphics g, int startX, int startY) {
        ellipseDrawer.draw(g, startX,startY,radX,radY);

        for(var i=0;i<numCircles;i++)
            circleDrawer.draw(g, startX + rand(-(radX - 50), radX - 50),startY + rand(-(radY - 50), radY - 50), rand(5,radCircle));
    }
}
