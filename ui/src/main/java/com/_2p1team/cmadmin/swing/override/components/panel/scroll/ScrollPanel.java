package com._2p1team.cmadmin.swing.override.components.panel.scroll;

import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.ScrollBarAppearance;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

// TODO: Check and finish the scroll panel
public class ScrollPanel extends AbstractScrollPanel {
    public ScrollPanel(Appearance panelAppearance, ScrollBarAppearance scrollBarAppearance, Panel viewPort) {
        super(panelAppearance, scrollBarAppearance, viewPort);
    }

    public ScrollPanel() {
    }

    public ScrollPanel(Dimension preferredSize, LayoutManager layout, Appearance panelAppearance, ScrollBarAppearance scrollBarAppearance) {
        super(preferredSize, layout, panelAppearance, scrollBarAppearance);
    }

    public ScrollPanel(Dimension preferredSize, Appearance panelAppearance, ScrollBarAppearance scrollBarAppearance) {
        super(preferredSize, panelAppearance, scrollBarAppearance);
    }

    @Override
    public Appearance getComponentAppearance() {
        return this.getPanelAppearance();
    }

    @Override
    public void addComponent(JComponent component, Position position) {

    }

    @Override
    public void addComponent(JComponent component) {

    }

    @Override
    public JComponent removeComponent(JComponent component) {
        return null;
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