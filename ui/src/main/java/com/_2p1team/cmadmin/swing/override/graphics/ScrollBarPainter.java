package com._2p1team.cmadmin.swing.override.graphics;

import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class ScrollBarPainter {
    private static LinearGradientPaint createPaint(final ScrollBarAppearance appearance, final Rectangle paintBounds) {
        return new LinearGradientPaint(
            paintBounds.x,
            paintBounds.y,
            paintBounds.width,
            paintBounds.height,
            appearance.getBackgroundConfiguration()
                .getDefaultConfiguration()
                .getFractions(),
            appearance.getBackgroundConfiguration()
                .getDefaultConfiguration()
                .getColors()
        );
    }

    public static void paintTrack(final Graphics2D g2, final Rectangle paintBounds, final ScrollBarAppearance appearance) {
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setPaint(createPaint(appearance, paintBounds));
        g2.fillRect(paintBounds.x, paintBounds.y, paintBounds.width, paintBounds.height);
    }

    public static void paintThumb(final Graphics2D g2, final Rectangle paintBounds, final ScrollBarAppearance appearance) {
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setPaint(createPaint(appearance, paintBounds));
        g2.fillRoundRect(paintBounds.x, paintBounds.y, paintBounds.width, paintBounds.height, appearance.getRadius(), appearance.getRadius());
    }
}