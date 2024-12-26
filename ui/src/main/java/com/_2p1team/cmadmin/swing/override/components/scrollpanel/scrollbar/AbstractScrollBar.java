package com._2p1team.cmadmin.swing.override.components.scrollpanel.scrollbar;

import com._2p1team.cmadmin.swing.override.components.scrollpanel.scrollbar.ui.ScrollBarUI;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JScrollBar;

@Getter
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractScrollBar extends JScrollBar {
    private final Appearance appearance;

    public AbstractScrollBar(final int orientation, final Appearance appearance) {
        this.appearance = appearance;

        this.setOrientation(orientation);
        this.revalidate();
        this.repaint();
        this.setUI(new ScrollBarUI(appearance));
    }
}