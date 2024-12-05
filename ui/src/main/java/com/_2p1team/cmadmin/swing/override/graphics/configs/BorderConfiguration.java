package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BorderConfiguration {
    private final int thickness;
    private final int radius;
    private final LinearGradientPaintConfiguration defaultConfiguration;
    private final LinearGradientPaintConfiguration hoveredConfiguration;
    private final LinearGradientPaintConfiguration pressedConfiguration;
    private final LinearGradientPaintConfiguration releasedConfiguration;

    public BorderConfiguration() {
        this(0, 0, new LinearGradientPaintConfiguration(), new LinearGradientPaintConfiguration());
    }

    public BorderConfiguration(
        int thickness,
        final LinearGradientPaintConfiguration defaultConfiguration,
        final LinearGradientPaintConfiguration hoveredConfiguration,
        final LinearGradientPaintConfiguration pressedConfiguration,
        final LinearGradientPaintConfiguration releasedConfiguration
    ) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = pressedConfiguration;
        this.releasedConfiguration = releasedConfiguration;
    }

    public BorderConfiguration(int thickness, int radius, final LinearGradientPaintConfiguration defaultConfiguration, final LinearGradientPaintConfiguration hoveredConfiguration) {
        this.thickness = thickness;
        this.radius = radius;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }

    public BorderConfiguration(int thickness, final LinearGradientPaintConfiguration defaultConfiguration, final LinearGradientPaintConfiguration hoveredConfiguration) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }
}