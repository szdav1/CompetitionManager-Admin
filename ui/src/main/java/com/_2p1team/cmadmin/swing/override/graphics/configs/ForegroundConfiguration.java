package com._2p1team.cmadmin.swing.override.graphics.configs;

import java.awt.Color;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class ForegroundConfiguration {
    private final Color defaultColor;
    private final Color hoveredColor;
    private final Color pressedColor;
    private final Color releasedColor;

    public ForegroundConfiguration() {
        this(Color.white, Color.darkGray);
    }

    public ForegroundConfiguration(final Color color) {
        this(color, color);
    }

    public ForegroundConfiguration(final Color defaultColor, final Color hoveredColor) {
        this.defaultColor = defaultColor;
        this.hoveredColor = hoveredColor;
        this.pressedColor = defaultColor;
        this.releasedColor = hoveredColor;
    }
}