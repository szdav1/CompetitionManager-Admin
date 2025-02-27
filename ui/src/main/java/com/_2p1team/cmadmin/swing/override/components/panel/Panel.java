package com._2p1team.cmadmin.swing.override.components.panel;

import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.constants.UIState;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;

import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Panel extends AbstractPanel {

    public Panel(Appearance appearance) {
        super(appearance);
    }

    public Panel() {
    }

    public Panel(Dimension preferredSize, LayoutManager layout, final Appearance appearance) {
        super(preferredSize, layout, appearance);
    }

    public Panel(Dimension preferredSize, final Appearance appearance) {
        super(preferredSize, appearance);
    }

    public Panel(Rectangle bounds, LayoutManager layout, final Appearance appearance) {
        super(bounds, layout, appearance);
    }

    public Panel(Rectangle bounds, final Appearance appearance) {
        super(bounds, appearance);
    }

    @Override
    public void displayError() {
        this.getAppearance().setState(UIState.ERROR);
        this.repaint();
    }

    @Override
    public void hideError() {
        this.getAppearance().setState(UIState.DEFAULT);
        this.repaint();
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

    @Override
    public void addComponent(final JComponent component, final Position position) {
        this.add(component, this.getLayout() instanceof BorderLayout ? position.getLayoutValue() : position.getPositionValue());
        this.revalidate();
    }

    @Override
    public void addComponent(final JComponent component) {
        this.addComponent(component, this.getLayout() instanceof BorderLayout ? Position.CENTER : Position.MID);
    }

    @Override
    public JComponent removeComponent(final JComponent component) {
        this.remove(component);
        this.revalidate();
        return component;
    }

}