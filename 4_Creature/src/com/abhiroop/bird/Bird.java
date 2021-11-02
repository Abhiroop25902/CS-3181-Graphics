package com.abhiroop.bird;

import com.abhiroop.bird.beak.Beak;
import com.abhiroop.bird.body.Body;
import com.abhiroop.bird.ear.Ear;
import com.abhiroop.bird.head.Head;
import com.abhiroop.bird.legs.Legs;
import com.abhiroop.bird.tail.Tail;
import com.abhiroop.bird.utils.Shape;

import java.awt.*;

public class Bird implements Shape {
    private final int xOrigin;
    private final int yOrigin;
    private final boolean beakBig;
    private final boolean beakTeeth;
    private final boolean earCircle;
    private final boolean bodySpotted;
    private final boolean bodyHair;
    private final int tailType;
    private final boolean spottedLeg;
    private final boolean hairLeg;
    private final boolean legLong;


    public Bird(int xOrigin,
                int yOrigin,
                boolean beakBig,
                boolean beakTeeth,
                boolean earCircle,
                boolean bodySpotted,
                boolean bodyHair,
                int tailType,
                boolean spottedLeg,
                boolean hairLeg,
                boolean legLong) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.beakBig = beakBig;
        this.beakTeeth = beakTeeth;
        this.earCircle = earCircle;
        this.bodySpotted = bodySpotted;
        this.bodyHair = bodyHair;
        this.tailType = tailType;
        this.spottedLeg = spottedLeg;
        this.hairLeg = hairLeg;
        this.legLong = legLong;
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

        new Tail(xOrigin, yOrigin, tailType)
                .drawShape(g, startX + 220, startY - 150);

        new Body(xOrigin, yOrigin, bodySpotted, bodyHair)
                .drawShape(g, startX + 140, startY - 100);

        new Legs(xOrigin, yOrigin, spottedLeg, hairLeg, legLong)
                .drawShape(g, startX+200, startY - 200);

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
