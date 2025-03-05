package com._2p1team.cmadmin.swing.override.graphics.build;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.AbstractPaintConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;

/**
 * The BackgroundConfigurationBuilder class is used to 'build' BackgroundConfigurations
 * while maintaining default values if something is missed.
 *
 * @see Appearance
 * @see BackgroundConfiguration
 */
public final class BackgroundConfigurationBuilder {

    private final BackgroundConfiguration configuration;

    /**
     * Constructs a new BackgroundConfigurationBuilder object.
     */
    public BackgroundConfigurationBuilder() {
        this.configuration = new BackgroundConfiguration();
    }

    /**
     * Sets the default configuration to the specified configuration.
     *
     * @param configuration The configuration that should be used
     * @return This builder object
     */
    public BackgroundConfigurationBuilder setDefaultConfiguration(final AbstractPaintConfiguration configuration) {
        this.configuration.setDefaultConfiguration(configuration);
        return this;
    }

    /**
     * Sets the hovered configuration to the specified configuration.
     *
     * @param configuration The configuration that should be used
     * @return This builder object
     */
    public BackgroundConfigurationBuilder setHoveredConfiguration(final AbstractPaintConfiguration configuration) {
        this.configuration.setHoveredConfiguration(configuration);
        return this;
    }

    /**
     * Sets the pressed configuration to the specified configuration.
     *
     * @param configuration The configuration that should be used
     * @return This builder object
     */
    public BackgroundConfigurationBuilder setPressedConfiguration(final AbstractPaintConfiguration configuration) {
        this.configuration.setPressedConfiguration(configuration);
        return this;
    }

    /**
     * Sets the released configuration to the specified configuration.
     *
     * @param configuration The configuration that should be used
     * @return This builder object
     */
    public BackgroundConfigurationBuilder setReleasedConfiguration(final AbstractPaintConfiguration configuration) {
        this.configuration.setReleasedConfiguration(configuration);
        return this;
    }

    /**
     * Finalize and return the recently built BackgroundConfiguration object.
     *
     * @return The BackgroundConfiguration object that has been built
     */
    public BackgroundConfiguration build() {
        return this.configuration;
    }

}