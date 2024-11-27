package com._2p1team.cmadmin.swing.override.components;

import java.awt.Graphics2D;

public interface CustomGraphics {
  void paintBackground(final Graphics2D g2, int x, int y, int width, int height);

  default void paintForeground() {
  }

  default void paintIcon() {
  }

  void paintBorder(final Graphics2D g2, int x, int y, int width, int height);
}
