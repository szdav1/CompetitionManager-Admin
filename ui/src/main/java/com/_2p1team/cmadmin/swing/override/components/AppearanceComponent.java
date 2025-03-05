package com._2p1team.cmadmin.swing.override.components;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import java.awt.event.MouseListener;

/**
 * The AppearanceComponent interface specifies a component
 * that uses an Appearance object to draw its UI.
 *
 * @see Appearance
 */
public interface AppearanceComponent extends MouseListener {

    /**
     * Returns the Appearance of this component.
     *
     * @return The Appearance used by this component
     */
    Appearance getComponentAppearance();

    /**
     * Sets the state of the component's Appearance
     * to the error state.
     */
    void displayError();

    /**
     * Resets the state of the component's Appearance to default.
     */
    void hideError();

}