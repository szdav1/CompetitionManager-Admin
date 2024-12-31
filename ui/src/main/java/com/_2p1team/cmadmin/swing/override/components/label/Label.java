package com._2p1team.cmadmin.swing.override.components.label;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;

public class Label extends AbstractLabel {
    public Label() {
    }

    public Label(Dimension preferredSize, String text, Appearance appearance) {
        super(preferredSize, text, appearance);
    }

    public Label(Dimension preferredSize, Appearance appearance) {
        super(preferredSize, appearance);
    }

    public Label(Rectangle bounds, String text, Appearance appearance) {
        super(bounds, text, appearance);
    }

    public Label(Rectangle bounds, Appearance appearance) {
        super(bounds, appearance);
    }

    @Override
    public Appearance getComponentAppearance() {
        return this.getAppearance();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.getAppearance().setState(UIState.PRESSED);
        G2DPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.getAppearance().setState(UIState.RELEASED);
        G2DPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.getAppearance().setState(UIState.HOVERED);
        G2DPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.getAppearance().setState(UIState.DEFAULT);
        G2DPainter.drawComponentUIElements(this);
    }
}