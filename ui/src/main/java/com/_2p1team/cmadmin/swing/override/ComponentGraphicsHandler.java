package com._2p1team.cmadmin.swing.override;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import com._2p1team.cmadmin.apperance.Appearance;

public final class ComponentGraphicsHandler {
  public static void paintBackground(final Graphics2D g2, int x, int y, int width, int height, final Appearance appearance) {
    if (appearance.backgroundPaint().getColors().length < 2)
      return;

    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2.setPaint(appearance.backgroundPaint().createPaint(x, y, width, height));
    g2.fillRoundRect(x, y, width, height, appearance.borderPaint().getArcWidth(), appearance.borderPaint().getArcHeight());
  }

  public static void paintBorder(final Graphics2D g2, int x, int y, int width, int height, final Appearance appearance) {
    if (appearance.borderPaint().getThickness() <= 0 && appearance.borderPaint().arcs() <= 0)
      return;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setPaint(appearance.borderPaint().getPaint().createPaint(x, y, width, height));
    g2.setStroke(new BasicStroke(appearance.borderPaint().getThickness()));
    g2.drawRoundRect(
      x+(appearance.borderPaint().getThickness()/2),
      y+(appearance.borderPaint().getThickness()/2),
      width-appearance.borderPaint().getThickness(),
      height-appearance.borderPaint().getThickness(),
      appearance.borderPaint().getArcWidth(),
      appearance.borderPaint().getArcHeight()
    );
  }
}
