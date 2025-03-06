package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AccessLevel;
import lombok.Setter;

import java.awt.Color;
import java.awt.Paint;

/**
 * The SimplePaintConfiguration class is the gradient representation of
 * the used paint configurations inside the module. This class takes care
 * of handling single color inputs.
 *
 * @see Paint
 * @see AbstractPaintConfiguration
 */
@Setter(AccessLevel.PRIVATE)
public final class SimplePaintConfiguration extends AbstractPaintConfiguration {

    /**
     * Constructs an SimplePaintConfiguration object with default values.
     */
    public SimplePaintConfiguration() {
    }

    /**
     * Constructs a SimplePaintConfiguration object with the specified color.
     *
     * @param color The color of the configuration
     */
    public SimplePaintConfiguration(final Color color) {
        this.setColors(new Color[]{color, color});
        this.setFractions(new float[]{0.0f, 1.0f});
    }

    /**
     * Returns the used color from this configuration object.
     *
     * @return The color in that is used by this configuration object
     */
    public Color getColor() {
        return this.getColors()[0];
    }

}