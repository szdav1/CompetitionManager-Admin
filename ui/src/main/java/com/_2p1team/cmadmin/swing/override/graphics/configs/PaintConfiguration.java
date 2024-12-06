package com._2p1team.cmadmin.swing.override.graphics.configs;

import java.awt.Color;

import lombok.Data;

@Data
public abstract class PaintConfiguration {
    private Color[] colors;
    private float[] fractions;

    public PaintConfiguration() {
        this.colors = new Color[]{Color.black, Color.black};
        this.fractions = new float[]{0.0f, 1.0f};
    }
}
