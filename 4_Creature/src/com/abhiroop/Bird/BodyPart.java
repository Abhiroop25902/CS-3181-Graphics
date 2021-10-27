package com.abhiroop.Bird;

import com.abhiroop.prereq.circleGenerator.CircleGenerator;
import com.abhiroop.prereq.ellipseGenerator.EllipseGenerator;
import com.abhiroop.prereq.lineGenerator.BresenhamGenerator;

import java.awt.*;
import java.util.Random;

public class BodyPart implements Shape {
    private final int xOrigin;
    private final int yOrigin;
    private final Random rand;
    private final int xRad;
    private final int yRad;
    private final int numEntities;
    private final int entityDimension;
    private final boolean spotted;
    private final boolean hair;

    /**
     * Draws an ellipse and then multiple circles inside it
     * @param xOrigin xOrigin of the Frame
     * @param yOrigin yOrigin of the Frame
     * @param xRad the x-axis radius length of the ellipse
     * @param yRad the y-axis radius length of the ellipse
     * @param numEntities number of circles to be made inside the ellipse
     * @param entityDimension maximum possible radius of the circles
     */
    public BodyPart(int xOrigin,
                    int yOrigin,
                    int xRad,
                    int yRad,
                    int numEntities,
                    int entityDimension,
                    boolean spotted,
                    boolean hair) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.xRad = xRad;
        this.yRad = yRad;
        this.numEntities = numEntities;
        this.entityDimension = entityDimension;
        this.rand = new Random(System.currentTimeMillis());
        this.spotted = spotted;
        this.hair = hair;
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
//        ellipseDrawer.draw(g, startX,startY, xRad, yRad);

        EllipseGenerator
                .generate(startX, startY, xRad, yRad)
                .generateFill()
                .toMatrix()
                .rotateInPlace(-45)
                .toDrawForm()
                .draw(g, xOrigin, yOrigin, Color.WHITE);

        EllipseGenerator
                .generate(startX, startY, xRad, yRad)
                .toMatrix()
                .rotateInPlace(-45)
                .toDrawForm()
                .draw(g, xOrigin, yOrigin, Color.BLACK);



        if(spotted){
            for(var i = 0; i< numEntities; i++)
                CircleGenerator
                        .generate(
                                startX + rand(-(xRad - entityDimension - 10), xRad - entityDimension - 10),
                                startY + rand(-(yRad - entityDimension - 10), yRad - entityDimension - 10),
                                entityDimension)
                        .toMatrix()
                        .rotateInPlace(-45, startX, startY)
                        .toDrawForm()
                        .draw(g, xOrigin, yOrigin, Color.BLACK);
        }


        if(hair){
            for(var i = 0; i<numEntities;i++){
                var degree = rand(0,360) * Math.PI / 180;
                int xInitial = startX + (int)((xRad - entityDimension/2)*Math.cos(degree));
                int yInitial = startY + (int)((yRad - entityDimension/2)*Math.sin(degree));
                int xFinal = xInitial + (int)(3*entityDimension*Math.cos(degree));
                int yFinal = yInitial + (int)(3*entityDimension*Math.sin(degree));
                new BresenhamGenerator()
                        .generate(xInitial, yInitial, xFinal, yFinal)
                        .toMatrix()
                        .rotateInPlace(-45, startX, startY)
                        .toDrawForm()
                        .draw(g, xOrigin, yOrigin, Color.BLACK);
            }
        }
    }
}
