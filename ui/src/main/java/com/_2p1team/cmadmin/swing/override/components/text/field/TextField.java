package com._2p1team.cmadmin.swing.override.components.text.field;

import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class TextField extends AbstractTextField {

    public TextField(Appearance appearance) {
        super(appearance);
    }

    public TextField() {
    }

    public TextField(Dimension preferredSize, String text, final Appearance appearance) {
        super(preferredSize, text, appearance);
    }

    public TextField(Dimension preferredSize, final Appearance appearance) {
        super(preferredSize, appearance);
    }

    public TextField(Rectangle bounds, String text, final Appearance appearance) {
        super(bounds, text, appearance);
    }

    public TextField(Rectangle bounds, final Appearance appearance) {
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
        this.repaint();
        this.revalidate();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.getAppearance().setState(UIState.RELEASED);
        G2DPainter.drawComponentUIElements(this);
        this.repaint();
        this.revalidate();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.getAppearance().setState(UIState.HOVERED);
        G2DPainter.drawComponentUIElements(this);
        this.repaint();
        this.revalidate();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.getAppearance().setState(UIState.DEFAULT);
        G2DPainter.drawComponentUIElements(this);
        this.repaint();
        this.revalidate();
    }

}