package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

/**
 * The Appearance class handles UI appearances of custom components,
 * by specifying configurations for different parts of a component.
 * Background, Foreground, Icon, Font and borders are drawn by this class's
 * configurations. It also handles interactivity and provides a stable way to
 * keep track of a component's UI state.
 *
 * @see BackgroundConfiguration
 * @see ForegroundConfiguration
 * @see IconSet
 * @see FontSet
 * @see BorderConfiguration
 * @see UIState
 */
@Data
@AllArgsConstructor
public class Appearance {

    @Setter(AccessLevel.NONE)
    private boolean interactivityEnabled;
    private UIState state;
    private BackgroundConfiguration backgroundConfiguration;
    private ForegroundConfiguration foregroundConfiguration;
    private IconSet iconSet;
    private FontSet fontSet;
    private BorderConfiguration borderConfiguration;

    /**
     * Constructs an Appearance object with empty configuration
     * constructor calls.
     */
    public Appearance() {
        this(
            false,
            new BackgroundConfiguration(),
            new ForegroundConfiguration(),
            new IconSet(),
            new FontSet(),
            new BorderConfiguration()
        );
    }

    /**
     * Constructs an Appearance class using the specified Appearance's
     * configurations. It creates a copy of the specified Appearance object.
     *
     * @param appearance The Appearance that should be copied.
     */
    public Appearance(final Appearance appearance) {
        this.interactivityEnabled = appearance.interactivityEnabled;
        this.state = UIState.DEFAULT;
        this.backgroundConfiguration = appearance.backgroundConfiguration;
        this.foregroundConfiguration = appearance.foregroundConfiguration;
        this.iconSet = appearance.iconSet;
        this.fontSet = appearance.fontSet;
        this.borderConfiguration = appearance.borderConfiguration;
    }

    /**
     * Constructs an Appearance class using the specified configurations.
     *
     * @param interactivityEnabled    Sets whether the component is interactive or not
     * @param backgroundConfiguration The background configuration of the Appearance
     * @param foregroundConfiguration The foreground configuration of the Appearance
     * @param iconSet                 The icon set of the Appearance
     * @param fontSet                 The font set of the Appearance
     * @param borderConfiguration     The border configuration of the Appearance
     */
    public Appearance(
        final boolean interactivityEnabled,
        final BackgroundConfiguration backgroundConfiguration,
        final ForegroundConfiguration foregroundConfiguration,
        final IconSet iconSet,
        final FontSet fontSet,
        final BorderConfiguration borderConfiguration
    ) {
        this.interactivityEnabled = interactivityEnabled;
        this.state = UIState.DEFAULT;
        this.backgroundConfiguration = backgroundConfiguration;
        this.foregroundConfiguration = foregroundConfiguration;
        this.iconSet = iconSet;
        this.fontSet = fontSet;
        this.borderConfiguration = borderConfiguration;
    }

    /**
     * Enables UI interactivity for the component.
     */
    public void enableInteractivity() {
        this.interactivityEnabled = true;
    }

    /**
     * Disables interactivity for the component.
     */
    public void disableInteractivity() {
        this.interactivityEnabled = false;
    }

}