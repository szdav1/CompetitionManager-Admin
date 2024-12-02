package com._2p1team.cmadmin.swing.override.graphics.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum InteractivityMode {
    BACKGROUND(false),
    FOREGROUND(false),
    ICON(false),
    FONT(false),
    BORDER(false),
    BACKGROUND_AND_FOREGROUND(false),
    ICON_AND_FOREGROUND(false);

    private final boolean enabled;
}