package com._2p1team.cmadmin.swing.override.components.panel.scroll.bar;

import com._2p1team.cmadmin.swing.override.components.panel.scroll.bar.ui.ScrollBarUI;
import com._2p1team.cmadmin.swing.override.graphics.ScrollBarAppearance;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JScrollBar;
import java.awt.Dimension;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractScrollBar extends JScrollBar {
    private final ScrollBarAppearance appearance;

    public AbstractScrollBar(Dimension preferredSize, final int orientation, final ScrollBarAppearance appearance) {
        this.appearance = appearance;

        this.setBorder(null);
        this.setFocusable(false);
        this.setOrientation(orientation);
        this.setUI(new ScrollBarUI(appearance));
        this.setPreferredSize(preferredSize);
    }

    public AbstractScrollBar(final int orientation, final ScrollBarAppearance appearance) {
        this(
            orientation == JScrollBar.VERTICAL ?
                new Dimension(10, 10) : // TODO: Change to proportional value
                new Dimension(20, 20), // TODO: Change to proportional value
            orientation,
            appearance
        );
    }
}