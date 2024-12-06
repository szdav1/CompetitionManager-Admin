package com._2p1team.cmadmin.swing.override.graphics.configs;

import java.awt.Color;

import lombok.AccessLevel;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
public final class SimplePaintConfiguration extends PaintConfiguration {
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
