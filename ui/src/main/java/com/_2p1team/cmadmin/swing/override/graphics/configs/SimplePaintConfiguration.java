package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AccessLevel;
import lombok.Setter;

import java.awt.Color;

@Setter(AccessLevel.PRIVATE)
public final class SimplePaintConfiguration extends AbstractPaintConfiguration {

    public SimplePaintConfiguration() {
    }

    public SimplePaintConfiguration(final Color color) {
        this.setColors(new Color[]{color, color});
        this.setFractions(new float[]{0.0f, 1.0f});
    }

    public Color getColor() {
        return this.getColors()[0];
    }

}