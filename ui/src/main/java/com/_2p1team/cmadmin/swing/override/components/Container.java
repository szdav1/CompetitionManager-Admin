package com._2p1team.cmadmin.swing.override.components;

import com._2p1team.cmadmin.swing.override.constants.Position;

import javax.swing.JComponent;

/**
 * The Container interface specifies a component that is marked
 * as a container in by default in Swing. It provides some basic method overrides
 * for adding and removing components from the container, using custom specified
 * positions.
 *
 * @see Position
 */
public interface Container {

    /**
     * Adds the specified JComponent to the display area of this container
     * at the specified position.
     *
     * @param component The component that should be added to the display of this container
     * @param position  The position on which the specified JComponent should be located at
     */
    void addComponent(final JComponent component, final Position position);

    /**
     * Adds the specified JComponent to the display area of this container
     * at the default position.
     *
     * @param component The component that should be added to the display of this container
     */
    void addComponent(final JComponent component);

    /**
     * Removes the specified component from the display area of this
     * container.
     *
     * @param component The component that should be removed from the display of this container.
     * @return The specified component
     */
    JComponent removeComponent(final JComponent component);

}