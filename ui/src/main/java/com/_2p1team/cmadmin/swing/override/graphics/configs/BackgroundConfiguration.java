package com._2p1team.cmadmin.swing.override.graphics.configs;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.Color;
import java.awt.LinearGradientPaint;

/**
 * The BackgroundConfiguration specifies paint configurations
 * (colors and fractions) for an Appearance object. It defines
 * configurations for different states of a component:
 * <p>default, hovered, pressed, released and error.</p>
 *
 * @see LinearGradientPaint
 * @see LinearGradientPaintConfiguration
 * @see SimplePaintConfiguration
 * @see Appearance
 */
@Data
@AllArgsConstructor
public final class BackgroundConfiguration {

    private AbstractPaintConfiguration defaultConfiguration;
    private AbstractPaintConfiguration hoveredConfiguration;
    private AbstractPaintConfiguration pressedConfiguration;
    private AbstractPaintConfiguration releasedConfiguration;
    private AbstractPaintConfiguration errorConfiguration;

    /**
     * Constructs a BackgroundConfiguration object with empty constructor
     * paint configurations.
     */
    public BackgroundConfiguration() {
        this(new LinearGradientPaintConfiguration(), new LinearGradientPaintConfiguration());
    }

    /**
     * Constructs a BackgroundConfiguration object with the paint configuration
     * being same specified configuration for every component state.
     *
     * @param configuration The configuration of the background
     */
    public BackgroundConfiguration(final AbstractPaintConfiguration configuration) {
        this(configuration, configuration);
    }

    /**
     * Constructs a BackgroundConfiguration object with the paint configuration
     * being distributed among the component states.
     *
     * @param defaultConfiguration The default and pressed configuration
     * @param hoveredConfiguration The hovered and the released configuration
     */
    public BackgroundConfiguration(final AbstractPaintConfiguration defaultConfiguration, final AbstractPaintConfiguration hoveredConfiguration) {
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
        this.errorConfiguration = new SimplePaintConfiguration(new Color(220, 53, 69));
    }

}