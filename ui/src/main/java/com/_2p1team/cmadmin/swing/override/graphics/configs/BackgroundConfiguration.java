package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BackgroundConfiguration {
    private final PaintConfiguration defaultConfiguration;
    private final PaintConfiguration hoveredConfiguration;
    private final PaintConfiguration pressedConfiguration;
    private final PaintConfiguration releasedConfiguration;

    public BackgroundConfiguration() {
        this(new LinearGradientPaintConfiguration(), new LinearGradientPaintConfiguration());
    }

    public BackgroundConfiguration(final PaintConfiguration configuration) {
        this(configuration, configuration);
    }

    public BackgroundConfiguration(final PaintConfiguration defaultConfiguration, final PaintConfiguration hoveredConfiguration) {
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }
}