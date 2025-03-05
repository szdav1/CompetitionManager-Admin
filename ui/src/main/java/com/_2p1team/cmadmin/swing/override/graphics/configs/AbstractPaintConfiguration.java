package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.awt.Color;

/**
 * The AbstractPaintConfiguration class is an abstract representation of
 * the used paint configurations inside the module. This class handles
 * gradient painting problems, such as calculating equal size fractions
 * for colors, handling single color inputs and multicolor inputs.
 */
@Data
public abstract class AbstractPaintConfiguration {

    @Setter(AccessLevel.NONE)
    private Color[] colors;
    @Setter(AccessLevel.NONE)
    private float[] fractions;

    /**
     * Constructs an AbstractPaintConfiguration object with default values.
     */
    public AbstractPaintConfiguration() {
        this.colors = new Color[]{Color.black, Color.black};
        this.fractions = new float[]{0.0f, 1.0f};
    }

    /**
     * Set the colors of the configuration.
     *
     * @param colors
     */
    public void setColors(Color... colors) {
        this.colors = colors;
    }

    public void setFractions(float... fractions) {
        this.fractions = fractions;
    }

}