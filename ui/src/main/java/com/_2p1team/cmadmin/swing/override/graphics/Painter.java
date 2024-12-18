package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.Point2D;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Painter {
    private static LinearGradientPaint determineBackgroundPaint(final Point2D start, final Point2D end, final Appearance appearance) {
        return appearance.isInteractivityEnabled() ?
            new LinearGradientPaint(
                start,
                end,
                switch (appearance.getState()) {
                    case HOVERED -> appearance.getBackgroundConfiguration()
                        .getHoveredConfiguration()
                        .getFractions();

                    case PRESSED -> appearance.getBackgroundConfiguration()
                        .getPressedConfiguration()
                        .getFractions();

                    case RELEASED -> appearance.getBackgroundConfiguration()
                        .getReleasedConfiguration()
                        .getFractions();

                    default -> appearance.getBackgroundConfiguration()
                        .getDefaultConfiguration()
                        .getFractions();

                },
                switch (appearance.getState()) {
                    case HOVERED -> appearance.getBackgroundConfiguration()
                        .getHoveredConfiguration()
                        .getColors();

                    case PRESSED -> appearance.getBackgroundConfiguration()
                        .getPressedConfiguration()
                        .getColors();

                    case RELEASED -> appearance.getBackgroundConfiguration()
                        .getReleasedConfiguration()
                        .getColors();

                    default -> appearance.getBackgroundConfiguration()
                        .getDefaultConfiguration()
                        .getColors();

                }
            ) :
            new LinearGradientPaint(
                start,
                end,
                appearance.getBackgroundConfiguration()
                    .getDefaultConfiguration()
                    .getFractions(),
                appearance.getBackgroundConfiguration()
                    .getDefaultConfiguration()
                    .getColors()
            );
    }

    public static void paintBackground(final Graphics2D g2, Point2D start, Point2D end, final Appearance appearance) {
        Rectangle paintSurface = g2.getClipBounds();
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        LinearGradientPaint lgp = determineBackgroundPaint(start, end, appearance);

        g2.setPaint(lgp);
        g2.fillRoundRect(
            (int) start.getX(),
            (int) start.getY(),
            (int) end.getX(),
            (int) end.getY(),
            appearance.getBorderConfiguration().getRadius(),
            appearance.getBorderConfiguration().getRadius()
        );
    }

    private static LinearGradientPaint determineBorderPaint(final Point2D start, final Point2D end, final Appearance appearance) {
        return appearance.isInteractivityEnabled() ?
            new LinearGradientPaint(
                start,
                end,
                switch (appearance.getState()) {
                    case HOVERED -> appearance.getBorderConfiguration()
                        .getHoveredConfiguration()
                        .getFractions();

                    case PRESSED -> appearance.getBorderConfiguration()
                        .getPressedConfiguration()
                        .getFractions();

                    case RELEASED -> appearance.getBorderConfiguration()
                        .getReleasedConfiguration()
                        .getFractions();

                    default -> appearance.getBorderConfiguration()
                        .getDefaultConfiguration()
                        .getFractions();
                },
                switch (appearance.getState()) {
                    case HOVERED -> appearance.getBorderConfiguration()
                        .getHoveredConfiguration()
                        .getColors();

                    case PRESSED -> appearance.getBorderConfiguration()
                        .getPressedConfiguration()
                        .getColors();

                    case RELEASED -> appearance.getBorderConfiguration()
                        .getReleasedConfiguration()
                        .getColors();

                    default -> appearance.getBorderConfiguration()
                        .getDefaultConfiguration()
                        .getColors();
                }
            ) :
            new LinearGradientPaint(
                start,
                end,
                appearance.getBorderConfiguration()
                    .getDefaultConfiguration()
                    .getFractions(),
                appearance.getBorderConfiguration()
                    .getDefaultConfiguration()
                    .getColors()
            );
    }

    public static void paintBorder(final Graphics2D g2, Point2D start, Point2D end, final Appearance appearance) {
        if (appearance.getBorderConfiguration().getThickness() <= 0 && appearance.getBorderConfiguration().getRadius() <= 0)
            return;

        Rectangle paintSurface = g2.getClipBounds();
        g2.setStroke(new BasicStroke(appearance.getBorderConfiguration().getThickness()));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        LinearGradientPaint lgp = determineBorderPaint(start, end, appearance);

        g2.setPaint(lgp);
        g2.drawRoundRect(
            (int) start.getX()+(appearance.getBorderConfiguration().getThickness()/2),
            (int) start.getY()+(appearance.getBorderConfiguration().getThickness()/2),
            (int) end.getX()-(appearance.getBorderConfiguration().getThickness()),
            (int) end.getY()-(appearance.getBorderConfiguration().getThickness()),
            appearance.getBorderConfiguration().getRadius(),
            appearance.getBorderConfiguration().getRadius()
        );
    }

    public static <C extends JComponent & AppearanceComponent> void paint(final Graphics2D g2, final C component) {
        Rectangle paintBounds = g2.getClipBounds();
        Point2D start = new Point2D.Double(0, 0);
        Point2D end = new Point2D.Double(component.getWidth(), component.getHeight());

        paintBackground(g2, start, end, component.getComponentAppearance());
        paintBorder(g2, start, end, component.getComponentAppearance());
    }
}