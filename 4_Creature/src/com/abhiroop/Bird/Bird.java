package com.abhiroop.Bird;

import com.abhiroop.Bird.Beak.Beak;
import com.abhiroop.Bird.Ear.Ear;
import com.abhiroop.Bird.Head.Head;

import java.awt.*;

public class Bird implements Shape{
    private final int xOrigin;
    private final int yOrigin;
    private final boolean beakBig;
    private final boolean beakTeeth;
    private final boolean earCircle;


    public Bird(int xOrigin,
                int yOrigin,
                boolean beakBig,
                boolean beakTeeth,
                boolean earCircle) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.beakBig = beakBig;
        this.beakTeeth = beakTeeth;
        this.earCircle = earCircle;
    }

    /**
     * Draws the shape
     *
     * @param g      the Graphics Object
     * @param startX start x-position of the Shape
     * @param startY start y-position of the Shape
     */
    @Override
    public void drawShape(Graphics g, int startX, int startY) {

        if(beakBig)
            new Head(xOrigin, yOrigin)
                    .drawShape(g, startX + 70, startY);
        else
            new Head(xOrigin, yOrigin)
                    .drawShape(g, startX + 55, startY);

        new Ear(xOrigin, yOrigin, earCircle)
                .drawShape(g, startX + 100, startY + 30);

        new Beak(xOrigin, yOrigin, beakBig, beakTeeth)
                .drawShape(g, startX, startY);
    }
}
