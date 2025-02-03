package com._2p1team.cmadmin.swing.override.components.scrollpanel.scrollbar;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;
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
@EqualsAndHashCode(callSuper=false)
public final class ScrollBarUI extends BasicScrollBarUI {

    private final Appearance appearance;

    private JButton removeButtons() {
        JButton btn = new JButton();
        Dimension size = new Dimension(0, 0);
        btn.setMinimumSize(size);
        btn.setMaximumSize(size);
        btn.setPreferredSize(size);

        return btn;
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return this.removeButtons();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return this.removeButtons();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g;
        G2DPainter.paintScrollBarTrack(g2, trackBounds, this.appearance);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g;
        G2DPainter.paintScrollBarThumb(g2, thumbBounds, this.appearance);
    }

}