package com._2p1team.cmadmin.swing.override.graphics.build;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;

/**
 * The BorderConfigurationBuilder class is used to 'build' BorderConfigurationBuilder
 * while maintaining default values if something is missed.
 *
 * @see Appearance
 * @see BackgroundConfiguration
 */
public final class BorderConfigurationBuilder {

    private final BorderConfiguration configuration;

    /**
     * Constructs a new BorderConfigurationBuilder object.
     */
    public BorderConfigurationBuilder() {
        this.configuration = new BorderConfiguration();
    }

    /**
     * Sets the thickness to the specified value.
     *
     * @param thickness The specified thickness that should be used
     * @return This builder object
     */
    public BorderConfigurationBuilder setThickness(final int thickness) {
        this.configuration.setThickness(thickness);
        return this;
    }

    public BorderConfigurationBuilder setRadius(final int radius) {
        this.configuration.setRadius(radius);
        return this;
    }

    /**
     * Sets the default configuration to the specified configuration.
     *
     * @param configuration The configuration that should be used
     * @return This builder object
     */
    public BorderConfigurationBuilder setDefaultConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setDefaultConfiguration(configuration);
        return this;
    }

    /**
     * Sets the hovered configuration to the specified configuration.
     *
     * @param configuration The configuration that should be used
     * @return This builder object
     */
    public BorderConfigurationBuilder setHoveredConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setHoveredConfiguration(configuration);
        return this;
    }

    /**
     * Sets the pressed configuration to the specified configuration.
     *
     * @param configuration The configuration that should be used
     * @return This builder object
     */
    public BorderConfigurationBuilder setPressedConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setPressedConfiguration(configuration);
        return this;
    }

    /**
     * Sets the released configuration to the specified configuration.
     *
     * @param configuration The configuration that should be used
     * @return This builder object
     */
    public BorderConfigurationBuilder setReleasedConfiguration(final LinearGradientPaintConfiguration configuration) {
        this.configuration.setReleasedConfiguration(configuration);
        return this;
    }

    /**
     * Finalize and return the recently built BorderConfiguration object.
     *
     * @return The BorderConfiguration object that has been built
     */
    public BorderConfiguration build() {
        return this.configuration;
    }

}