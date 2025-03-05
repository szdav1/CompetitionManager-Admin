package com._2p1team.cmadmin.swing.override.components.scrollpanel.scrollbar;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import javax.swing.JScrollBar;

/**
 * The Scrollbar class is the custom representation of Swing's
 * JScrollbar and awt's Scrollbar class. As every custom UI component,
 * this class determines its visual representation based on the
 * specified Appearance object.
 *
 * @see JScrollBar
 * @see AbstractScrollBar
 * @see ScrollBarUI
 */
public class CustomScrollBar extends AbstractScrollBar {

    /**
     * Constructs a CustomScrollBar using the specified Appearance and orientation.
     *
     * @param orientation The orientation of the scroll bar
     * @param appearance  The Appearance class that describes the UI attributes of this component
     */
    public CustomScrollBar(int orientation, Appearance appearance) {
        super(orientation, appearance);
    }

}