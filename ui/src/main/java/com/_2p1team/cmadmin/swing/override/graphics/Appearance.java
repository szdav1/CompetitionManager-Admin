package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.consts.UIState;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;
import lombok.Data;

@Data
public final class Appearance {
    private UIState state;
    private BackgroundConfiguration backgroundConfiguration;
    private ForegroundConfiguration foregroundConfiguration;
    private IconSet iconSet;
    private FontSet fontSet;
    private BorderConfiguration borderConfiguration;

    public Appearance() {
        this(
            new BackgroundConfiguration(),
            new ForegroundConfiguration(),
            new IconSet(),
            new FontSet(),
            new BorderConfiguration()
        );
    }

    public Appearance(
        final BackgroundConfiguration backgroundConfiguration,
        final ForegroundConfiguration foregroundConfiguration,
        final IconSet iconSet,
        final FontSet fontSet,
        final BorderConfiguration borderConfiguration
    ) {
        this.state = UIState.DEFAULT;
        this.backgroundConfiguration = backgroundConfiguration;
        this.foregroundConfiguration = foregroundConfiguration;
        this.iconSet = iconSet;
        this.fontSet = fontSet;
        this.borderConfiguration = borderConfiguration;
    }
}