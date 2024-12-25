package com._2p1team.cmadmin.swing.override.components.panel.scroll.bar.ui;

import com._2p1team.cmadmin.swing.override.graphics.ScrollBarAppearance;
import com._2p1team.cmadmin.swing.override.graphics.ScrollBarPainter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class ScrollBarUI extends BasicScrollBarUI {
    private final ScrollBarAppearance appearance;

    private JButton removeButtons() {
        JButton btn = new JButton();
        btn.setPreferredSize(new Dimension(0, 0));
        btn.setMinimumSize(btn.getPreferredSize());
        btn.setMaximumSize(btn.getPreferredSize());

        return btn;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g;
        ScrollBarPainter.paintTrack(g2, trackBounds, this.appearance);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g;
        ScrollBarPainter.paintTrack(g2, thumbBounds, this.appearance);
    }
}