package com._2p1team.cmadmin.swing.override.components.panel.scroll.bar;

import com._2p1team.cmadmin.swing.override.graphics.ScrollBarAppearance;

import java.awt.Dimension;

public class CustomScrollBar extends AbstractScrollBar {
    public CustomScrollBar(ScrollBarAppearance appearance) {
        super(appearance);
    }

    public CustomScrollBar(Dimension preferredSize, int orientation, ScrollBarAppearance appearance) {
        super(preferredSize, orientation, appearance);
    }

    public CustomScrollBar(int orientation, ScrollBarAppearance appearance) {
        super(orientation, appearance);
    }
}