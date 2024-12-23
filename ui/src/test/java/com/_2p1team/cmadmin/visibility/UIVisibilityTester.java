package com._2p1team.cmadmin.visibility;

import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.text.field.TextField;
import com._2p1team.cmadmin.swing.override.graphics.build.AppearanceBuilder;
import com._2p1team.cmadmin.swing.override.graphics.build.BackgroundConfigurationBuilder;
import com._2p1team.cmadmin.swing.override.graphics.build.BorderConfigurationBuilder;
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
                .setForegroundConfiguration(
                    new ForegroundConfiguration(
                        Color.black,
                        Color.red,
                        Color.gray,
                        Color.darkGray
                    )
                )
                .setBorderConfiguration(
                    new BorderConfiguration(
                        0,
                        40,
                        new SimplePaintConfiguration(Color.black)
                    )
                )
                .build()
        );

        Button btn = new Button(
            new Rectangle(0, 0, 200, 150),
            "Button",
            new AppearanceBuilder()
                .enableInteractivity()
                .setBackgroundConfiguration(
                    new BackgroundConfigurationBuilder()
                        .setDefaultConfiguration(new LinearGradientPaintConfiguration(Color.white, Color.black, Color.red))
                        .setPressedConfiguration(new LinearGradientPaintConfiguration(Color.red, Color.black, Color.white))
                        .build()
                )
                .setBorderConfiguration(
                    new BorderConfigurationBuilder()
                        .setThickness(2)
                        .setRadius(10)
                        .setDefaultConfiguration(new LinearGradientPaintConfiguration(Color.blue, Color.pink))
                        .build()
                )
                .build()
        );

        TextField tf = new TextField(
            new Rectangle(600, 600, 200, 100),
            "This is a text field",
            l.getAppearance()
        );

        frame.add(l);
        frame.add(p);
        frame.add(btn);
        frame.add(tf);
        frame.repaint();
        frame.setVisible(true);
    }
}