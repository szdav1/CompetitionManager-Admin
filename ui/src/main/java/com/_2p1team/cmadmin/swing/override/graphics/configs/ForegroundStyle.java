package com._2p1team.cmadmin.swing.override.graphics.configs;

import java.awt.Color;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class ForegroundStyle {
    private final Color defaultColor;
    private final Color hoveredColor;
    private final Color pressedColor;
    private final Color releasedColor;

    public ForegroundStyle() {
        this(Color.white, Color.darkGray);
    }

    public ForegroundStyle(final Color defaultColor, final Color hoveredColor) {
        this.defaultColor= defaultColor;
        this.hoveredColor= hoveredColor;
        this.pressedColor= defaultColor;
        this.releasedColor = hoveredColor;
    }
}