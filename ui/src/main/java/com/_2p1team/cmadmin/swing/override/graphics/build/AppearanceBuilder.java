package com._2p1team.cmadmin.swing.override.graphics.build;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;

/**
 * The AppearanceBuilder class is used to 'build' Appearances
 * while maintaining default values if something is missed.
 *
 * @see Appearance
 */
public final class AppearanceBuilder {

    private final Appearance appearance;

    /**
     * Constructs a new AppearanceBuilder object.
     */
    public AppearanceBuilder() {
        this.appearance = new Appearance();
    }

    /**
     * Sets the interactivity to true.
     *
     * @return This builder object
     */
    public AppearanceBuilder enableInteractivity() {
        this.appearance.enableInteractivity();
        return this;
    }

    /**
     * Sets the interactivity to false.
     *
     * @return This builder object
     */
    public AppearanceBuilder disableInteractivity() {
        this.appearance.disableInteractivity();
        return this;
    }

    /**
     * Sets the background configuration to the specified configuration.
     *
     * @param config The configuration that should be used
     * @return This builder object
     */
    public AppearanceBuilder setBackgroundConfiguration(final BackgroundConfiguration config) {
        this.appearance.setBackgroundConfiguration(config);
        return this;
    }

    /**
     * Sets the foreground configuration to the specified configuration.
     *
     * @param config The configuration that should be used
     * @return This builder object
     */
    public AppearanceBuilder setForegroundConfiguration(final ForegroundConfiguration config) {
        this.appearance.setForegroundConfiguration(config);
        return this;
    }

    /**
     * Sets the icon set to the specified icon set.
     *
     * @param iconSet The icon set that should be used
     * @return This builder object
     */
    public AppearanceBuilder setIconSet(final IconSet iconSet) {
        this.appearance.setIconSet(iconSet);
        return this;
    }

    /**
     * Sets the font set to the specified icon set.
     *
     * @param fontSet The font set that should be used
     * @return This builder object
     */
    public AppearanceBuilder setFontSet(final FontSet fontSet) {
        this.appearance.setFontSet(fontSet);
        return this;
    }

    /**
     * Sets the foreground configuration to the specified configuration.
     *
     * @param config The configuration that should be used
     * @return This builder object
     */
    public AppearanceBuilder setBorderConfiguration(final BorderConfiguration config) {
        this.appearance.setBorderConfiguration(config);
        return this;
    }

    /**
     * Finalize and return the recently built Appearance object.
     *
     * @return The Appearance object that has been built
     */
    public Appearance build() {
        return this.appearance;
    }

}