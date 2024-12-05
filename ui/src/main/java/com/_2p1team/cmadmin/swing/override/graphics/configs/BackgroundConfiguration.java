package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BackgroundConfiguration {
    private final LinearGradientPaintConfiguration defaultHint;
    private final LinearGradientPaintConfiguration hoveredHint;
    private final LinearGradientPaintConfiguration pressedHint;
    private final LinearGradientPaintConfiguration releasedHint;

    public BackgroundConfiguration() {
        this(new LinearGradientPaintConfiguration(), new LinearGradientPaintConfiguration());
    }

    public BackgroundConfiguration(final LinearGradientPaintConfiguration defaultHint, final LinearGradientPaintConfiguration hoveredHint) {
        this.defaultHint = defaultHint;
        this.hoveredHint = hoveredHint;
        this.pressedHint = defaultHint;
        this.releasedHint = hoveredHint;
    }
}