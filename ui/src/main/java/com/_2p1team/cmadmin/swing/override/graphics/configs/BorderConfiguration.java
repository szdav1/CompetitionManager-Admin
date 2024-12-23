package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BorderConfiguration {
    private int thickness;
    private int radius;
    private AbstractPaintConfiguration defaultConfiguration;
    private AbstractPaintConfiguration hoveredConfiguration;
    private AbstractPaintConfiguration pressedConfiguration;
    private AbstractPaintConfiguration releasedConfiguration;

    public BorderConfiguration() {
        this(0, 0, new SimplePaintConfiguration(), new SimplePaintConfiguration());
    }

    public BorderConfiguration(int thickness, int radius, final AbstractPaintConfiguration configuration) {
        this(thickness, radius, configuration, configuration);
    }

    public BorderConfiguration(int thickness, final AbstractPaintConfiguration configuration) {
        this(thickness, configuration, configuration);
    }

    public BorderConfiguration(
        int thickness,
        final AbstractPaintConfiguration defaultConfiguration,
        final AbstractPaintConfiguration hoveredConfiguration,
        final AbstractPaintConfiguration pressedConfiguration,
        final AbstractPaintConfiguration releasedConfiguration
    ) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = pressedConfiguration;
        this.releasedConfiguration = releasedConfiguration;
    }

    public BorderConfiguration(int thickness, int radius, final AbstractPaintConfiguration defaultConfiguration, final AbstractPaintConfiguration hoveredConfiguration) {
        this.thickness = thickness;
        this.radius = radius;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }

    public BorderConfiguration(int thickness, final AbstractPaintConfiguration defaultConfiguration, final AbstractPaintConfiguration hoveredConfiguration) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }
}