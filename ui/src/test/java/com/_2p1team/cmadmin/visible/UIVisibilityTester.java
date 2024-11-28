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
        new BackgroundPaint(Color.red, Color.darkGray, Color.black, Color.cyan),
        new BorderPaint(3, 40)
      )
    );

    frame.add(panel);
    frame.setVisible(true);
    frame.repaint();
  }
}