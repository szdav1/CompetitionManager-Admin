package com._2p1team.cmadmin.visible;

import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.AppearanceBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;


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
                .enableInteractivity()
                .setBackgroundConfiguration(
                    new BackgroundConfigurationBuilder()
                        .setDefaultConfiguration(new LinearGradientPaintConfiguration(Color.cyan))
                        .build()
                )
                .setBorderConfiguration(
                    new BorderConfiguration(
                        2,
                        140,
                        new SimplePaintConfiguration(Color.white),
                        new LinearGradientPaintConfiguration(Color.black),
                        new LinearGradientPaintConfiguration(Color.darkGray),
                        new LinearGradientPaintConfiguration(Color.black)
                    )
                )
                .build()
        );

        Label l = new Label(
            new Rectangle(450, 100, 300, 300),
            "Hello Label!",
            new AppearanceBuilder()
                .enableInteractivity()
                .setBackgroundConfiguration(
                    new BackgroundConfiguration(
                        new SimplePaintConfiguration(Color.white),
                        new LinearGradientPaintConfiguration(Color.white, Color.red)
                    )
                )
                .setForegroundConfiguration(new ForegroundConfiguration(Color.white, Color.pink))
                .setBorderConfiguration(
                    new BorderConfiguration(
                        3,
                        40,
                        new SimplePaintConfiguration(Color.black)
                    )
                )
                .build()
        );

        frame.add(l);
        frame.add(p);
        frame.repaint();
        frame.setVisible(true);
    }
}