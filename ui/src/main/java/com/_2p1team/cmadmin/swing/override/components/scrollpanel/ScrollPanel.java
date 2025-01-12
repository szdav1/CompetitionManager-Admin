package com._2p1team.cmadmin.swing.override.components.scrollpanel;

import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class ScrollPanel extends AbstractScrollPanel {
    public ScrollPanel() {
    }

    public ScrollPanel(Dimension preferredSize, LayoutManager layout, final Appearance appearance) {
        super(preferredSize, layout, appearance);
    }

    public ScrollPanel(Dimension preferredSize, final Appearance appearance) {
        super(preferredSize, appearance);
    }

    public ScrollPanel(Rectangle bounds, LayoutManager layout, final Appearance appearance) {
        super(bounds, layout, appearance);
    }

    public ScrollPanel(Rectangle bounds, final Appearance appearance) {
        super(bounds, appearance);
    }

    @Override
    public Appearance getComponentAppearance() {
        return this.getAppearance();
    }

    @Override
    public void addComponent(JComponent component, Position position) {
        this.getViewPanel().addComponent(component, position);
    }

    @Override
    public void addComponent(JComponent component) {
        this.getViewPanel().addComponent(component);
    }

    @Override
    public JComponent removeComponent(JComponent component) {
        return this.getViewPanel().removeComponent(component);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}