package com._2p1team.cmadmin.swing.override.components.text.area;

import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.ComponentPainter;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class TextArea extends AbstractTextArea {
    public TextArea(Appearance appearance) {
        super(appearance);
    }

    public TextArea() {
    }

    public TextArea(Dimension preferredSize, String text, Appearance appearance) {
        super(preferredSize, text, appearance);
    }

    public TextArea(Dimension preferredSize, Appearance appearance) {
        super(preferredSize, appearance);
    }

    public TextArea(Rectangle bounds, String text, Appearance appearance) {
        super(bounds, text, appearance);
    }

    public TextArea(Rectangle bounds, Appearance appearance) {
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
        ComponentPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.getAppearance().setState(UIState.RELEASED);
        ComponentPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.getAppearance().setState(UIState.HOVERED);
        ComponentPainter.drawComponentUIElements(this);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.getAppearance().setState(UIState.DEFAULT);
        ComponentPainter.drawComponentUIElements(this);
    }
}