package com._2p1team.cmadmin.swing.override.graphics.configs;

import java.awt.Color;

public final class LinearGradientPaintConfiguration extends PaintConfiguration {
    public LinearGradientPaintConfiguration() {
    }

    public LinearGradientPaintConfiguration(final Color... colors) {
        if (colors.length == 1)
            this.setColors(new Color[]{colors[0], colors[0]});
        else if (colors.length < 1)
            this.setColors(new Color[]{Color.black, Color.black});
        else
            this.setColors(colors);

        this.setFractions(new float[this.getColors().length]);
        this.calculateEqualFractions();
    }

    private void calculateEqualFractions() {
        float unitIncrement = 1.0f/this.getFractions().length;

        for (int i = 0; i < this.getFractions().length; i++)
            this.getFractions()[i] = i*unitIncrement;

        this.getFractions()[this.getFractions().length-1] = (float) Math.ceil(this.getFractions()[this.getFractions().length-1]);
    }
}