package com._2p1team.cmadmin.swing.override.components.scrollpanel.scrollbar;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JScrollBar;
import java.awt.Dimension;
import java.awt.Toolkit;

@Getter
@EqualsAndHashCode(callSuper=false)
public abstract class AbstractScrollBar extends JScrollBar {

    private final Appearance appearance;
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();


    public AbstractScrollBar(final int orientation, final Appearance appearance) {
        this.appearance = appearance;

        this.setOrientation(orientation);
        this.setUI(new ScrollBarUI(appearance));
        this.setOpaque(false);
        this.setBorder(null);
        this.setPreferredSize(new Dimension(
            SCREEN_SIZE.width/150,
            orientation == JScrollBar.HORIZONTAL ? SCREEN_SIZE.width/150 : SCREEN_SIZE.height*2/100
        ));
        this.revalidate();
        this.repaint();
    }

}