package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.components.label.AbstractLabel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import javax.swing.AbstractButton;
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

    private static <C extends JComponent & AppearanceComponent> void setFontOfComponent(final C component) {
        component.setFont(
            switch (component.getComponentAppearance().getState()) {
                case HOVERED -> component.getComponentAppearance()
                    .getFontSet()
                    .getHoveredFont();

                case PRESSED -> component.getComponentAppearance()
                    .getFontSet()
                    .getPressedFont();

                case RELEASED -> component.getComponentAppearance()
                    .getFontSet()
                    .getReleasedFont();

                default -> component.getComponentAppearance()
                    .getFontSet()
                    .getDefaultFont();
            }
        );
    }

    private static <C extends JComponent & AppearanceComponent> void setForegroundOfComponent(final C component) {
        component.setForeground(
            switch (component.getComponentAppearance().getState()) {
                case HOVERED -> component.getComponentAppearance()
                    .getForegroundConfiguration()
                    .getHoveredColor();

                case PRESSED -> component.getComponentAppearance()
                    .getForegroundConfiguration()
                    .getPressedColor();

                case RELEASED -> component.getComponentAppearance()
                    .getForegroundConfiguration()
                    .getReleasedColor();

                default -> component.getComponentAppearance()
                    .getForegroundConfiguration()
                    .getDefaultColor();
            }
        );
    }

    private static <C extends JComponent & AppearanceComponent> void setIconOfComponent(final C component) {
        if (component instanceof AbstractLabel label) {
            label.setIcon(
                switch (component.getComponentAppearance().getState()) {
                    case HOVERED -> component.getComponentAppearance()
                        .getIconSet()
                        .getHoveredIcon();

                    case PRESSED -> component.getComponentAppearance()
                        .getIconSet()
                        .getPressedIcon();

                    case RELEASED -> component.getComponentAppearance()
                        .getIconSet()
                        .getReleasedIcon();

                    default -> component.getComponentAppearance()
                        .getIconSet()
                        .getDefaultIcon();
                }
            );
        }
        else if (component instanceof AbstractButton button) {
            button.setIcon(
                switch (component.getComponentAppearance().getState()) {
                    case HOVERED -> component.getComponentAppearance()
                        .getIconSet()
                        .getHoveredIcon();

                    case PRESSED -> component.getComponentAppearance()
                        .getIconSet()
                        .getPressedIcon();

                    case RELEASED -> component.getComponentAppearance()
                        .getIconSet()
                        .getReleasedIcon();

                    default -> component.getComponentAppearance()
                        .getIconSet()
                        .getDefaultIcon();
                }
            );
        }
    }

    // TODO: Use this method in mouse... inherited methods instead of individual drawing
    public static <C extends JComponent & AppearanceComponent> void drawComponentUIElements(final C component) {
        if (!component.getComponentAppearance().isInteractivityEnabled())
            return;

        setFontOfComponent(component);
        setForegroundOfComponent(component);
        setIconOfComponent(component);
        component.repaint();
    }
}