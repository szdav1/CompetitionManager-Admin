package com._2p1team.cmadmin.swing.override.components.label;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

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
        if (!this.getAppearance().isInteractivityEnabled())
            return;

        this.setFont(this.getAppearance().getFontSet().getPressedFont());
        this.setIcon(this.getAppearance().getIconSet().getPressedIcon());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getPressedColor());
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!this.getAppearance().isInteractivityEnabled())
            return;

        this.setFont(this.getAppearance().getFontSet().getReleasedFont());
        this.setIcon(this.getAppearance().getIconSet().getReleasedIcon());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getReleasedColor());
        this.getAppearance().setState(UIState.RELEASED);
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!this.getAppearance().isInteractivityEnabled())
            return;

        this.setFont(this.getAppearance().getFontSet().getHoveredFont());
        this.setIcon(this.getAppearance().getIconSet().getHoveredIcon());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getHoveredColor());
        this.getAppearance().setState(UIState.HOVERED);
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!this.getAppearance().isInteractivityEnabled())
            return;

        this.setFont(this.getAppearance().getFontSet().getDefaultFont());
        this.setIcon(this.getAppearance().getIconSet().getDefaultIcon());
        this.setForeground(this.getAppearance().getForegroundConfiguration().getDefaultColor());
        this.getAppearance().setState(UIState.DEFAULT);
        this.repaint();
    }
}