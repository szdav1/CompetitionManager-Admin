package com._2p1team.cmadmin.swing.override.graphics.configs;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.LinearGradientPaint;

/**
 * The BorderConfiguration specifies paint configurations
 * (colors and fractions), thickness and radius for an Appearance object.
 * It defines configurations for different states of a component:
 * <p>default, hovered, pressed, released and error.</p>
 *
 * @see LinearGradientPaint
 * @see LinearGradientPaintConfiguration
 * @see SimplePaintConfiguration
 * @see Appearance
 */
@Data
@AllArgsConstructor
public final class BorderConfiguration {

    private int thickness;
    private int radius;
    private AbstractPaintConfiguration defaultConfiguration;
    private AbstractPaintConfiguration hoveredConfiguration;
    private AbstractPaintConfiguration pressedConfiguration;
    private AbstractPaintConfiguration releasedConfiguration;

    /**
     * Constructs a BorderConfiguration object with empty constructor
     * paint configurations and thickness and radius being 0.
     */
    public BorderConfiguration() {
        this(0, 0, new SimplePaintConfiguration(), new SimplePaintConfiguration());
    }

    /**
     * Constructs a BorderConfiguration object with the paint configuration
     * being same specified configuration for every component state.
     *
     * @param configuration The configuration of the background
     */
    public BorderConfiguration(int thickness, int radius, final AbstractPaintConfiguration configuration) {
        this(thickness, radius, configuration, configuration);
    }

    /**
     * Constructs a BorderConfiguration object with the paint configuration
     * being same specified configuration for every component state and radius being 0.
     *
     * @param configuration The configuration of the background
     */
    public BorderConfiguration(int thickness, final AbstractPaintConfiguration configuration) {
        this(thickness, configuration, configuration);
    }

    /**
     * Constructs a BorderConfiguration object with the specified parameters.
     *
     * @param thickness             The thickness of the border
     * @param defaultConfiguration  The default paint configuration
     * @param hoveredConfiguration  The hovered paint configuration
     * @param pressedConfiguration  The pressed paint configuration
     * @param releasedConfiguration The released paint configuration
     */
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

    /**
     * Constructs a BackgroundConfiguration object with the paint configuration
     * being distributed among the component states.
     *
     * @param thickness            The thickness of the border
     * @param radius               The radius of the border
     * @param defaultConfiguration The default paint configuration
     * @param hoveredConfiguration The hovered paint configuration
     */
    public BorderConfiguration(int thickness, int radius, final AbstractPaintConfiguration defaultConfiguration, final AbstractPaintConfiguration hoveredConfiguration) {
        this.thickness = thickness;
        this.radius = radius;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }

    /**
     * Constructs a BackgroundConfiguration object with the paint configuration
     * being distributed among the component states.
     *
     * @param thickness            The thickness of the border
     * @param defaultConfiguration The default paint configuration
     * @param hoveredConfiguration The hovered paint configuration
     */
    public BorderConfiguration(int thickness, final AbstractPaintConfiguration defaultConfiguration, final AbstractPaintConfiguration hoveredConfiguration) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultConfiguration = defaultConfiguration;
        this.hoveredConfiguration = hoveredConfiguration;
        this.pressedConfiguration = defaultConfiguration;
        this.releasedConfiguration = hoveredConfiguration;
    }

}