package com._2p1team.cmadmin.visible;

import java.awt.Color;
import java.awt.Rectangle;

import com._2p1team.cmadmin.apperance.Appearance;
import com._2p1team.cmadmin.apperance.BackgroundPaint;
import com._2p1team.cmadmin.apperance.BorderPaint;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.frame.Frame;

class UIVisibilityTester {
  public static void main(String[] args) {
    Frame frame = new Frame();
    frame.setLayout(null);

    Panel panel = new Panel(new Rectangle(100, 100, 100, 100),
      new Appearance(
        new BackgroundPaint(Color.red, Color.black),
        new BorderPaint()
      )
    );

    frame.add(panel);
    frame.setVisible(true);
    frame.repaint();
  }
}