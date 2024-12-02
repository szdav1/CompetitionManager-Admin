package com._2p1team.cmadmin.swing.override.graphics;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Painter {
  public static void paintBackground(final Graphics2D g2, Point2D start, Point2D end, final Appearance appearance) {
    Rectangle paintSurface = g2.getClipBounds();
    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    LinearGradientPaint lgp = new LinearGradientPaint(
      start,
      end,
      switch (appearance.state()) {
        case HOVERED -> appearance.backgroundHint().getHoveredHint().getFractions();
        case PRESSED -> appearance.backgroundHint().getPressedHint().getFractions();
        case RELEASED -> appearance.backgroundHint().getReleasedHint().getFractions();
        default -> appearance.backgroundHint().getDefaultHint().getFractions();
      },
      switch (appearance.state()) {
        case HOVERED -> appearance.backgroundHint().getHoveredHint().getColors();
        case PRESSED -> appearance.backgroundHint().getPressedHint().getColors();
        case RELEASED -> appearance.backgroundHint().getReleasedHint().getColors();
        default -> appearance.backgroundHint().getDefaultHint().getColors();
      }
    );

    g2.setPaint(lgp);
    g2.fillRoundRect(
      (int) start.getX(),
      (int) start.getY(),
      (int) end.getX(),
      (int) end.getY(),
      appearance.borderHint().getRadius(),
      appearance.borderHint().getRadius()
    );
  }

  public static void paintBorder(final Graphics2D g2, Point2D start, Point2D end, final Appearance appearance) {
    Rectangle paintSurface = g2.getClipBounds();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    LinearGradientPaint lgp = new LinearGradientPaint(
      start,
      end,
      switch (appearance.state()) {
        case HOVERED -> appearance.backgroundHint().getHoveredHint().getFractions();
        case PRESSED -> appearance.backgroundHint().getPressedHint().getFractions();
        case RELEASED -> appearance.backgroundHint().getReleasedHint().getFractions();
        default -> appearance.backgroundHint().getDefaultHint().getFractions();
      },
      switch (appearance.state()) {
        case HOVERED -> appearance.backgroundHint().getHoveredHint().getColors();
        case PRESSED -> appearance.backgroundHint().getPressedHint().getColors();
        case RELEASED -> appearance.backgroundHint().getReleasedHint().getColors();
        default -> appearance.backgroundHint().getDefaultHint().getColors();
      }
    );

    g2.setPaint(lgp);
    g2.drawRoundRect(
      (int) start.getX(), // TODO
      (int) start.getY(),
      (int) end.getX(),
      (int) end.getY(),
      appearance.borderHint().getRadius(),
      appearance.borderHint().getRadius()
    );
  }
}