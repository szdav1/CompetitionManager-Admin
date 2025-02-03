package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.awt.Color;

@Data
public abstract class AbstractPaintConfiguration {

    @Setter(AccessLevel.NONE)
    private Color[] colors;
    @Setter(AccessLevel.NONE)
    private float[] fractions;

    public AbstractPaintConfiguration() {
        this.colors = new Color[]{Color.black, Color.black};
        this.fractions = new float[]{0.0f, 1.0f};
    }

    public void setColors(Color... colors) {
        this.colors = colors;
    }

    public void setFractions(float... fractions) {
        this.fractions = fractions;
    }

}