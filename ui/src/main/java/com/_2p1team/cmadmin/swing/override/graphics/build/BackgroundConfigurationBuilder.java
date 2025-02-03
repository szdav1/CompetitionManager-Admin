package com._2p1team.cmadmin.swing.override.graphics.build;

import com._2p1team.cmadmin.swing.override.graphics.configs.AbstractPaintConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;

public final class BackgroundConfigurationBuilder {

    private final BackgroundConfiguration configuration;

    public BackgroundConfigurationBuilder() {
        this.configuration = new BackgroundConfiguration();
    }

    public BackgroundConfigurationBuilder setDefaultConfiguration(final AbstractPaintConfiguration configuration) {
        this.configuration.setDefaultConfiguration(configuration);
        return this;
    }

    public BackgroundConfigurationBuilder setHoveredConfiguration(final AbstractPaintConfiguration configuration) {
        this.configuration.setHoveredConfiguration(configuration);
        return this;
    }

    public BackgroundConfigurationBuilder setPressedConfiguration(final AbstractPaintConfiguration configuration) {
        this.configuration.setPressedConfiguration(configuration);
        return this;
    }

    public BackgroundConfigurationBuilder setReleasedConfiguration(final AbstractPaintConfiguration configuration) {
        this.configuration.setReleasedConfiguration(configuration);
        return this;
    }

    public BackgroundConfiguration build() {
        return this.configuration;
    }

}