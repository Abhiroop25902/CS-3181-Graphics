package com.abhiroop;

import com.abhiroop.prereq.BaseGraph;
import com.abhiroop.Bird.Bird;

import javax.swing.*;
import java.awt.*;

public class ShapeDisplay extends BaseGraph {
    public ShapeDisplay(JFrame displayWindow) {
        super(displayWindow);
    }

//    void drawShape(Graphics g, Shape shape, int startX, int startY){
//        shape.drawShape(g, startX, startY);
//    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        new Bird(
                super.getXOrigin(),
                super.getYOrigin(),
                true,
                true,
                true
        )
                .drawShape(g, -400, 400);
    }
}
