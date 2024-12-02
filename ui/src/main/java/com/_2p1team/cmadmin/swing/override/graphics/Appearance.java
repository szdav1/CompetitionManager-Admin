package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.graphics.consts.InteractivityMode;
import com._2p1team.cmadmin.swing.override.graphics.consts.UIState;
import com._2p1team.cmadmin.swing.override.graphics.hints.*;
import lombok.Data;

@Data
public class Appearance {
    private final InteractivityMode interactivityMode;
    private final UIState state;
    private final BackgroundHint backgroundHint;
    private final ForegroundStyle foregroundStyle;
    private final IconSet iconSet;
    private final FontSet fontSet;
    private final BorderHint borderHint;

    public Appearance(final InteractivityMode interactivityMode, final BackgroundHint backgroundHint, final ForegroundStyle foregroundStyle,
        final IconSet iconSet, final FontSet fontSet, final BorderHint borderHint) {

        this.interactivityMode = interactivityMode;
        this.state = UIState.DEFAULT;
        this.backgroundHint = backgroundHint;
        this.foregroundStyle = foregroundStyle;
        this.iconSet = iconSet;
        this.fontSet = fontSet;
        this.borderHint = borderHint;
    }
}