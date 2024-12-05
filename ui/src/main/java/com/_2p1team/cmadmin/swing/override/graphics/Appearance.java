package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.graphics.configs.*;
import com._2p1team.cmadmin.swing.override.consts.InteractivityMode;
import com._2p1team.cmadmin.swing.override.consts.UIState;
import lombok.Data;

@Data
public class Appearance {
    private InteractivityMode interactivityMode;
    private UIState state;
    private BackgroundConfiguration backgroundConfiguration;
    private ForegroundConfiguration foregroundConfiguration;
    private IconSet iconSet;
    private FontSet fontSet;
    private BorderConfiguration borderConfiguration;

    public Appearance() {
        this(
            InteractivityMode.BACKGROUND_AND_FOREGROUND,
            new BackgroundConfiguration(),
            new ForegroundConfiguration(),
            new IconSet(),
            new FontSet(),
            new BorderConfiguration()
        );
    }

    public Appearance(
        final InteractivityMode interactivityMode,
        final BackgroundConfiguration backgroundConfiguration,
        final ForegroundConfiguration foregroundConfiguration,
        final IconSet iconSet,
        final FontSet fontSet,
        final BorderConfiguration borderConfiguration
    ) {
        this.interactivityMode = interactivityMode;
        this.state = UIState.DEFAULT;
        this.backgroundConfiguration = backgroundConfiguration;
        this.foregroundConfiguration = foregroundConfiguration;
        this.iconSet = iconSet;
        this.fontSet = fontSet;
        this.borderConfiguration = borderConfiguration;
    }
}