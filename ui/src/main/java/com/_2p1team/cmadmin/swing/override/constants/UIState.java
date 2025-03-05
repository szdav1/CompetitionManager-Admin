package com._2p1team.cmadmin.swing.override.constants;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;

/**
 * The UIState enum defines states for Appearances.
 *
 * @see Appearance
 */
public enum UIState {
    /**
     * DEFAULT - The component is in default state
     */
    DEFAULT,
    /**
     * HOVERED - The component has been entered by the cursor
     */
    HOVERED,
    /**
     * PRESSED - A mouse button has been pressed while the cursor
     * is hovering the component
     */
    PRESSED,
    /**
     * RELEASED - A mouse button has been released while the cursor
     * is hovering the component
     */
    RELEASED,
    /**
     * ERROR - An error occurred in the control logic, the component should trigger its
     * error background found in its Appearance.
     */
    ERROR;
}