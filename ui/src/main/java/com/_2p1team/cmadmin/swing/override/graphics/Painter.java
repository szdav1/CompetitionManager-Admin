package com._2p1team.cmadmin.swing.override.graphics;

import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Painter {
    public static void paintBackground(final Graphics2D g2, Point2D start, Point2D end, final Appearance appearance) {
        Rectangle paintSurface = g2.getClipBounds();
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        LinearGradientPaint lgp = new LinearGradientPaint(
            start,
            end,
            switch (appearance.getState()) {
                case HOVERED -> appearance.getBackgroundHint().getHoveredHint().getFractions();
                case PRESSED -> appearance.getBackgroundHint().getPressedHint().getFractions();
                case RELEASED -> appearance.getBackgroundHint().getReleasedHint().getFractions();
                default -> appearance.getBackgroundHint().getDefaultHint().getFractions();
            },
            switch (appearance.getState()) {
                case HOVERED -> appearance.getBackgroundHint().getHoveredHint().getColors();
                case PRESSED -> appearance.getBackgroundHint().getPressedHint().getColors();
                case RELEASED -> appearance.getBackgroundHint().getReleasedHint().getColors();
                default -> appearance.getBackgroundHint().getDefaultHint().getColors();
            }
        );

        g2.setPaint(lgp);
        g2.fillRoundRect(
            (int) start.getX(),
            (int) start.getY(),
            (int) end.getX(),
            (int) end.getY(),
            appearance.getBorderHint().getRadius(),
            appearance.getBorderHint().getRadius()
        );
    }

    public static void paintBorder(final Graphics2D g2, Point2D start, Point2D end, final Appearance appearance) {
        Rectangle paintSurface = g2.getClipBounds();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        LinearGradientPaint lgp = new LinearGradientPaint(
            start,
            end,
            switch (appearance.getState()) {
                case HOVERED -> appearance.getBorderHint().getHoveredHint().getFractions();
                case PRESSED -> appearance.getBorderHint().getPressedHint().getFractions();
                case RELEASED -> appearance.getBorderHint().getReleasedHint().getFractions();
                default -> appearance.getBorderHint().getDefaultHint().getFractions();
            },
            switch (appearance.getState()) {
                case HOVERED -> appearance.getBorderHint().getHoveredHint().getColors();
                case PRESSED -> appearance.getBorderHint().getPressedHint().getColors();
                case RELEASED -> appearance.getBorderHint().getReleasedHint().getColors();
                default -> appearance.getBorderHint().getDefaultHint().getColors();
            }
        );

        g2.setPaint(lgp);
        g2.drawRoundRect(
            (int) start.getX()+(appearance.getBorderHint().getThickness()/2),
            (int) start.getY()+(appearance.getBorderHint().getThickness()/2),
            (int) end.getX(),
            (int) end.getY(),
            appearance.getBorderHint().getRadius(),
            appearance.getBorderHint().getRadius()
        );
    }
}