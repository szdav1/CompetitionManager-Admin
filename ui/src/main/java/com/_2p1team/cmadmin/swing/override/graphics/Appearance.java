package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.graphics.configs.*;
import com._2p1team.cmadmin.swing.override.consts.InteractivityMode;
import com._2p1team.cmadmin.swing.override.consts.UIState;
import lombok.Data;

@Data
public class Appearance {
    private final InteractivityMode interactivityMode;
    private final UIState state;
    private final BackgroundConfiguration backgroundConfiguration;
    private final ForegroundStyle foregroundStyle;
    private final IconSet iconSet;
    private final FontSet fontSet;
    private final BorderConfiguration borderConfiguration;

    public Appearance() {
        this(
            InteractivityMode.BACKGROUND_AND_FOREGROUND,
            new BackgroundConfiguration(),
            new ForegroundStyle(),
            new IconSet(),
            new FontSet(),
            new BorderConfiguration()
        );
    }

    public Appearance(
        final InteractivityMode interactivityMode,
        final BackgroundConfiguration backgroundConfiguration,
        final ForegroundStyle foregroundStyle,
        final IconSet iconSet,
        final FontSet fontSet,
        final BorderConfiguration borderConfiguration
    ) {
        this.interactivityMode = interactivityMode;
        this.state = UIState.DEFAULT;
        this.backgroundConfiguration = backgroundConfiguration;
        this.foregroundStyle = foregroundStyle;
        this.iconSet = iconSet;
        this.fontSet = fontSet;
        this.borderConfiguration = borderConfiguration;
    }
}