package com._2p1team.cmadmin.swing.override.graphics.configs;

public final class BackgroundConfigurationBuilder {
    private final BackgroundConfiguration configuration;

    public BackgroundConfigurationBuilder() {
        this.configuration = new BackgroundConfiguration();
    }

    public BackgroundConfigurationBuilder setDefaultConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setDefaultConfiguration(configuration);
        return this;
    }

    public BackgroundConfigurationBuilder setHoveredConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setHoveredConfiguration(configuration);
        return this;
    }

    public BackgroundConfigurationBuilder setPressedConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setPressedConfiguration(configuration);
        return this;
    }

    public BackgroundConfigurationBuilder setReleasedConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setReleasedConfiguration(configuration);
        return this;
    }

    public BackgroundConfiguration build() {
        return this.configuration;
    }
}
