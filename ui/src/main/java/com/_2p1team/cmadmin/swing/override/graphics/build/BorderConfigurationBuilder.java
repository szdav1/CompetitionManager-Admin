package com._2p1team.cmadmin.swing.override.graphics.build;

import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;

public final class BorderConfigurationBuilder {
    private final BorderConfiguration configuration;

    public BorderConfigurationBuilder() {
        this.configuration = new BorderConfiguration();
    }

    public BorderConfigurationBuilder setThickness(final int thickness) {
        this.configuration.setThickness(thickness);
        return this;
    }

    public BorderConfigurationBuilder setRadius(final int radius) {
        this.configuration.setRadius(radius);
        return this;
    }

    public BorderConfigurationBuilder setDefaultConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setDefaultConfiguration(configuration);
        return this;
    }

    public BorderConfigurationBuilder setHoveredConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setHoveredConfiguration(configuration);
        return this;
    }

    public BorderConfigurationBuilder setPressedConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setPressedConfiguration(configuration);
        return this;
    }

    public BorderConfigurationBuilder setReleasedConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setReleasedConfiguration(configuration);
        return this;
    }

    public BorderConfiguration build() {
        return this.configuration;
    }
}