package com._2p1team.cmadmin.swing.override.graphics.hints;

import java.awt.Color;

import lombok.Data;

@Data
public final class LinearGradientPaintHint {
    private Color[] colors;
    private float[] fractions;

    public LinearGradientPaintHint() {
        this(Color.black);
    }

    public LinearGradientPaintHint(final Color... colors) {
        if (colors.length == 1)
            this.colors = new Color[]{colors[0], colors[0]};
        else if (colors.length < 1)
            this.colors = new Color[]{Color.black, Color.black};
        else
            this.colors = colors;

        this.fractions = new float[this.colors.length];
        this.calculateEqualFractions();
    }

    private void calculateEqualFractions() {
        float unitIncrement = 1.0f/this.fractions.length;

        for (int i = 0; i < this.fractions.length; i++)
            this.fractions[i] = i*unitIncrement;

        this.fractions[this.fractions.length-1] = (float) Math.ceil(this.fractions[this.fractions.length-1]);
    }
}