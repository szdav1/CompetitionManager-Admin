package com._2p1team.cmadmin.swing.override.graphics.configs;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.Color;

/**
 * The ForegroundConfiguration specifies paint configurations
 * for an Appearance object's foreground. It defines
 * configurations for different states of a component:
 * <p>default, hovered, pressed, released and error.</p>
 *
 * @see Color
 * @see Appearance
 */
@Data
@AllArgsConstructor
public final class ForegroundConfiguration {

    private final Color defaultColor;
    private final Color hoveredColor;
    private final Color pressedColor;
    private final Color releasedColor;

    /**
     * Constructs a ForegroundConfiguration object with default values:
     * <p>white and dark gray.</p>
     */
    public ForegroundConfiguration() {
        this(Color.white, Color.darkGray);
    }

    /**
     * Constructs a BackgroundConfiguration object with the colors
     * being distributed among the component states.
     *
     * @param color The color of the foreground
     */
    public ForegroundConfiguration(final Color color) {
        this(color, color);
    }

    /**
     * Constructs a BackgroundConfiguration object with the colors
     * being distributed among the component states.
     *
     * @param defaultColor The default and pressed color
     * @param hoveredColor The hovered and the released color
     */
    public ForegroundConfiguration(final Color defaultColor, final Color hoveredColor) {
        this.defaultColor = defaultColor;
        this.hoveredColor = hoveredColor;
        this.pressedColor = defaultColor;
        this.releasedColor = hoveredColor;
    }

}