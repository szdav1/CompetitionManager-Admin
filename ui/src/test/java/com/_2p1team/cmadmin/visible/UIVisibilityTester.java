package com._2p1team.cmadmin.visible;

import java.awt.Color;
import java.awt.Rectangle;

import com._2p1team.cmadmin.apperance.*;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.frame.Frame;

class UIVisibilityTester {
  public static void main(String[] args) {
    Frame frame = new Frame();

    Panel panel = new Panel(new Rectangle(600, 600, 600, 600),
      new Appearance(
        new BackgroundPaint(),
        new BorderPaint(0, 40)
      )
    );

    Label label = new Label(new Rectangle(100, 100, 300, 300), "Label Text",
      new Appearance(
        new BackgroundPaint(Color.black, Color.red),
        new ForegroundPaint(Color.white),
        new IconSet(),
        new BorderPaint(3, 40, Color.black)
      )
    );

    frame.requestFocusInWindow();
    frame.setLayout(null);
    frame.add(panel);
    frame.add(label);
    frame.setVisible(true);
    frame.repaint();
  }
}