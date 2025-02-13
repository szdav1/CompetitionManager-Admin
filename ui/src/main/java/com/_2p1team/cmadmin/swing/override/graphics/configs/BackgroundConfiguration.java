package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.Color;

@Data
@AllArgsConstructor
public final class BackgroundConfiguration {

    private AbstractPaintConfiguration defaultConfiguration;
    private AbstractPaintConfiguration hoveredConfiguration;
    private AbstractPaintConfiguration pressedConfiguration;
    private AbstractPaintConfiguration releasedConfiguration;
    private AbstractPaintConfiguration errorConfiguration;

    public BackgroundConfiguration() {
        this(new LinearGradientPaintConfiguration(), new LinearGradientPaintConfiguration());
    }

    public BackgroundConfiguration(final AbstractPaintConfiguration configuration) {
        this(configuration, configuration);
    }

    public BackgroundConfiguration(final AbstractPaintConfiguration defaultConfiguration, final AbstractPaintConfiguration hoveredConfiguration) {
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
        this.errorConfiguration = new SimplePaintConfiguration(new Color(220, 53, 69));
    }

}