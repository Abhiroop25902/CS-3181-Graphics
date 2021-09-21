package com.abhiroop.part3;

import com.abhiroop.part1.CircleDrawer;
import com.abhiroop.part2.EllipseDrawer;
import com.abhiroop.prereq.BaseGraph;

import javax.swing.*;
import java.awt.*;

public class ShapeDisplay extends BaseGraph {
    public ShapeDisplay(JFrame displayWindow) {
        super(displayWindow);
    }

    void drawShape(Graphics g, Shape shape, int startX, int startY){
        shape.drawShape(g, startX, startY);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawShape(  g,
                    new Shape_One(  new EllipseDrawer(super.getXOrigin(), super.getYOrigin()),
                                    new CircleDrawer(super.getXOrigin(), super.getYOrigin()),
                                    200, 100,10, 20)
                    , -300,0);
    }
}
