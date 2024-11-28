package com._2p1team.cmadmin.visible;

import com._2p1team.cmadmin.apperance.*;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.frame.Frame;

import java.awt.Color;
import java.awt.Rectangle;

class UIVisibilityTester {
  public static void main(String[] args) {
    Frame frame = new Frame();
    frame.setLayout(null);

    Panel panel = new Panel(new Rectangle(100, 100, 100, 100),
      new Appearance(
        new BackgroundPaint(Color.darkGray, Color.darkGray),
        new BorderPaint(3, 40, Color.pink, Color.red)
      )
    );

    frame.add(panel);
    frame.setVisible(true);
    frame.repaint();
  }
}