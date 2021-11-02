package com.abhiroop.bird.legs;

import com.abhiroop.bird.utils.Shape;

import java.awt.*;

public class Legs implements Shape {
    private final int xOrigin;
    private final int yOrigin;
    private final boolean spotted;
    private final boolean hair;
    private final boolean sizeLong;

    /**
     *
     * @param xOrigin xOrigin
     * @param yOrigin yOrigin
     */
    public Legs(int xOrigin,
                int yOrigin,
                boolean spotted,
                boolean hair,
                boolean sizeLong) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.spotted = spotted;
        this.hair = hair;
        this.sizeLong = sizeLong;
    }

    /**
     *
     * @param g     the Graphics Object
     * @param startX    start x-position of the Shape (x-center of the oval)
     * @param startY    start y-position of the Shape (y-center of the oval)
     */
    @Override
    public void drawShape(Graphics g, int startX, int startY) {
        new LeftLeg(xOrigin, yOrigin, spotted, hair, sizeLong).drawShape(g, startX - 50, startY - 40);
        new RightLeg(xOrigin, yOrigin, spotted, hair, sizeLong).drawShape(g, startX, startY);
    }
}
