package com._2p1team.cmadmin.swing.override.consts;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum InteractivityMode {
    BACKGROUND,
    FOREGROUND,
    ICON,
    FONT,
    BORDER,
    BACKGROUND_AND_FOREGROUND,
    ICON_AND_FOREGROUND;
}