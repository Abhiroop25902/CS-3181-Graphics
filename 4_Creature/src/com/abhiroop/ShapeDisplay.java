package com.abhiroop;

import com.abhiroop.prereq.BaseGraph;
import com.abhiroop.bird.Bird;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ShapeDisplay extends BaseGraph {
    public ShapeDisplay(JFrame displayWindow) {
        super(displayWindow);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        new Bird(
                super.getXOrigin(),
                super.getYOrigin(),
                true,
                true,
                true,
                true,
                true,
                2,
                false,
                false,
                false
        )
                .drawShape(g, -400, 400);


    }
}
