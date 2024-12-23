package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public final class Appearance {
    @Setter(AccessLevel.NONE)
    private boolean interactivityEnabled;
    private UIState state;
    private BackgroundConfiguration backgroundConfiguration;
    private ForegroundConfiguration foregroundConfiguration;
    private IconSet iconSet;
    private FontSet fontSet;
    private BorderConfiguration borderConfiguration;

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

    public void enableInteractivity() {
        this.interactivityEnabled = true;
    }

    public void disableInteractivity() {
        this.interactivityEnabled = false;
    }
}