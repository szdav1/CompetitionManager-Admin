package com._2p1team.cmadmin.swing.override.components.button;

import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Button extends AbstractButton {
    public Button(Appearance appearance) {
        super(appearance);
    }

    public Button() {
    }

    public Button(Dimension preferredSize, String text, final Appearance appearance) {
        super(preferredSize, text, appearance);
    }

    public Button(Dimension preferredSize, final Appearance appearance) {
        super(preferredSize, appearance);
    }

    public Button(Rectangle bounds, String text, final Appearance appearance) {
        super(bounds, text, appearance);
    }

    public Button(Rectangle bounds, final Appearance appearance) {
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
        this.setFont(this.getAppearance().getFontSet().getPressedFont());
        this.setIcon(this.getAppearance().getIconSet().getPressedIcon());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getPressedColor());
        this.getAppearance().setState(UIState.PRESSED);
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setFont(this.getAppearance().getFontSet().getReleasedFont());
        this.setIcon(this.getAppearance().getIconSet().getReleasedIcon());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getReleasedColor());
        this.getAppearance().setState(UIState.RELEASED);
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setFont(this.getAppearance().getFontSet().getHoveredFont());
        this.setIcon(this.getAppearance().getIconSet().getHoveredIcon());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getHoveredColor());
        this.getAppearance().setState(UIState.HOVERED);
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setFont(this.getAppearance().getFontSet().getDefaultFont());
        this.setIcon(this.getAppearance().getIconSet().getDefaultIcon());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getDefaultColor());
        this.getAppearance().setState(UIState.DEFAULT);
        this.repaint();
    }
}