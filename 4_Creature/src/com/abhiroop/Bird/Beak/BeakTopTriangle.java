package com.abhiroop.Bird.Beak;

import com.abhiroop.prereq.lineGenerator.BresenhamGenerator;
import com.abhiroop.Bird.Shape;

import java.awt.*;

public class BeakTopTriangle implements Shape {
    private final int xOrigin;
    private final int yOrigin;
    private int baseLength;
    private int heightLength;
    private int hairLength;

    public BeakTopTriangle(int xOrigin,
                           int yOrigin,
                           boolean big,
                           boolean teeth) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;

        if(big){
            baseLength = 40;
            heightLength = 20;
        }
        else{
            baseLength = 20;
            heightLength = 10;
        }

        if(teeth)
            hairLength = 5;
        else
            hairLength = 0;
    }
    /**
     *
     * @param g     the Graphics Object
     * @param startX    start x-position of the Shape (x-center of the oval)
     * @param startY    start y-position of the Shape (y-center of the oval)
     */
    @Override
    public void drawShape(Graphics g, int startX, int startY) {
        var line1 = new BresenhamGenerator()
                .generate(
                        startX,
                        startY,
                        startX + baseLength,
                        startY
                );

        var line2 = new BresenhamGenerator()
                .generate(
                        startX + baseLength,
                        startY,
                        startX + baseLength,
                        startY + heightLength
                );

        var line3 = new BresenhamGenerator()
                .generate(
                        startX + baseLength,
                        startY + heightLength,
                        startX,
                        startY
                );

        var triangle = line1.
                append(line2).
                append(line3);

        triangle.generateFill().draw(g, xOrigin, yOrigin, Color.WHITE);
        triangle.draw(g, xOrigin, yOrigin, Color.BLACK);

        for(var i = startX + hairLength; i < startX + baseLength; i += hairLength) {
            new BresenhamGenerator()
                    .generate(i, startY, i, startY - hairLength)
                            .draw(g, xOrigin, yOrigin, Color.BLACK);
        }
    }
}