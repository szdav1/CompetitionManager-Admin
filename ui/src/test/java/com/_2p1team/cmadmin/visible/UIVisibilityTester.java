package com._2p1team.cmadmin.visible;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.AppearanceBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

class UIVisibilityTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Panel p = new Panel(
            new Rectangle(100, 100, 300, 300),
            new AppearanceBuilder()
                .setBackgroundConfiguration(
                    new BackgroundConfiguration(
                        new LinearGradientPaintConfiguration(Color.black, Color.cyan),
                        new SimplePaintConfiguration(Color.white)
//                        new LinearGradientPaintConfiguration(Color.white),
//                        new LinearGradientPaintConfiguration(Color.red),
//                        new LinearGradientPaintConfiguration(Color.cyan)
                    )
                )
                .setBorderConfiguration(
                    new BorderConfiguration(
                        2,
                        140,
                        new SimplePaintConfiguration(Color.white)
//                        new LinearGradientPaintConfiguration(Color.black),
//                        new LinearGradientPaintConfiguration(Color.darkGray),
//                        new LinearGradientPaintConfiguration(Color.black)
                    )
                )
                .build()
        );

        frame.add(p);
        frame.repaint();
        frame.setVisible(true);
    }
}