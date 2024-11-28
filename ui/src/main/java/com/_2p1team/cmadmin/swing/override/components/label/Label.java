package com._2p1team.cmadmin.swing.override.components.label;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com._2p1team.cmadmin.apperance.Appearance;
import com._2p1team.cmadmin.swing.override.ComponentGraphicsHandler;

public class Label extends AbstractLabel {
  public Label(Dimension preferredSize, String text, Appearance appearance) {
    super(preferredSize, text, appearance);
  }

  public Label(Dimension preferredSize, Appearance appearance) {
    super(preferredSize, appearance);
  }

  public Label(Rectangle bounds, String text, Appearance appearance) {
    super(bounds, text, appearance);
  }

  public Label(Rectangle bounds, Appearance appearance) {
    super(bounds, appearance);
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    Rectangle paintSurface = g2.getClipBounds();
    int x = paintSurface.x;
    int y = paintSurface.y;
    int width = paintSurface.width;
    int height = paintSurface.height;

    ComponentGraphicsHandler.paintBackground(g2, x, y, width, height, this.getAppearance());
    ComponentGraphicsHandler.paintBorder(g2, x, y, width, height, this.getAppearance());
    super.paint(g);
    g2.dispose();
  }
}
