package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.components.label.AbstractLabel;
import com._2p1team.cmadmin.swing.override.constants.UIState;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * The G2DPainter class is the one that is responsible for
 * the custom painting methods of components inside the package.
 * It should be called from the custom defined component's overridden
 * paint method, with casting the default Graphics object passed as a parameter
 * to a Graphics2D object, which will be used to perform the different painting methods,
 * hence the name G2DPainter.
 *
 * @see Graphics2D
 * @see Appearance
 * @see AppearanceComponent
 */
@AllArgsConstructor(access=AccessLevel.PRIVATE)
public final class G2DPainter {

    /**
     * Determines the paint of the background based on the passed in Appearance's current state.
     * Handles colors and fractions in case of a linear gradient background paint, and single colors
     * in case of a simple paint. The returned Paint object will be determined based on the passed in
     * start, end points and the Appearance. If the component is not enabled, the default paint will be returned.
     *
     * @param start      The starting point of the paint
     * @param end        The end point of the paint
     * @param appearance The component's Appearance object from which configuration data is fetched
     * @param component  The component the created paint will be applied to
     * @param <C>        Type that is a child of JComponent and implements the AppearanceComponent interface
     * @return The Paint object created based on the passed in parameters
     */
    private static <C extends JComponent & AppearanceComponent> LinearGradientPaint determineBackgroundPaint(final Point2D start, final Point2D end, final Appearance appearance, final C component) {
        if (appearance.getState() == UIState.ERROR)
            return new LinearGradientPaint(
                start,
                end,
                appearance.getBackgroundConfiguration()
                    .getErrorConfiguration()
                    .getFractions(),
                appearance.getBackgroundConfiguration()
                    .getErrorConfiguration()
                    .getColors()
            );

        return appearance.isInteractivityEnabled() && component.isEnabled() ?
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

    /**
     * Paints the background of the specified component with the determined paint.
     *
     * @param g2         The Graphics2D object from the component's graphics configuration
     * @param start      The starting point of the paint
     * @param end        The end point of the paint
     * @param appearance The component's Appearance object from which configuration data is fetched
     * @param component  The component the created paint will be applied to
     * @param <C>        Type that is a child of JComponent and implements the AppearanceComponent interface
     */
    private static <C extends JComponent & AppearanceComponent> void paintBackground(final Graphics2D g2, Point2D start, Point2D end, final Appearance appearance, final C component) {
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        LinearGradientPaint lgp = determineBackgroundPaint(start, end, appearance, component);

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

    /**
     * Determines the paint of the border based on the passed in Appearance's current state.
     * Handles colors and fractions in case of a linear gradient border paint, and single colors
     * in case of a simple paint. The returned Paint object will be determined based on the passed in
     * start, end points and the Appearance. If the component is not enabled, the default paint will be returned.
     *
     * @param start      The starting point of the paint
     * @param end        The end point of the paint
     * @param appearance The component's Appearance object from which configuration data is fetched
     * @param component  The component the created paint will be applied to
     * @param <C>        Type that is a child of JComponent and implements the AppearanceComponent interface
     * @return The Paint object created based on the passed in parameters
     */
    private static <C extends JComponent & AppearanceComponent> LinearGradientPaint determineBorderPaint(final Point2D start, final Point2D end, final Appearance appearance, final C component) {
        return appearance.isInteractivityEnabled() && component.isEnabled() ?
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

    /**
     * Paints the border of the specified component with the determined paint.
     *
     * @param g2         The Graphics2D object from the component's graphics configuration
     * @param start      The starting point of the paint
     * @param end        The end point of the paint
     * @param appearance The component's Appearance object from which configuration data is fetched
     * @param component  The component the created paint will be applied to
     * @param <C>        Type that is a child of JComponent and implements the AppearanceComponent interface
     */
    private static <C extends JComponent & AppearanceComponent> void paintBorder(final Graphics2D g2, Point2D start, Point2D end, final Appearance appearance, final C component) {
        if (appearance.getBorderConfiguration().getThickness() <= 0 && appearance.getBorderConfiguration().getRadius() <= 0)
            return;

        g2.setStroke(new BasicStroke(appearance.getBorderConfiguration().getThickness()));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        LinearGradientPaint lgp = determineBorderPaint(start, end, appearance, component);

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

    /**
     * Sets the foreground of the specified component based on its Appearance's current state.
     * Note that this method will not have any effects on non-text-displaying components.
     *
     * @param g2        The Graphics2D object from the component's graphics configuration
     * @param component The component the created paint will be applied to.
     * @param <C>       Type that is a child of JComponent and implements the AppearanceComponent interface
     */
    public static <C extends JComponent & AppearanceComponent> void paint(final Graphics2D g2, final C component) {
        Point2D start = new Point2D.Double(0, 0);
        Point2D end = new Point2D.Double(component.getWidth(), component.getHeight());

        paintBackground(g2, start, end, component.getComponentAppearance(), component);
        paintBorder(g2, start, end, component.getComponentAppearance(), component);
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

    /**
     * Sets the foreground of the specified component based on its Appearance's current state.
     * Note that this method will not have any effects on non-text-displaying components.
     *
     * @param component The Component that's foreground needs to be set
     * @param <C>       Type that is a child of JComponent and implements the AppearanceComponent interface
     */
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

    /**
     * Sets the icon of the specified component based its Appearance's current state.
     * Note that this method will only be performed if the specified Component is an
     * instance of the JLabel or JButton class.
     *
     * @param component The Component that's icon needs to be set
     * @param <C>       Type that is a child of JComponent and implements the AppearanceComponent interface
     */
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

    /**
     * Draws the specified Component's UI elements, that includes setting the font, foreground and icon
     * of the component. Note that this method will not have any effects on non-text-displaying components.
     *
     * @param component The component that's UI elements should be painted
     * @param <C>       Type that is a child of JComponent and implements the AppearanceComponent interface
     */
    public static <C extends JComponent & AppearanceComponent> void drawComponentUIElements(final C component) {
        if (!component.getComponentAppearance().isInteractivityEnabled() || !component.isEnabled())
            return;

        setFontOfComponent(component);
        setForegroundOfComponent(component);
        setIconOfComponent(component);
    }

    /**
     * Paints the track of a scroll bar based on the passed in Appearance's configurations.
     *
     * @param g2          The Graphics2D object from the component's graphics configuration
     * @param paintBounds The bounds the paint should be within
     * @param appearance  The component's Appearance object from which configuration data is fetched
     */
    public static void paintScrollBarTrack(final Graphics2D g2, final Rectangle paintBounds, final Appearance appearance) {
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setColor(appearance.getForegroundConfiguration().getDefaultColor());
        g2.fillRoundRect(paintBounds.x, paintBounds.y, paintBounds.width, paintBounds.height, appearance.getBorderConfiguration().getRadius(), appearance.getBorderConfiguration().getRadius());
    }

    /**
     * Creates the paint of the thumb of the scroll bar.
     *
     * @param paintBounds The bounds the paint should be within
     * @param appearance  The component's Appearance object from which configuration data is fetched
     * @return The created Paint object
     */
    private static LinearGradientPaint createScrollBarThumbPaint(final Rectangle paintBounds, final Appearance appearance) {
        return new LinearGradientPaint(
            paintBounds.x,
            paintBounds.y,
            paintBounds.width,
            paintBounds.height,
            appearance.getBackgroundConfiguration()
                .getHoveredConfiguration()
                .getFractions(),
            appearance.getBackgroundConfiguration()
                .getHoveredConfiguration()
                .getColors()
        );
    }

    /**
     * Paints the thumb of the scroll bar based on the Appearance's configurations.
     *
     * @param g2          The Graphics2D object from the component's graphics configuration
     * @param paintBounds The bounds the paint should be within
     * @param appearance  The component's Appearance object from which configuration data is fetched
     */
    public static void paintScrollBarThumb(final Graphics2D g2, final Rectangle paintBounds, final Appearance appearance) {
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setPaint(createScrollBarThumbPaint(paintBounds, appearance));
        g2.fillRoundRect(paintBounds.x, paintBounds.y, paintBounds.width, paintBounds.height, appearance.getBorderConfiguration().getRadius(), appearance.getBorderConfiguration().getRadius());
    }

}