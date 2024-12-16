package com._2p1team.cmadmin.swing.override.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.BorderLayout;

@Getter
@AllArgsConstructor
public enum Position {
    HIGH(3),
    MID(2),
    LOW(1),
    BACKGROUND(0),

    TOP(BorderLayout.NORTH),
    LEFT(BorderLayout.WEST),
    CENTER(BorderLayout.CENTER),
    RIGHT(BorderLayout.EAST),
    BOTTOM(BorderLayout.SOUTH);

    private final int positionValue;
    private final String layoutValue;

    Position(final int positionValue) {
        this.positionValue = positionValue;
        this.layoutValue = BorderLayout.CENTER;
    }

    Position(final String layoutValue) {
        this.positionValue = 2;
        this.layoutValue = layoutValue;
    }
}