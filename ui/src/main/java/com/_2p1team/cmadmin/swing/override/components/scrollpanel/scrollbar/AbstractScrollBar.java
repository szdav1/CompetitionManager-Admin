package com._2p1team.cmadmin.swing.override.components.scrollpanel.scrollbar;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JScrollBar;

@Getter
@EqualsAndHashCode(callSuper=false)
public abstract class AbstractScrollBar extends JScrollBar {

    private final Appearance appearance;

    public AbstractScrollBar(final int orientation, final Appearance appearance) {
        this.appearance = appearance;

        this.setOrientation(orientation);
        this.setUI(new ScrollBarUI(appearance));
        this.setOpaque(false);
        this.setBorder(null);
        this.revalidate();
        this.repaint();
    }

}