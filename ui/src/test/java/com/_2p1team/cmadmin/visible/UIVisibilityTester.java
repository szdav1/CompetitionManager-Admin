package com._2p1team.cmadmin.visible;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.AppearanceBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;

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
                        new LinearGradientPaintConfiguration(Color.red, Color.black, Color.white, Color.pink),
                        new LinearGradientPaintConfiguration(Color.gray, Color.white)
                    )
                )
                .setBorderConfiguration(
                    new BorderConfiguration(
                        2,
                        140,
                        new LinearGradientPaintConfiguration(Color.blue),
                        new LinearGradientPaintConfiguration(Color.gray)
                    )
                )
                .build()
        );

        frame.add(p);
        frame.repaint();
        frame.setVisible(true);
    }
}