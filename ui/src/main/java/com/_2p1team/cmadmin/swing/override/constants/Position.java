package com._2p1team.cmadmin.swing.override.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.BorderLayout;


/**
 * The Position enum specifies custom override values for positioning
 * components inside a container.
 */
@Getter
@AllArgsConstructor
public enum Position {
    /**
     * The HIGH position defines the highest Z index a component can be placed on using
     * this enum.
     */
    HIGH(3),
    /**
     * The MID position defines the middle Z index a component can be placed on using
     * this enum.
     */
    MID(2),
    /**
     * The LOW position defines the second-lowest Z index a component can be placed on using
     * this enum.
     */
    LOW(1),
    /**
     * The BACKGROUND position defines the position a background can be placed on using this enum.
     * (Lower than LOW)
     */
    BACKGROUND(0),
    /**
     * The DEEP position defines the lowest Z index a component can be placed on using
     * this enum.
     */
    DEEP(-1),

    /**
     * The TOP position overrides the BorderLayout's NORTH position.
     *
     * @see BorderLayout
     */
    TOP(BorderLayout.NORTH),
    /**
     * The LEFT position overrides the BorderLayout's WEST position.
     *
     * @see BorderLayout
     */
    LEFT(BorderLayout.WEST),
    /**
     * The CENTER position overrides the BorderLayout's CENTER position.
     *
     * @see BorderLayout
     */
    CENTER(BorderLayout.CENTER),
    /**
     * The RIGHT position overrides the BorderLayout's EAST position.
     *
     * @see BorderLayout
     */
    RIGHT(BorderLayout.EAST),
    /**
     * The BOTTOM position overrides the BorderLayout's SOUTH position.
     *
     * @see BorderLayout
     */
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