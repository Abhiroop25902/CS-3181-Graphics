package com.abhiroop;

import com.abhiroop.prereq.BaseGraph;
import com.abhiroop.prereq.circleGenerator.CircleGenerator;
import com.abhiroop.prereq.ellipseGenerator.EllipseGenerator;

import javax.swing.*;
import java.awt.*;

public class DisplayWindow extends BaseGraph {
    public DisplayWindow(JFrame displayWindow) {
        super(displayWindow);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

//        CircleGenerator
//                .generate(0,0,200)
//                .drawFill(g, super.getXOrigin(), super.getYOrigin(), Color.BLACK,Color.BLACK);
//
//        EllipseGenerator
//                .generate(0,0,100,200)
//                .drawFill(g,super.getXOrigin(), super.getYOrigin(), Color.RED, Color.BLACK);

        EllipseGenerator
                .generate(0,0,100,200)
                .toMatrix()
                .rotateInPlace(45)
                .toDrawForm()
                .drawFill(g,super.getXOrigin(), super.getYOrigin(), Color.RED, Color.BLACK);

//        EllipseGenerator
//                .generate(0,0,200,100)
//                .drawPoints(g,super.getXOrigin(), super.getYOrigin(), Color.GREEN);
//
//        CircleGenerator
//                .generate(0,0,100)
//                .drawFill(g, super.getXOrigin(), super.getYOrigin(), Color.RED, Color.BLACK);
//
//        CircleGenerator
//                .generate(0,0,50)
//                .drawFill(g, super.getXOrigin(), super.getYOrigin(), Color.BLACK, Color.BLACK);
//
//        EllipseGenerator
//                .generate(0,0,200,100)
//                .toMatrix()
//                .rotateInPlace(45)
//                .toDrawForm()
//                .drawPoints(g,super.getXOrigin(), super.getYOrigin(), Color.GREEN);
    }
}
