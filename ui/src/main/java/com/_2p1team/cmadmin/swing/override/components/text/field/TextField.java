package com._2p1team.cmadmin.swing.override.components.text.field;

import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class TextField extends AbstractTextField {
    public TextField(Appearance appearance) {
        super(appearance);
    }

    public TextField() {
    }

    public TextField(Dimension preferredSize, String text, Appearance appearance) {
        super(preferredSize, text, appearance);
    }

    public TextField(Dimension preferredSize, Appearance appearance) {
        super(preferredSize, appearance);
    }

    public TextField(Rectangle bounds, String text, Appearance appearance) {
        super(bounds, text, appearance);
    }

    public TextField(Rectangle bounds, Appearance appearance) {
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
        if (!this.getAppearance().isInteractivityEnabled())
            return;

        this.setFont(this.getAppearance().getFontSet().getPressedFont());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getPressedColor());
        this.setCaretColor(this.getForeground());
        this.getAppearance().setState(UIState.PRESSED);
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!this.getAppearance().isInteractivityEnabled())
            return;

        this.setFont(this.getAppearance().getFontSet().getReleasedFont());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getReleasedColor());
        this.setCaretColor(this.getForeground());
        this.getAppearance().setState(UIState.RELEASED);
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!this.getAppearance().isInteractivityEnabled())
            return;

        this.setFont(this.getAppearance().getFontSet().getHoveredFont());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getHoveredColor());
        this.setCaretColor(this.getForeground());
        this.getAppearance().setState(UIState.HOVERED);
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!this.getAppearance().isInteractivityEnabled())
            return;

        this.setFont(this.getAppearance().getFontSet().getDefaultFont());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getDefaultColor());
        this.setCaretColor(this.getForeground());
        this.getAppearance().setState(UIState.DEFAULT);
        this.repaint();
    }
}