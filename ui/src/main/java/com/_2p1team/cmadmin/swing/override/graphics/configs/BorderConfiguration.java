package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BorderConfiguration {
    private int thickness;
    private int radius;
    private PaintConfiguration defaultConfiguration;
    private PaintConfiguration hoveredConfiguration;
    private PaintConfiguration pressedConfiguration;
    private PaintConfiguration releasedConfiguration;

    public BorderConfiguration() {
        this(0, 0, new SimplePaintConfiguration(), new SimplePaintConfiguration());
    }

    public BorderConfiguration(int thickness, int radius, final PaintConfiguration configuration) {
        this(thickness, radius, configuration, configuration);
    }

    public BorderConfiguration(int thickness, final PaintConfiguration configuration) {
        this(thickness, configuration, configuration);
    }

    public BorderConfiguration(
        int thickness,
        final PaintConfiguration defaultConfiguration,
        final PaintConfiguration hoveredConfiguration,
        final PaintConfiguration pressedConfiguration,
        final PaintConfiguration releasedConfiguration
    ) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = pressedConfiguration;
        this.releasedConfiguration = releasedConfiguration;
    }

    public BorderConfiguration(int thickness, int radius, final PaintConfiguration defaultConfiguration, final PaintConfiguration hoveredConfiguration) {
        this.thickness = thickness;
        this.radius = radius;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }

    public BorderConfiguration(int thickness, final PaintConfiguration defaultConfiguration, final PaintConfiguration hoveredConfiguration) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }
}